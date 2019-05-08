package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.bean.MenuTree;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreeServiceImpl implements TreeService {
    @Reference
    TreeService treeService;

    @Override
    public List<MenuTree> getTreeAll(){
        return treeService.getTreeAll();
    }


}
