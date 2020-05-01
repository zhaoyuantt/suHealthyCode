package com.landasoft.gshealthycode.service.impl;

import com.landasoft.gshealthycode.mapper.TVerificationCodeMapper;
import com.landasoft.gshealthycode.pojo.TVerificationCode;
import com.landasoft.gshealthycode.pojo.TVerificationCodeExample;
import com.landasoft.gshealthycode.service.VerificationCodeService;
import com.landasoft.gshealthycode.utils.IDUtils;
import com.landasoft.gshealthycode.utils.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 验证码Service接口实现
 * @author zhaoyuan
 * @date 2020,March 29 4:03 pm
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private TVerificationCodeMapper verificationCodeMapper;

    @Override
    public MyResult insertVerificationCode(TVerificationCode verificationCode) {
        if(StringUtils.isBlank(verificationCode.getPhoneNumber())){
            throw new RuntimeException("手机号为空");
        }


        String code = IDUtils.getGene6Id();

        TVerificationCodeExample example = new TVerificationCodeExample();
        TVerificationCodeExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneNumberEqualTo(verificationCode.getPhoneNumber());
        if(StringUtils.isNotBlank(verificationCode.getName())){
            criteria.andNameEqualTo(verificationCode.getName());
        }

        List<TVerificationCode> verificationCodeList = verificationCodeMapper.selectByExample(example);
        if(null != verificationCodeList && 0 < verificationCodeList.size()){
            TVerificationCode tVerificationCode = verificationCodeList.get(0);
            tVerificationCode.setVerificationCode(code);
            tVerificationCode.setUpdated(new Date());
            verificationCodeMapper.updateByPrimaryKey(tVerificationCode);
            return MyResult.ok(tVerificationCode);
        }

        verificationCode.setId(IDUtils.getGeneId());
        verificationCode.setVerificationCode(code);
        verificationCode.setIsVerification(false);
        verificationCode.setCreated(new Date());
        verificationCode.setUpdated(new Date());

        int iResult = verificationCodeMapper.insert(verificationCode);

        if(0 == iResult){
            return MyResult.build(500,"验证码入库失败！");
        }

        return MyResult.ok(verificationCode);
    }

    @Override
    public int updateVerificationCode(TVerificationCode verificationCode) {
        int uResult = verificationCodeMapper.updateByPrimaryKey(verificationCode);
        return uResult;
    }

}
