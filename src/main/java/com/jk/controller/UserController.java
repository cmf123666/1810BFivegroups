package com.jk.controller;

import com.jk.bean.Postbean;
import com.jk.bean.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    //人员配置  根据ID查询展示
    @RequestMapping("findUserList")
    @ResponseBody
    public HashMap<String, Object> findUserList(Integer page, Integer rows) {
        return userService.findUserList(page,rows);
    }
    //查询角色表
    @RequestMapping("findPostList")
    @ResponseBody
    public List<Postbean> findPostList(){
        List<Postbean> list = userService.findPostList();
        return  list;
    }
    /*新增人员表和修改*/
    @RequestMapping("saveUserOrUpdate")
    @ResponseBody
    public Boolean saveUser(UserBean userBean) {
        if (userBean.getUid() == ""){
            userService.saveUser(userBean);
        }else{
            userService.updateUser(userBean);
        }
       return true;
    }
    /*修改人员表回显*/
    @RequestMapping("fingUserInfoById")
    public String fingUserInfoById(String id, Model model) {
       UserBean userBean = userService.fingUserInfoById(id);
        model.addAttribute("userBean", userBean);
        return "addOrUpdateUser"; // 直接从查询页面跳到新增+修改页面
    }
    /*删除*/
    @RequestMapping("deleteUserById")
    @ResponseBody
    public String deleteUserById(String id,String userId) {
        return userService.deleteUserById(id,userId);
    }
}
