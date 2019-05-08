package com.jk.service;

import com.jk.bean.Postbean;
import com.jk.bean.UserBean;
import com.jk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    //用户表查询展示
    @Override
    public HashMap<String, Object> findUserList(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        int total = userMapper.findUserCount();
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<UserBean> list = userMapper.findUserList(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }
    /*查询角色表*/
    @Override
    public List<Postbean> findPostList() {
        return userMapper.findPostList();
    }
    /*新增人员表*/
    @Override
    public void saveUser(UserBean userBean) {
        HashMap<String, Object> hashMap = new HashMap<>();

        userMapper.saveUser(userBean);
    }
    /*根据ID回显人员表*/
    @Override
    public UserBean fingUserInfoById(String id) {
        return userMapper.fingUserInfoById(id);
    }
    /*修改人员表*/
    @Override
    public void updateUser(UserBean userBean) {
        userMapper.updateUser(userBean);
    }

    /*删除*/
    @Override
    public String deleteUserById(String id,String userId) {
        /*关联租客表*/
       List<UserBean> list = userMapper.queryUserByshouId(userId);
       /*对应房东表*/
        List<UserBean> list1 = userMapper.queryUserByzhiId(userId);
        /*判断用户表下是否有节点    没有就删除*/
        if(list.size()==0 && list1.size()==0){
            userMapper.deleteUserById(id);
            return "0";
        }else{
            return "1";
        }
    }
}
