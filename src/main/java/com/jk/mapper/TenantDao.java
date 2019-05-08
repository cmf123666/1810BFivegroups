package com.jk.mapper;

import com.jk.bean.RenterBean;
import com.jk.bean.payType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TenantDao {

    List<RenterBean> findTenantList(RenterBean renterBean);

   RenterBean findTenantListById(String rid);


}
