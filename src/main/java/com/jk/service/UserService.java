package com.jk.service;

import com.jk.bean.Postbean;
import com.jk.bean.UserBean;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    HashMap<String, Object> findUserList(Integer page, Integer rows);

    List<Postbean> findPostList();

    void saveUser(UserBean userBean);

    UserBean fingUserInfoById(String id);

    void updateUser(UserBean userBean);

    String deleteUserById(String id,String userId);
}
