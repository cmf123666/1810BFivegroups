package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /*用户展示*/
    @RequestMapping("findUser")
    public String fingUserList(){
        return "userlist";
    }
    /*用户新增*/
    @RequestMapping("addOrUpdateUser")
    public String addOrUpdateUser(){
        return "addOrUpdateUser";
    }

}
