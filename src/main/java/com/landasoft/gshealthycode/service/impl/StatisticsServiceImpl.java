package com.landasoft.gshealthycode.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.landasoft.gshealthycode.mapper.TAreaMapper;
import com.landasoft.gshealthycode.mapper.TStatisticsMapper;
import com.landasoft.gshealthycode.mapper.TVerificationCodeMapper;
import com.landasoft.gshealthycode.pojo.*;
import com.landasoft.gshealthycode.service.StatisticsService;
import com.landasoft.gshealthycode.utils.IDUtils;
import com.landasoft.gshealthycode.utils.MyResult;
import com.landasoft.gshealthycode.utils.Sp0BaiduUtils;
import com.landasoft.gshealthycode.utils.code.MatrixToImageWriter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统计Service接口实现
 * @author zhaoyuan
 * @date 2020,March 30 4:43 pm
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private static final Logger log = Logger.getLogger(StatisticsServiceImpl.class);

    @Autowired
    private TStatisticsMapper statisticsMapper;
    @Autowired
    private TVerificationCodeMapper verificationCodeMapper;
    @Autowired
    private TAreaMapper areaMapper;


    @Value("${CODE_WIDTH}")
    private String CODE_WIDTH;
    @Value("${CODE_HEIGHT}")
    private String CODE_HEIGHT;
    @Value("${CODE_FORMAT}")
    private String CODE_FORMAT;
    //@Value("${COLOR_BACKGROUND}")
    private int COLOR_BACKGROUND = 0xFFFFFFFF;
    //@Value("${COLOR_GREEN}")
    private int COLOR_GREEN = 0x008000;
    //@Value("${COLOR_YELLOW}")
    private int COLOR_YELLOW = 0xFFFFFF00;
    //@Value("${COLOR_RED}")
    private int COLOR_RED = 0xFFFF0000;
    @Value("${BASE_CODE_PATH}")
    private String BASE_CODE_PATH;


    @Override
    public MyResult insertStatistics(TStatistics statistics) {
        //校验参数
        checkStatisticsParams(statistics);

        //是否已填报
        boolean bRegister = isRegister(statistics.getIdCard());
        if(bRegister){
            return MyResult.build(505,"已经填报");
        }

        //校验验证码
        boolean codeCResult = checkPhoneNumberCode(statistics);
        if(false == codeCResult){
            return MyResult.build(505,"验证码错误或服务器错误");
        }

        //生成二维码
        Map<String, String> map = geneCode(statistics);
        if("0".equals(map.get("isGene"))){
            return MyResult.build(500,"二维码生成失败");
        }

        //补全属性
        TAreaExample areaExample = new TAreaExample();
        TAreaExample.Criteria areaCriteria = areaExample.createCriteria();
        areaCriteria.andCodeEqualTo(statistics.getHouseholdRegister());
        List<TArea> areaList = areaMapper.selectByExample(areaExample);
        if(null == areaList || 0 == areaList.size()){
            return MyResult.build(500,"数据库操作异常");
        }

        statistics.setId(IDUtils.getGeneId());
        statistics.setHouseholdRegister(areaList.get(0).getName());
        statistics.setHouseholdRegisterCode(areaList.get(0).getCode());
        statistics.setCodePath(map.get("pathName"));
        statistics.setCodeColor(map.get("codeColor"));
        statistics.setCreated(new Date());
        statistics.setUpdated(new Date());

        int iResult = statisticsMapper.insert(statistics);
        if(1 != iResult){
            return MyResult.build(500,"数据库操作异常");
        }

        return MyResult.ok(statistics);
    }

    @Override
    public TStatistics getStatisticsByIdCard(String idCard) {
        if(StringUtils.isBlank(idCard)){
            throw new RuntimeException("必传参数为空");
        }

        TStatisticsExample example = new TStatisticsExample();
        TStatisticsExample.Criteria criteria = example.createCriteria();
        criteria.andIdCardEqualTo(idCard);

        List<TStatistics> statisticsList = statisticsMapper.selectByExample(example);

        if(null == statisticsList || 0 == statisticsList.size()){
            return null;
        }

        return statisticsList.get(0);
    }

    void checkStatisticsParams(TStatistics statistics){
        if(StringUtils.isBlank(statistics.getName())){
            throw new RuntimeException("姓名为空");
        }
        if(StringUtils.isBlank(statistics.getIdCard())){
            throw new RuntimeException("身份证号为空");
        }
        if(StringUtils.isBlank(statistics.getHouseholdRegister())){
            throw new RuntimeException("户籍为空");
        }
        if(null == statistics.getIsLeaveGansu()){
            throw new RuntimeException("是否离开为空");
        }
        if(null == statistics.getIsFever()){
            throw new RuntimeException("是否不适为空");
        }
        if(StringUtils.isBlank(statistics.getNumberVerificationCode())){
            throw new RuntimeException("验证码为空");
        }
    }


    /**
     * 比对验证码
     * @param statistics
     * @return false：失败 true：成功
     */
    boolean checkPhoneNumberCode(TStatistics statistics){
        TVerificationCodeExample example = new TVerificationCodeExample();
        TVerificationCodeExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(statistics.getName());
        criteria.andPhoneNumberEqualTo(statistics.getPhoneNumber());

        List<TVerificationCode> verificationCodeList = verificationCodeMapper.selectByExample(example);

        if(null == verificationCodeList || 0 == verificationCodeList.size()){
            return false;
        }

        TVerificationCode verificationCode = verificationCodeList.get(0);
        String msCode = verificationCode.getVerificationCode();

        if(!msCode.equals(statistics.getNumberVerificationCode())){
            return false;
        }

        verificationCode.setIsVerification(true);

        int uResult = verificationCodeMapper.updateByPrimaryKey(verificationCode);

        if(0 == uResult){
            return false;
        }

        return true;
    }

    int getIntByString(String str){
        int iStr = Integer.valueOf(str);
        return iStr;
    }

    /**
     * 生成二维码
     * @param statistics
     * @return isGene=0 生成失败 isGene=1 生成成功
     */
    Map<String,String> geneCode(TStatistics statistics){
        Map<String,String> map = new ConcurrentHashMap<>();

        //查询手机归属地 TODO
        Map<String, String> baiduSpoResult = Sp0BaiduUtils.getCityByPhoneNumber(statistics.getPhoneNumber());
        String prov = baiduSpoResult.get("prov");
        String city = baiduSpoResult.get("city");

        //创建存储二维码的路径
        String idCard = statistics.getIdCard();
        String path = BASE_CODE_PATH+"//"+idCard;
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //二维码文本
        String apacheTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String text = "name:"+statistics.getName()+" "+"idCard:"+statistics.getIdCard()+" "+"phoneNumber:"+statistics.getPhoneNumber()+" "+"created:"+apacheTime;

        //二维码文件名
        String pathName = path+"//"+idCard+"."+CODE_FORMAT;

        //生成二维码
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, getIntByString(CODE_WIDTH), getIntByString(CODE_HEIGHT),hints);
            File outputFile = new File(pathName);

            //判断要生成的二维码颜色
            if(!prov.equals("甘肃")){
                MatrixToImageWriter.writeToFile(bitMatrix, CODE_FORMAT, outputFile,COLOR_BACKGROUND,COLOR_RED);
                map.put("codeColor","red");
                log.info(statistics.getName()+"生成二维码，颜色红色，名称"+pathName);
            }else if(statistics.getIsLeaveGansu() || statistics.getIsFever()){
                MatrixToImageWriter.writeToFile(bitMatrix, CODE_FORMAT, outputFile,COLOR_BACKGROUND,COLOR_RED);
                map.put("codeColor","red");
                log.info(statistics.getName()+"生成二维码，颜色红色，名称"+pathName);
            }else if (city.equals("平凉")){
                MatrixToImageWriter.writeToFile(bitMatrix, CODE_FORMAT, outputFile,COLOR_BACKGROUND,COLOR_YELLOW);
                map.put("codeColor","yellow");
                log.info(statistics.getName()+"生成二维码，颜色黄色，名称"+pathName);
            }else{
                MatrixToImageWriter.writeToFile(bitMatrix, CODE_FORMAT, outputFile,COLOR_BACKGROUND,COLOR_GREEN);
                map.put("codeColor","green");
                log.info(statistics.getName()+"生成二维码，颜色绿色，名称"+pathName);
            }
        } catch (WriterException e) {
            map.put("isGene","0");
            e.printStackTrace();
        } catch (IOException e) {
            map.put("isGene","0");
            e.printStackTrace();
        }

        //返回结果
        map.put("isGene","1");
        map.put("pathName",pathName);

        return map;
    }

    /**
     * 根据身份证判断是否已经填报
     * @param idCard
     * @return false:没有填报 true:已经填报
     */
    boolean isRegister(String idCard){
        TStatisticsExample example = new TStatisticsExample();
        TStatisticsExample.Criteria criteria = example.createCriteria();
        criteria.andIdCardEqualTo(idCard);

        List<TStatistics> statisticsList = statisticsMapper.selectByExample(example);

        if(0 != statisticsList.size()){
            return true;
        }
        return false;
    }

}
