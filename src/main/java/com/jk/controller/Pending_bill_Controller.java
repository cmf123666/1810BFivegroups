package com.jk.controller;

import com.jk.bean.LiushuiBean;
import com.jk.bean.RenterBean;
import com.jk.service.PbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.SimpleFormatter;

@Controller
public class Pending_bill_Controller {
    @Autowired
    PbService pbService;
    /*页面跳转*/
    @RequestMapping("Pbill")
    public String Pbill(){
        return "Pending_bill";
    }
    @RequestMapping("Cbill")
    public String Cbill(){
        return "Colect_bill";
    }

    @RequestMapping("charge")
    public String charge(){
        return "chargePage";
    }

    /*查询方法*/
    @RequestMapping("query")
    @ResponseBody
    public HashMap<String,Object> query(Integer page, Integer rows, RenterBean renterBean){
        return pbService.query(page,rows,renterBean);
    }
    /*支*/
    @RequestMapping("query1")
    @ResponseBody
    public HashMap<String,Object> query1(Integer page, Integer rows, LiushuiBean liushuiBean){
        return pbService.query1(page,rows,liushuiBean);
    }
    @RequestMapping("add")
    @ResponseBody
    public String add(String renterlocation,Integer rid,String renterNumber,String renterName,Integer billCount,Integer billType,String payDate,Integer payType ){
        pbService.delete(rid);
        pbService.add(renterlocation,rid,renterNumber,renterName,billCount,billType,payDate,payType);
        return null;
    }
    //查询搜索加分页
     @RequestMapping("query2")
      @ResponseBody
    public HashMap<String ,Object> query2(Integer page,Integer rows,LiushuiBean liushuiBean){
        return   pbService.query2(page,rows,liushuiBean);
     }

    //添加流水的方法
    @RequestMapping("addliushui")
    @ResponseBody
    public String addliushui(LiushuiBean liushuiBean) throws ParseException {

        pbService.addliushui(liushuiBean);

         return null;
    }

    @RequestMapping("theMost")
    @ResponseBody
    public LiushuiBean  theMost(String lid){

        LiushuiBean  bean  = pbService.theMost(lid);

        return bean;
    }




}
