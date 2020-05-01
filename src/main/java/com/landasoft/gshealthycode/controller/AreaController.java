package com.landasoft.gshealthycode.controller;

import com.landasoft.gshealthycode.pojo.TArea;
import com.landasoft.gshealthycode.service.AreaService;
import com.landasoft.gshealthycode.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 区划Controller
 * @author zhaoyuan
 * @date 2020,March 29 9:56 pm
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/getAreaList/{parentId}")
    @ResponseBody
    public MyResult getAreaList(@RequestParam(value = "parentId",defaultValue = "0") String parentId){
        MyResult myResult = areaService.getAreaList(parentId);
        return myResult;
    }
}
