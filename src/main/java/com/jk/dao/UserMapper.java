package com.jk.dao;
import com.jk.bean.Postbean;
import com.jk.bean.UserBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserMapper {

    /*查询总条数*/
    @Select("select count(*) from mayuser")
    int findUserCount();

    List<UserBean> findUserList(HashMap<String, Object> hashMap2);
    /*查询角色表*/
    @Select("select * from maypost")
    List<Postbean> findPostList();
    void saveUser(UserBean userBean);
    UserBean fingUserInfoById(String id);

    void updateUser(UserBean userBean);

    List<UserBean> queryUserByshouId(String userId);

    List<UserBean> queryUserByzhiId(String userId);

    void deleteUserById(String id);
}
