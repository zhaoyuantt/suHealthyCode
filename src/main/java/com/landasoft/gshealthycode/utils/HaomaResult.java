package com.landasoft.gshealthycode.utils;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 百度手机号码归属地查询api返回结果 bean
 * @author zhaoyuan
 * @date 2020,March 30 9:12 pm
 */
public class HaomaResult {

    private String status;
    private String t;
    private String set_cache_time;
    private List<LinkedHashMap<String,Object>> data;

    public HaomaResult() {
    }

    public HaomaResult(String status, String t, String set_cache_time, List<LinkedHashMap<String,Object>> data) {
        this.status = status;
        this.t = t;
        this.set_cache_time = set_cache_time;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getSet_cache_time() {
        return set_cache_time;
    }

    public void setSet_cache_time(String set_cache_time) {
        this.set_cache_time = set_cache_time;
    }

    public List<LinkedHashMap<String,Object>> getData() {
        return data;
    }

    public void setData(List<LinkedHashMap<String,Object>> data) {
        this.data = data;
    }
}
