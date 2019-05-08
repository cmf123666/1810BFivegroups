package com.jk.service.impl;

import com.jk.bean.LandlordBean;
import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.jk.bean.UserBean;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginService;
import com.jk.utils.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserBean login(UserBean userBean) {
        return loginMapper.login(userBean);
    }

    @Override
    public String getCode(String phoneNumber) {
        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        Map<String,Object> map=new HashMap<>();
        map.put("mobile",phoneNumber);
        map.put("tpl_id","156181");
        map.put("tpl_value","#code#="+code);
        map.put("key","ba722a290828a9b2fc320ca447c1adcf");
        HttpClient.sendGet("http://v.juhe.cn/sms/send",map);
        return code;
    }

    @Override
    public UserBean findUserByPhone(String phoneNumber) {
        return loginMapper.findUserByPhone(phoneNumber);
    }

    @Override
    public void updLastDate(UserBean userBean) {
        loginMapper.updLastDate(userBean);
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
