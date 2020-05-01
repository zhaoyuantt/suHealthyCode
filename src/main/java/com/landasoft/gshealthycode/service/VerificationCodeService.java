package com.landasoft.gshealthycode.service;

import com.landasoft.gshealthycode.pojo.TVerificationCode;
import com.landasoft.gshealthycode.utils.MyResult;

/**
 * 验证码Service接口
 * @author zhaoyuan
 * @date 2020,March 29 4:01 pm
 */
public interface VerificationCodeService {

    /**
     * 插入一条验证码文档记录
     * @param verificationCode
     * @return
     */
    MyResult insertVerificationCode(TVerificationCode verificationCode);

    /**
     * 更新一条验证码文档记录
     * @param verificationCode
     * @return
     */
    int updateVerificationCode(TVerificationCode verificationCode);
}
