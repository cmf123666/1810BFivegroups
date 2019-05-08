package com.jk.mapper;

import com.jk.bean.LandlordBean;
import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.jk.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {

    UserBean login(@Param("userBean") UserBean userBean);

    UserBean findUserByPhone(@Param("phoneNumber") String phoneNumber);

    void updLastDate(@Param("u") UserBean userBean);


    double findShouru(@Param("l") LiushuiBean liushui);

    double findZhichu(@Param("l") LiushuiBean liushui);
}
