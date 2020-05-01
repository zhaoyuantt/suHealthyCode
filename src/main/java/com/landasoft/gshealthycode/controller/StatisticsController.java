package com.landasoft.gshealthycode.controller;

import com.landasoft.gshealthycode.pojo.TStatistics;
import com.landasoft.gshealthycode.service.StatisticsService;
import com.landasoft.gshealthycode.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统计Controller
 * @author zhaoyuan
 * @date 2020,March 30 11:54 pm
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/insert")
    @ResponseBody
    public MyResult insertStatistics(TStatistics statistics){
        MyResult myResult = statisticsService.insertStatistics(statistics);
        return myResult;
    }

    @RequestMapping("/goCodePage/{idCard}")
    public ModelAndView goCodePage(@PathVariable String idCard){
        ModelAndView modelAndView = new ModelAndView();
        TStatistics statistics = statisticsService.getStatisticsByIdCard(idCard);
        modelAndView.setViewName("code");
        modelAndView.addObject("tdataj",statistics);
        return modelAndView;
    }
}
