package com.landasoft.gshealthycode.service;

import com.landasoft.gshealthycode.pojo.TStatistics;
import com.landasoft.gshealthycode.utils.MyResult;

/**
 * 统计Service接口
 * @author zhaoyuan
 * @date 2020,March 30 4:41 pm
 */
public interface StatisticsService {

    /**
     * 插入一条统计记录文档
     * @param statistics
     * @return
     */
    MyResult insertStatistics(TStatistics statistics);

    /**
     * 由身份证号获取一条统计文档记录
     * @param idCard
     * @return
     */
    TStatistics getStatisticsByIdCard(String idCard);

}
