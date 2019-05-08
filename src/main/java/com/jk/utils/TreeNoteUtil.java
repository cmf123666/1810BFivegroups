package com.jk.utils;

import com.jk.bean.MenuTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

public class TreeNoteUtil {
    
    /**
     * 鑾峰彇鐖惰妭鐐硅彍鍗�
     * @param treesList 鎵�鏈夋爲鑿滃崟闆嗗悎
     * @return
     */
    public final static List<MenuTree> getFatherNode(List<MenuTree> treesList){
        List<MenuTree> newTrees = new ArrayList<MenuTree>();
        for (MenuTree mt : treesList) {
            if (mt.getpId() ==null || "".equals(mt.getpId()) || "0".equals(mt.getpId()) ) {//濡傛灉pId涓虹┖锛屽垯璇ヨ妭鐐逛负鐖惰妭鐐�
                //閫掑綊鑾峰彇鐖惰妭鐐逛笅鐨勫瓙鑺傜偣
                mt.setChildren(getChildrenNode(mt.getId(), treesList));
                newTrees.add(mt);
            }
        }
        return newTrees;
    }
    
    /**
     * 閫掑綊鑾峰彇瀛愯妭鐐逛笅鐨勫瓙鑺傜偣
     * @param pId 鐖惰妭鐐圭殑ID
     * @param treesList 鎵�鏈夎彍鍗曟爲闆嗗悎
     * @return
     */
    private final static List<MenuTree> getChildrenNode(String pId, List<MenuTree> treesList){
        List<MenuTree> newTrees = new ArrayList<MenuTree>();
        for (MenuTree mt : treesList) {
            if (mt.getpId()==null) continue;
            if(mt.getpId().equals(pId)){
                //閫掑綊鑾峰彇瀛愯妭鐐逛笅鐨勫瓙鑺傜偣锛屽嵆璁剧疆鏍戞帶浠朵腑鐨刢hildren
                mt.setChildren(getChildrenNode(mt.getId(), treesList));
                //璁剧疆鏍戞帶浠禷ttributes灞炴�х殑鏁版嵁
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url", mt.getUrl());
                mt.setAttributes(map);
                newTrees.add(mt);
            }
        }
        return newTrees;
    }
}
