package com.cn.meet.util;

import com.alibaba.fastjson.JSON;
import com.cn.meet.annotations.ParamCheck;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.enums.ResponseCodeEnum;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @program: meet
 * @description: 一般常用工具类
 * @author: Stamp.M
 * @create: 2019-03-21 14:01
 **/
public class GeneralUtils {

    /**
     * @Description: json参数转换成指定的参数对象
     * @Param: [requestWrapper, clazz]
     * @return: java.lang.Object
     * @Author: Stamp.M
     * @Date: 2019/3/21
     */
    public static Object mapperParams(BodyRequestWrapper requestWrapper, Class clazz) throws GeneralException{
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
    public static void checkParams(Object obj) throws GeneralException{
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
}
