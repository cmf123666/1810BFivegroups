package com.jk.service.impl;

import com.jk.bean.RenterBean;
import com.jk.mapper.TenantDao;
import com.jk.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantDao tenantDao;

    @Override
    public List<RenterBean> findTenantList(RenterBean renterBean) {
        List<RenterBean> list =   tenantDao.findTenantList(renterBean);
        return list;
    }

    @Override
    public RenterBean findTenantListById(String rid) {
        return tenantDao.findTenantListById(rid);
    }


}
