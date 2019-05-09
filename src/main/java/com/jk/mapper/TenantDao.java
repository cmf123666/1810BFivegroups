package com.jk.mapper;

import com.jk.bean.RenterBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface TenantDao {


   RenterBean findTenantListById(String rid);

   
    List<RenterBean> findTenantList(HashMap<String, Object> hashMap2);

    int findTenantCount(HashMap<String, Object> hashMap2);
}
