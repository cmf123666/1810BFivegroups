package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转页面的控制类
 */
@Controller
public class ViewController {

    //  去登陆页面
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("login2")
    public String login2(){
        return "login2";
    }

    @RequestMapping("login3")
    public String login3(){
        return "login3";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("tree")
    public String tree(){ return "Tree"; }
}
