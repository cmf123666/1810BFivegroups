package com.jk.controller;

import com.jk.bean.RenterBean;
import com.jk.bean.UserBean;
import com.jk.bean.payType;
import com.jk.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class TenantController {

  @Autowired
  TenantService  tenantService;

  //查询租客 --页面展示
  @RequestMapping("findTenantList")
  @ResponseBody
  public HashMap<String, Object>findTenantList(Integer page, Integer rows, RenterBean renterBean){

    return  tenantService.findTenantList(page,rows,renterBean);
  }




  @RequestMapping("findTenantListById")
  @ResponseBody
  public RenterBean findTenantListById(String rid){
      RenterBean list=tenantService.findTenantListById(rid);

     return list;
  }

  //查询主租客页面
  @RequestMapping("toTenant")
  public  String toTenant(){
    return "tenantShow";

  }

}
