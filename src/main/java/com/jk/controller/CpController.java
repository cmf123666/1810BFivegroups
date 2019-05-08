package com.jk.controller;

import com.jk.bean.Postbean;
import com.jk.service.CpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Controller
public class CpController {
    @Resource
    CpService cpService;
    /*跳转到职位配置页面*/
  @RequestMapping("zhifu")
    public String  zhifu(){
      return "zhiwu";
  }
   /*跳转到新增修改页面*/
    @RequestMapping("getzhifu")
    public String  getzhifu(){
        return "zhifu";
    }
    /*查询职位带分页*/
    @RequestMapping("findzhiwei")
    @ResponseBody
    public HashMap<String,Object> findzhiwei(Integer pageSize,Integer start){

        HashMap<String,Object> map= cpService.findzhiwei(pageSize,start);

        return map;
    }
    /*职位回显到页面*/
    @RequestMapping("findzhiweis")
    public String  findzhiweis(Integer id, Model model){
        Postbean Postbean=  cpService.findzhiweis(id);
        model.addAttribute("c",Postbean);
        return "zhifu";
    }
    /*职位修改和新增*/
    @RequestMapping("addzhiwei")
    @ResponseBody
    public void addzhiwei(Postbean postbean){
      if(postbean.getPid()!=""){
          cpService.updatezhiwei(postbean);

      }else{
          postbean.setPdate(new Date());
          cpService.addzhiwei(postbean);
      }
    }
    /*职位删除*/
    @RequestMapping("delzhiwei")
    @ResponseBody
    public void delzhiwei(String id){
        cpService.delzhiwei(id);
    }

}
