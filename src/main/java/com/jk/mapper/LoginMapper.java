package com.jk.mapper;

import com.jk.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {

    UserBean login(@Param("userBean") UserBean userBean);

    UserBean findUserByPhone(@Param("phoneNumber") String phoneNumber);

    void updLastDate(@Param("u") UserBean userBean);
}
