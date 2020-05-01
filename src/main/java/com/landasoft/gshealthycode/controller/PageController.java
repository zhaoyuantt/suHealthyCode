package com.landasoft.gshealthycode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面跳转Controller
 * @author zhaoyuan
 * @date 2020,March 29 10:06 am
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public ModelAndView goPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
