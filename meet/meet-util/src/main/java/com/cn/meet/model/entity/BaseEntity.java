package com.cn.meet.model.entity;

/**
 * @program: meet
 * @description: 请求基础类
 * @author: Stamp.M
 * @create: 2019-03-28 18:42
 **/
public class BaseEntity {
    //手机号
    private String telephone;
    //登陆成功的令牌
    private String token;
    //条目数
    private Integer size;
    //最大条目数
    private Integer max;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
