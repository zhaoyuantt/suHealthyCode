package com.landasoft.gshealthycode.controller;

import com.landasoft.gshealthycode.pojo.TStatistics;
import com.landasoft.gshealthycode.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 图片回显
 * @author zhaoyuan
 * @date 2020,May 1 3:17 am
 */
@Controller
@RequestMapping("/code")
public class PicController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/{idCard}")
    public void initCodeByIdCard(@PathVariable String idCard, HttpServletResponse response){
        TStatistics statistics = statisticsService.getStatisticsByIdCard(idCard);
        String codePath = statistics.getCodePath();
        outImage(codePath,response);
    }

    /**
     * 向浏览器输出图片
     * @param pathname
     * @param response
     */
    public void outImage(String pathname,HttpServletResponse response){

        File file = new File(pathname);

        if (!file.exists()) {
            throw new RuntimeException("Image file is not found!");
        }

        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;

        try {
            fileInputStream = new FileInputStream(file);

            outputStream = response.getOutputStream();

            byte[] arr = new byte[1024*10];
            int n;

            while((n=fileInputStream.read(arr))!= -1){
                outputStream.write(arr, 0, n);
            }

            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fileInputStream) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
