package com.cn.meet.Exception;

import com.cn.meet.exception.GeneralException;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.model.common.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: meet
 * @description: 全局异常处理
 * @author: Stamp.M
 * @create: 2019-03-19 22:22
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 Exception 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error("服务错误:", e.getMessage());
        return new ResponseEntity(StatusCode.INNER_ERROR, "服务出错");
    }

    /**
     * 处理 GeneralException 异常
     * @param httpServletRequest httpServletRequest
     * @param e 异常
     * @return ResponseEntity
     */
    @ResponseBody
    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity businessExceptionHandler(HttpServletRequest httpServletRequest, GeneralException e) {
        logger.info("业务处理异常...code : " + e.getCode() + "; msg:" + e.getMessage());
        return new ResponseEntity(e.getCode(), e.getMessage());
    }
}
