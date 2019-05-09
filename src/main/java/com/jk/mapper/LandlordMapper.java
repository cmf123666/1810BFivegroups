package com.jk.mapper;

import com.jk.bean.LandlordBean;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface LandlordMapper {
    LandlordBean queryLandlord(@Param("id") String id);

    List<LandlordBean> findLandlord(LandlordBean landlordBean);

    LandlordBean ViewDetails(@Param("id") Integer id);

    LandlordBean ViewDetails2(@Param("id") Integer id);

    void addDetailsForm(LandlordBean landlordBean);

    void addDetailsForm2(LandlordBean landlordBean);

    void updateDetails(@Param("id") Integer lid);

    void updateLandlord2(LandlordBean landlordBean);

    void updateLandlord(LandlordBean landlordBean);

    void removeLandlord(@Param("id") Integer id);

}
