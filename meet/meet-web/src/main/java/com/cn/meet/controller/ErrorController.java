package com.cn.meet.controller;

import com.cn.meet.annotations.SecurityParameter;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.Constant;
import com.cn.meet.model.common.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: meet
 * @description: 异常响应
 * @author: Stamp.M
 * @create: 2019-03-22 22:36
 **/

@RestController
@RequestMapping("/error")
public class ErrorController {

    /**
     * @Description: 错误响应类
     * @Param: [request]
     * @return: com.cn.meet.model.common.ResponseEntity
     * @Author: Stamp.M
     * @Date: 2019/3/22
     */
    @SecurityParameter(outEncode = true)
    @RequestMapping("/msg")
    public ResponseEntity error(BodyRequestWrapper request) throws GeneralException {
        ResponseCodeEnum codeEnum = (ResponseCodeEnum) request.getSession().getAttribute(Constant.ERROR_SESSION_ENUM);
        return ResponseEntity.initErrorResponseEntity(codeEnum);
    }
}
