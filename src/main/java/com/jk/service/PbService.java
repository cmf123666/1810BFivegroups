package com.jk.service;

import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;

import java.util.HashMap;

public interface PbService {
    HashMap<String,Object> query(Integer page, Integer rows, RenterBean renterBean);
    HashMap<String,Object> query1(Integer page, Integer rows, LiushuiBean liushuiBean);

    void delete(Integer rid);

    void add(String renterlocation, Integer rid, String renterNumber, String renterName, Integer billCount, Integer billType, String payDate, Integer payType);

    HashMap<String, Object> query2(Integer page, Integer rows, LiushuiBean liushuiBean);

    void addliushui(LiushuiBean liushuiBean);

    LiushuiBean theMost(String lid);
}
