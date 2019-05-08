package com.jk.service;

import com.jk.bean.LandlordBean;
import com.jk.mapper.LandlordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LandlordServiceImpl implements LandlordService {
    @Autowired
    LandlordMapper landlordMapper;

    @Override
    public LandlordBean queryLandlord(String id) {
        return landlordMapper.queryLandlord(id);
    }

    @Override
    public HashMap<String, Object> findLandlord(LandlordBean landlordBean) {
        HashMap<String ,Object> map = new HashMap<String ,Object>();
        List<LandlordBean> list = landlordMapper.findLandlord(landlordBean);
        map.put("rows",list);
        return map;
    }

    @Override
    public LandlordBean ViewDetails(Integer id, Integer contractMethod) {
        if(contractMethod == 1){
            LandlordBean landlordBean = landlordMapper.ViewDetails(id);
            return landlordBean;
        }else {
            LandlordBean landlordBean = landlordMapper.ViewDetails2(id);
            return landlordBean;
        }
    }


    @Override
    public void addDetailsForm(LandlordBean landlordBean) {
        landlordMapper.updateDetails(landlordBean.getLanId());
        if(landlordBean.getContractMethod()==1){
            landlordMapper.updateLandlord(landlordBean);
            landlordMapper.addDetailsForm(landlordBean);
        }else{
            landlordMapper.updateLandlord2(landlordBean);
            landlordMapper.addDetailsForm2(landlordBean);
        }
    }

    @Override
    public LandlordBean cleared(Integer id,Integer contractMethod) {
        if(contractMethod == 1){
            LandlordBean landlordBean = landlordMapper.ViewDetails(id);
            return landlordBean;
        }else {
            LandlordBean landlordBean = landlordMapper.ViewDetails2(id);
            return landlordBean;
        }
    }

    @Override
    public void removeLandlord(Integer id) {
        landlordMapper.removeLandlord(id);
    }
}
