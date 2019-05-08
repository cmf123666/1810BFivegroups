package com.jk.service;

import com.jk.bean.LandlordBean;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface LandlordService {

    LandlordBean queryLandlord(String id);

    HashMap<String, Object> findLandlord(LandlordBean landlordBean);

    LandlordBean ViewDetails(Integer id, Integer contractMethod);

    void addDetailsForm(LandlordBean landlordBean);

    LandlordBean cleared(Integer id,Integer contractMethod);

    void removeLandlord(Integer id);
}
