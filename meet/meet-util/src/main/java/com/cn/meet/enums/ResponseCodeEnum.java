package com.cn.meet.enums;

/**
 * @program: meet
 * @description: 响应码配置枚举
 * @author: Stamp.M
 * @create: 2019-03-21 19:54
 **/
public enum  ResponseCodeEnum {

    SUCCESS_CODE(200, "success"),
    INNER_ERROR(500, "系统出错"),
    NON_SUPPORT_TYPE(501, "不支持的请求类型"),
    DECRYPT_ERROR(300, "参数解密失败"),
    PARAMETER_CHECK_ERROR(301, "参数校验失败"),
    PHNOE_EXIST_ERROR(400, "此手机号已注册过"),
    PHONE_VERIFY_ERROR(401,"手机验证错误"),
    ALIAS_NAME_ERROR(402,"别名已经存在"),
    PHNOE_CHECK_ERROR(403, "手机号不存在");

    private Integer code;
    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

}
