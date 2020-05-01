package com.landasoft.gshealthycode.service.impl;

import com.landasoft.gshealthycode.mapper.TAreaMapper;
import com.landasoft.gshealthycode.pojo.TArea;
import com.landasoft.gshealthycode.pojo.TAreaExample;
import com.landasoft.gshealthycode.service.AreaService;
import com.landasoft.gshealthycode.utils.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区划Service接口实现
 * @author zhaoyuan
 * @date 2020,April 28 11:04 am
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private TAreaMapper areaMapper;

    @Override
    public void insertArea(TArea area) {
        areaMapper.insert(area);
    }

    @Override
    public MyResult getAreaList(String parentId) {
        if(StringUtils.isBlank(parentId)){
            throw new RuntimeException("必传参数parentId为空");
        }

        TAreaExample example = new TAreaExample();
        example.setOrderByClause("sort_num");
        TAreaExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TArea> areaList = areaMapper.selectByExample(example);

        if(null == areaList || 0 == areaList.size()){
            return null;
        }

        return MyResult.ok(areaList);
    }
}
