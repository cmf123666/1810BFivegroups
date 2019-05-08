package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.MenuTree;
import com.jk.bean.UserBean;
import com.jk.service.LoginService;
import com.jk.service.TreeService;
import com.jk.utils.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("user")
@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    TreeService treeService;



    @RequestMapping("login4")
    @ResponseBody
    public String login(UserBean userBean, HttpServletRequest request){
        UserBean user=loginService.login(userBean);
        if (user!=null){
            //登陆成功修改最后登陆时间
            user.setEndTime(new Date());
            loginService.updLastDate(user);

//设置一个账号一天只能登陆三次
            ValueOperations ops = redisTemplate.opsForValue();
            List<String> list=new ArrayList<>();
            if (ops.get(userBean.getUserId())!=null){
                list= JSON.parseArray((String) ops.get(userBean.getUserId()),String.class);
                if (list.size()==3){
                    return "已经登陆三次";
                }
            }
            list.add(userBean.getUserId());
            ops.set(userBean.getUserId(),JSON.toJSONString(list));
//判断超过一天可以重新登陆三次 60*60*24
            ops.set(userBean.getUserId(),JSON.toJSONString(list),30, TimeUnit.SECONDS);
            Long expire = redisTemplate.getExpire(userBean.getUserId());
            if (expire==0){
                redisTemplate.delete(userBean.getUserId());
            }


            HttpSession session=request.getSession();
            session.setAttribute("user",userBean);
            return "登陆成功";
        }
        return "账号或密码错误！！！";
    }


    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(String phoneNumber, HttpServletRequest request){
        UserBean userBean=loginService.findUserByPhone(phoneNumber);
        if (userBean!=null){
            String str=loginService.getCode(phoneNumber);
            HttpSession session = request.getSession();
            session.setAttribute("code",str);
            session.setMaxInactiveInterval(60);
            return str;
        }
        return "请输入正确的手机号";
    }

    @RequestMapping("phoneLogin")
    @ResponseBody
    public String phoneLogin(String code, HttpServletRequest request){
        HttpSession session = request.getSession();
        String str= (String) session.getAttribute("code");
        if(code.equals(str)){
            return "登陆成功";
        }
        return "验证码错误！！！";
    }



    @RequestMapping("getTreeAll")
    public @ResponseBody
    List<MenuTree> getTreeAll(){
        List<MenuTree> list = treeService.getTreeAll();
        //将 数据库中返回的数据转换成easyui识别的数据格式
        list=TreeNoteUtil.getFatherNode(list);
        return list;
    }


}
