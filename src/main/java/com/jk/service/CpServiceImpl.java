package com.jk.service;

import com.jk.bean.Postbean;
import com.jk.mapper.ChanpinMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CpServiceImpl  implements CpService{

    @Resource
    ChanpinMapper chanpinMapper;



    @Override
    public HashMap<String, Object> findzhiwei(Integer pageSize, Integer start) {
        HashMap<String, Object>map=new HashMap();
       long count=chanpinMapper.findzhiweicount();
       List<Postbean>list=chanpinMapper.findzhiwei(pageSize,start);
        for (Postbean postbean : list) {
            postbean.setPdate(new Date());
        }

        map.put("total",count);
        map.put("rows",list);
       return map;
    }

    @Override
    public Postbean findzhiweis(Integer id) {

        return chanpinMapper.findzhiweis(id);
    }

    @Override
    public void addzhiwei(Postbean postbean) {
        chanpinMapper.addzhiwei(postbean);
    }

    @Override
    public void updatezhiwei(Postbean postbean) {
        chanpinMapper.updatezhiwei(postbean);
    }

    @Override
    public void delzhiwei(String id) {
        chanpinMapper.delzhiwei(id);
    }
}
