package com.jk.mapper;

import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PbMapper {
    Integer count();

    List<RenterBean> query(@Param("page") Integer page, @Param("rows") Integer rows, RenterBean renterBean);

    Integer count1();

    List<RenterBean> query1(@Param("page") Integer page, @Param("rows") Integer rows, LiushuiBean liushuiBean);

    void delete(Integer rid);

    void add(@Param("renterlocation") String renterlocation, @Param("renterNumber") String renterNumber, @Param("renterName") String renterName, @Param("billCount") Integer billCount, @Param("billType") Integer billType, @Param("payDate") String payDate, @Param("payType") Integer payType);

    int getcount(@Param("b") LiushuiBean liushuiBean);

     List<LiushuiBean> query2(@Param("page") int i, @Param("rows") Integer rows, @Param("b") LiushuiBean liushuiBean);

      void addliushui(@Param("l") LiushuiBean liushuiBean);
@Select("select * from mayLiushui where LiushuiId = #{lid}")
    LiushuiBean theMost(@Param("lid") String lid);
}
