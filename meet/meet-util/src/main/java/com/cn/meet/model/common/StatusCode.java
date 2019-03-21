package com.cn.meet.model.common;

import org.springframework.http.HttpStatus;

/**
 * @program: meet
 * @description: 响应状态码类
 * @author: Stamp.M
 * @create: 2019-03-21 10:21
 **/
public class StatusCode {
    //正常响应
    public static final Integer SUCCESS_CODE = 0;
    //系统服务错误 500
    public static final Integer INNER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    //参数解密失败
    public static final Integer DECRYPT_ERROR = 300;
    //参数校验失败
    public static final Integer PARAMETER_CHECK_ERROR = 301;
    //手机号已注册
    public static final Integer PHNOE_EXIST_ERROR=400;


}
