package com.landasoft.gshealthycode.service;

import com.landasoft.gshealthycode.pojo.TArea;
import com.landasoft.gshealthycode.utils.MyResult;

import java.util.List;

/**
 * 区划Service接口
 * @author zhaoyuan
 * @date 2020,April 28 11:01 pm
 */
public interface AreaService {

    /**
     * 插入区划文档
     * @param area
     */
    void insertArea(TArea area);

    /**
     * 查询区划列表
     * @param parentId 父节点id 默认为0
     * @return
     */
    MyResult getAreaList(String parentId);
}
