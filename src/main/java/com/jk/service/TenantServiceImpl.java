package com.jk.service;

import com.jk.bean.RenterBean;
import com.jk.bean.payType;
import com.jk.dao.TenantDao;
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
