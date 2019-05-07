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

  @RequestMapping("zhifu")
    public String  zhifu(){
      return "zhiwu";
  }

    @RequestMapping("getzhifu")
    public String  getzhifu(){
        return "zhifu";
    }
    @RequestMapping("findzhiwei")
    @ResponseBody
    public HashMap<String,Object> findzhiwei(Integer pageSize,Integer start){

        HashMap<String,Object> map= cpService.findzhiwei(pageSize,start);

        return map;
    }

    @RequestMapping("findzhiweis")
    public String  findzhiweis(Integer id, Model model){
        Postbean Postbean=  cpService.findzhiweis(id);
        model.addAttribute("c",Postbean);
        return "zhifu";
    }

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
    @RequestMapping("delzhiwei")
    @ResponseBody
    public void delzhiwei(String id){
        cpService.delzhiwei(id);
    }

}
