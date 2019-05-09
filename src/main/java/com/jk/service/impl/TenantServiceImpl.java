package com.jk.service.impl;

import com.jk.bean.RenterBean;
import com.jk.mapper.TenantDao;
import com.jk.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantDao tenantDao;

    @Override
    public HashMap<String, Object> findTenantList(Integer page, Integer rows, RenterBean renterBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("renterBean",renterBean);
        int total = tenantDao.findTenantCount(hashMap2);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<RenterBean> list = tenantDao.findTenantList(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;

    }

    @Override
    public RenterBean findTenantListById(String rid) {
        return tenantDao.findTenantListById(rid);
    }


}
