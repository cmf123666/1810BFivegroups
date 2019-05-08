package com.jk.control;

import com.jk.bean.LandlordBean;
import com.jk.service.LandlordService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LandlordController {
    @Autowired
    LandlordService landlordService;

    //查询房东合同
    @RequestMapping("queryLandlord")
    public  String queryLandlord(Model model, HttpServletRequest request){
        String id = request.getSession().getId();
        LandlordBean landlordBean = landlordService.queryLandlord(id);
        model.addAttribute("l",landlordBean);
        return "Cleared";
    }
    @RequestMapping("goLandlord")
    public  String goLandlord(Model model, HttpServletRequest request){
        return "findLandlord";
    }
    @RequestMapping("findLandlord")
    @ResponseBody
    public HashMap<String ,Object> findLandlord(LandlordBean landlordBean){
        return landlordService.findLandlord(landlordBean);
    }
    @RequestMapping("PerfectAndViewDetails")
    public String Perfect(Integer id,Model model,Integer status,Integer contractMethod){
        if(status == 1 || status == 2){
            LandlordBean landlordBean = landlordService.ViewDetails(id,contractMethod);
            model.addAttribute("l",landlordBean);
            return "ViewDetails";
        }else {
            LandlordBean landlordBean= new LandlordBean();
            landlordBean.setLid(id);
            model.addAttribute("l",landlordBean);
            return "Perfect";
        }

    }

    @RequestMapping("addDetailsForm")
    @ResponseBody
    public String addDetailsForm(LandlordBean landlordBean){
        landlordService.addDetailsForm(landlordBean);
        return null;
    }
    @RequestMapping("cleared")
    public String cleared(Integer id,Model model,Integer contractMethod){
        LandlordBean landlordBean = landlordService.cleared(id,contractMethod);
        model.addAttribute("l",landlordBean);
        return "Cleared";
    }

}
