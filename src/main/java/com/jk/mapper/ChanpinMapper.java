package com.jk.mapper;

import com.jk.bean.Postbean;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChanpinMapper {


     @Select("select count(*) from maypost")
    long findzhiweicount();

    @Select("select * from maypost Limit #{start},#{pageSize}")
    List<Postbean> findzhiwei(@Param("pageSize") Integer pageSize,@Param("start")Integer start);

    @Select("select * from maypost where pid =#{id}")
    Postbean findzhiweis(@Param("id")Integer id);

    void addzhiwei(Postbean postbean);

    void updatezhiwei(Postbean postbean);
    @Delete("delete from maypost where pid=#{id}")
    void delzhiwei(@Param("id")String id);
}
