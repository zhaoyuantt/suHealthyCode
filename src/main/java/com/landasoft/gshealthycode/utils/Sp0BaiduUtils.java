package com.landasoft.gshealthycode.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 百度手机号归属地查询
 * @author zhaoyuan
 * @date 2020,March 30 3:34 pm
 */
public class Sp0BaiduUtils {

    /**
     *
     * @param phoneNumber
     * @return   返回手机号归属地
     */
    public static Map<String,String> getCityByPhoneNumber(String phoneNumber){
        String url = "http://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_name=guishudi&query="+phoneNumber;
        String cValue = HttpClientUtil.doGet(url);
        HaomaResult haomaResult = JsonUtils.jsonToPojo(cValue, HaomaResult.class);
        List<LinkedHashMap<String, Object>> list = haomaResult.getData();
        LinkedHashMap<String, Object> map =  list.get(0);
        Object city = map.get("city");
        Object prov = map.get("prov");
        Map<String,String> rMap = new HashMap<>();
        rMap.put("city",city.toString());
        rMap.put("prov",prov.toString());
        return rMap;
    }
}
