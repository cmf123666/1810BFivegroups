package com.jk.service;

import com.jk.bean.RenterBean;

import java.util.HashMap;

public interface TenantService {
    HashMap<String, Object> findTenantList(Integer page, Integer rows, RenterBean renterBean);

    RenterBean findTenantListById(String rid);


}
