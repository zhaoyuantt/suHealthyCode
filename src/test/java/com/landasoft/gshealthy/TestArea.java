package com.landasoft.gshealthy;

import com.landasoft.gshealthycode.pojo.TArea;
import com.landasoft.gshealthycode.service.AreaService;
import com.landasoft.gshealthycode.utils.IDUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 区划测试
 * @author zhaoyuan
 * @date 2020,April 28 11:07 am
 */
public class TestArea {

    AreaService areaService = null;

    @Before
    public void initSpringIocContailer(){
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:config/applicationContext-*.xml");
        areaService = applicationContext.getBean(AreaService.class);
    }

    @Test
    public void testInsertArea(){
        TArea area = new TArea();
        area.setId(IDUtils.getGeneId());
        area.setName("华亭县");
        area.setCode("620824");
        area.setSortNum(Short.valueOf("1"));
        area.setRemark(null);
        area.setCreated(new Date());
        area.setUpdated(new Date());

        areaService.insertArea(area);
    }
}
