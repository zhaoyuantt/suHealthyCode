package com.landasoft.gshealthy;

import com.landasoft.gshealthycode.utils.HaomaDataResult;
import com.landasoft.gshealthycode.utils.HaomaResult;
import com.landasoft.gshealthycode.utils.HttpClientUtil;
import com.landasoft.gshealthycode.utils.JsonUtils;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试HttpClient工具类
 * @author zhaoyuan
 * @date 2020,March 30 8:59 am
 */
public class TestHttpClient {

    @Test
    public void doGet(){
        String cValue = HttpClientUtil.doGet("http://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_name=guishudi&query=15109468861");
        HaomaResult haomaResult = JsonUtils.jsonToPojo(cValue, HaomaResult.class);
        /*List list = (List)haomaResult.getData();
        Map map = (Map) list.get(0);
        Object city = map.get("city");
        System.out.println(city);*/
        List<LinkedHashMap<String, Object>> list = haomaResult.getData();
        LinkedHashMap<String, Object> map =  list.get(0);
        Object city = map.get("city");
        System.out.println(city);
    }
}
