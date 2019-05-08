package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.bean.UserBean;
import com.jk.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{
    @Reference
    LoginService loginService;


    public UserBean login(UserBean userBean) {
        return  loginService.login(userBean);
    }


    public String getCode(String phoneNumber) {
        return loginService.getCode(phoneNumber);
    }


    public UserBean findUserByPhone(String phoneNumber) {
        return loginService.findUserByPhone(phoneNumber);
    }


    public void updLastDate(UserBean userBean) {
        loginService.updLastDate(userBean);
    }
}
