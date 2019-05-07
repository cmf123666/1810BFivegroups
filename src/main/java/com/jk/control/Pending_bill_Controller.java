package com.jk.control;

import com.jk.bean.RenterBean;
import com.jk.service.PbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class Pending_bill_Controller {
    @Autowired
    PbService pbService;
    /*页面跳转*/
    @RequestMapping("Pbill")
    public String Pbill(){
        return "Pending_bill";
    }
    /*查询方法*/
    @RequestMapping("query")
    @ResponseBody
    public HashMap<String,Object> query(Integer page, Integer rows, RenterBean renterBean){
        return pbService.query(page,rows,renterBean);
    }

}
