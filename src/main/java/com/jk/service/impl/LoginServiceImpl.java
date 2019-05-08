package com.jk.service.impl;

import com.jk.bean.LandlordBean;
import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.bean.UserBean;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class LoginServiceImpl implements  LoginService{
    @Reference
    LoginService loginService;


    @Autowired
    LoginMapper loginMapper;
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

    @Override
    public double findShouru(LiushuiBean liushui) {
        return loginMapper.findShouru(liushui);
    }

    @Override
    public double findZhichu(LiushuiBean liushui) {
        return loginMapper.findZhichu(liushui);
    }


}
