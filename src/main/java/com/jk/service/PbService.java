package com.jk.service;

import com.jk.bean.RenterBean;

import java.util.HashMap;

public interface PbService {
    HashMap<String,Object> query(Integer page, Integer rows, RenterBean renterBean);
}
