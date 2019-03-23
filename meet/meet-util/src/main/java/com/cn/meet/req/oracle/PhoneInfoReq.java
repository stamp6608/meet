package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

/**
 * @program: meet
 * @description: 电话号码信息类(手机号注册)
 * @author: Stamp.M
 * @create: 2019-03-16 20:21
 **/
public class PhoneInfoReq {
    //手机号，唯一标识
    @ParamCheck
    private String telephone;
    //语种
    @ParamCheck
    private String language;
    //国家(英文名，根据手机号的选择来定)
    @ParamCheck
    private String country;
    //短信验证码
    private String verifyCode;


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
