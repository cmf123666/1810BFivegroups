package com.jk.service;

import com.jk.bean.Postbean;

import java.util.HashMap;

public interface CpService {



    HashMap<String, Object> findzhiwei(Integer pageSize, Integer start);

    Postbean findzhiweis(Integer id);

    void addzhiwei(Postbean postbean);

    void updatezhiwei(Postbean postbean);

    void delzhiwei(String id);
}
