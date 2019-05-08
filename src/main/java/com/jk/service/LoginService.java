package com.jk.service;

import com.jk.bean.LandlordBean;
import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.jk.bean.UserBean;

import java.util.List;

public interface LoginService {

    UserBean login(UserBean userBean);

    String getCode(String phoneNumber);

    UserBean findUserByPhone(String phoneNumber);

    void updLastDate(UserBean userBean);

    double findShouru(LiushuiBean liushui);

    double findZhichu(LiushuiBean liushui);
}
