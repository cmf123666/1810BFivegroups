package com.jk.mapper;

import com.jk.bean.RenterBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PbMapper {
    Integer count();

    List<RenterBean> query(@Param("page") Integer page, @Param("rows")Integer rows, RenterBean renterBean);
}
