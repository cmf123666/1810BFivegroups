package com.jk.service;

import com.jk.bean.RenterBean;
import com.jk.bean.payType;

import java.util.List;

public interface TenantService {
    List<RenterBean> findTenantList(RenterBean renterBean);

    RenterBean findTenantListById(String rid);


}
