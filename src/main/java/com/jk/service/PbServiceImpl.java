package com.jk.service;

import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.jk.mapper.PbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PbServiceImpl implements PbService{
    @Autowired
    PbMapper pbMapper;

    @Override
    public HashMap<String, Object> query(Integer page, Integer rows, RenterBean renterBean) {
       Integer count = pbMapper.count();
       List<RenterBean> list = pbMapper.query((page-1)*rows,rows,renterBean);
       HashMap<String,Object> map = new HashMap<>();
       map.put("total",count);
       map.put("rows",list);
       return map;
    }

    @Override
    public HashMap<String, Object> query1(Integer page, Integer rows, LiushuiBean liushuiBean) {
        Integer count = pbMapper.count1();
        List<RenterBean> list = pbMapper.query1((page-1)*rows,rows,liushuiBean);
        HashMap<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }
}
