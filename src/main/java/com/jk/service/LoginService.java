package com.jk.service;

import com.jk.bean.UserBean;

public interface LoginService {

    UserBean login(UserBean userBean);

    String getCode(String phoneNumber);

    UserBean findUserByPhone(String phoneNumber);

    void updLastDate(UserBean userBean);
}
