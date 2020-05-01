package com.landasoft.gshealthycode.controller;

import com.landasoft.gshealthycode.pojo.TVerificationCode;
import com.landasoft.gshealthycode.service.VerificationCodeService;
import com.landasoft.gshealthycode.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证码Controller
 * @author zhaoyuan
 * @date 2020,April 29 4:20 pm
 */
@Controller
@RequestMapping("/verification")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @RequestMapping(value = "/gene",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public MyResult geneVerificationCode(TVerificationCode verificationCode){
        MyResult myResult = verificationCodeService.insertVerificationCode(verificationCode);
        return myResult;
    }
}
