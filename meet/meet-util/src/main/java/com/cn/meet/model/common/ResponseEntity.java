package com.cn.meet.model.common;

import com.cn.meet.enums.ResponseCodeEnum;

/**
 * @program: meet
 * @description: 一般响应类
 * @author: Stamp.M
 * @create: 2019-03-19 22:33
 **/
public class ResponseEntity {
    private Integer code;
    private String message;
    private Object data;

    public ResponseEntity(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Integer code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseEntity initResponse(){
        return new ResponseEntity(ResponseCodeEnum.SUCCESS_CODE.getCode(), ResponseCodeEnum.SUCCESS_CODE.getMessage());
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
