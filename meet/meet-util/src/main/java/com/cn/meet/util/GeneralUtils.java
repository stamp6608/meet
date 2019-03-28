package com.cn.meet.util;

import com.alibaba.fastjson.JSON;
import com.cn.meet.annotations.ParamCheck;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @program: meet
 * @description: 一般常用工具类
 * @author: Stamp.M
 * @create: 2019-03-21 14:01
 **/
public class GeneralUtils {
    private static Logger logger = LoggerFactory.getLogger(GeneralUtils.class);

    /**
     * @Description: json参数转换成指定的参数对象
     * @Param: [requestWrapper, clazz]
     * @return: java.lang.Object
     * @Author: Stamp.M
     * @Date: 2019/3/21
     */
    public static Object mapperParams(BodyRequestWrapper requestWrapper, Class clazz) throws GeneralException {
        String paramStr = requestWrapper.getDecryptJson();
        Object obj = JSON.parseObject(paramStr, clazz);
        //必填参数校验
        checkParams(obj);
        return obj;
    }

    /**
     * @Description: 参数必填校验
     * @Param: [obj]
     * @return: boolean
     * @Author: Stamp.M
     * @Date: 2019/3/21
     */
    public static void checkParams(Object obj) throws GeneralException {
        Class clz = obj.getClass();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ParamCheck.class)) {
                ParamCheck paramCheck = field.getAnnotation(ParamCheck.class);
                if (paramCheck.isNeed()) {
                    field.setAccessible(true);
                    try {
                        // 获取属性值
                        String val = (String) field.get(obj);
                        if (StringUtils.isBlank(val))
                            throw new GeneralException(ResponseCodeEnum.PARAMETER_CHECK_ERROR.getMessage(), ResponseCodeEnum.PARAMETER_CHECK_ERROR.getCode());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new GeneralException(ResponseCodeEnum.PARAMETER_CHECK_ERROR.getMessage(), ResponseCodeEnum.PARAMETER_CHECK_ERROR.getCode());
                    }
                }
            }
        }
    }

    /**
     * @Description: 对响应的对象加密处理
     * @Param: [obj]
     * @return: java.lang.String
     * @Author: Stamp.M
     * @Date: 2019/3/22
     */
    public static String encryptRes(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            logger.info("<<<响应数据>>>加密前：{}",json);
            result = AesEncryptUtils.encrypt(json);
            logger.info("<<<响应数据>>>加密后：{}",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /** 
    * @Description: 生成唯一标示符
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: Stamp.M 
    * @Date: 2019/3/26 
    */ 
    public static String buildToken(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
