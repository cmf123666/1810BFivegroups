package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.UserBean;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("user")
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("login4")
    @ResponseBody
    public String login(UserBean userBean, HttpServletRequest request){
        UserBean user=loginService.login(userBean);
        if (user!=null){

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



}
