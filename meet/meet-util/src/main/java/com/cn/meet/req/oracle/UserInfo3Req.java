package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

import java.math.BigDecimal;

/**
 * @program: meet
 * @description: 用户登陆
 * @author: Stamp.M
 * @create: 2019-03-23 22:33
 **/
public class UserInfo3Req {

    //手机号
    @ParamCheck
    private String telephone;
    //经度
    @ParamCheck
    private BigDecimal longitude;
    //维度
    @ParamCheck
    private BigDecimal latitude;
    //登陆成功的令牌
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
