package com.jk.service.impl;

import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.jk.mapper.PbMapper;
import com.jk.service.PbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PbServiceImpl implements PbService {
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

    @Override
    public void delete(Integer rid) {
        pbMapper.delete(rid);
    }

    @Override
    public void add(String renterlocation, Integer rid, String renterNumber, String renterName, Integer billCount, Integer billType, String payDate, Integer payType) {
        pbMapper.add(renterlocation,renterNumber,renterName,billCount,billType,payDate,payType);
    }

   @Override
    public HashMap<String, Object> query2(Integer page, Integer rows, LiushuiBean liushuiBean) {
        int count = pbMapper.getcount(liushuiBean);
        List<LiushuiBean> list = pbMapper.query2((page-1)*rows,rows,liushuiBean);
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("total",count);
        hashmap.put("rows",list);
        return hashmap;
    }

    @Override
    public void addliushui(LiushuiBean liushuiBean) {

        pbMapper.addliushui(liushuiBean);
    }

    @Override
    public LiushuiBean theMost(String lid) {
        LiushuiBean liushuiBean = pbMapper.theMost(lid);
        System.out.println();
        return  liushuiBean;
    }
}
