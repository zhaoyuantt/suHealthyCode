package com.landasoft.gshealthy;

import org.junit.Test;

import java.io.File;

/**
 * 文件测试类
 * @author zhaoyuan
 * @date 2020,March 30 9:40 pm
 */
public class TestFile {

    @Test
    public void testCreateDirectory(){
        String path = "G://images//622826199405101033";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
