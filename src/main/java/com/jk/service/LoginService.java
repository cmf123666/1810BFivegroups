package com.jk.service;

import com.jk.bean.UserBean;

public interface LoginService {
    UserBean login(UserBean userBean);

    void updLastDate(UserBean user);

    UserBean findUserByPhone(String phoneNumber);

    String getCode(String phoneNumber);
}
