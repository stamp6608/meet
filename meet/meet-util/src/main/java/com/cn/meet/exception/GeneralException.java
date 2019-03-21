package com.cn.meet.exception;

/**
 * @program: meet
 * @description: 自定义异常
 * @author: Stamp.M
 * @create: 2019-03-19 22:19
 **/
public class GeneralException extends RuntimeException {
    private Integer code;

    public GeneralException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
