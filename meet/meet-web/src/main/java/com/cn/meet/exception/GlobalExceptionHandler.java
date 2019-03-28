package com.cn.meet.exception;

import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.util.GeneralUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: meet
 * @description: 全局异常处理
 * @author: Stamp.M
 * @create: 2019-03-19 22:22
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 Exception 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return 异常数据加密串
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        e.printStackTrace();
        logger.error("服务错误:", e.getMessage());
        return GeneralUtils.encryptRes(ResponseEntity.initErrorResponseEntity(ResponseCodeEnum.INNER_ERROR));
    }

    /**
     * 处理 GeneralException 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return 异常数据加密串
     */
    @ResponseBody
    @ExceptionHandler(value = GeneralException.class)
    public String businessExceptionHandler(HttpServletRequest httpServletRequest, GeneralException e) {
        logger.info("业务处理异常...code : " + e.getCode() + "; msg:" + e.getMessage());
        return GeneralUtils.encryptRes(new ResponseEntity(e.getCode(), e.getMessage()));
    }
}
