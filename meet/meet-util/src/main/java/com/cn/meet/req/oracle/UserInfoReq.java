package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

/**
 * @program: meet
 * @description: 用户信息类
 * @author: Stamp.M
 * @create: 2019-03-16 20:21
 **/
public class UserInfoReq {
    //手机号，唯一标识
    @ParamCheck
    private String telephone;
    //语言
    @ParamCheck
    private String language;
    //国家
    @ParamCheck
    private String country;
    //别名
    @ParamCheck
    private String aliasName;
    //生日
    @ParamCheck
    private String birthday;
    //身高/体重
    @ParamCheck
    private String weight;
    //性别
    @ParamCheck
    private String sex;
    //城市
    @ParamCheck
    private String city;
    //体型
    @ParamCheck
    private String shape;
    //种族
    @ParamCheck
    private String race;
    //情感状况
    @ParamCheck
    private String emotion;
    //自我介绍
    private String selfIntroduction;
    //期待类型
    @ParamCheck
    private String expectType;
    //期待约会性别
    @ParamCheck
    private String expectSex;
    //期待约会体型
    @ParamCheck
    private String expectShape;
    //期待约会种族
    @ParamCheck
    private String expectRace;
    //期待约会年龄
    @ParamCheck
    private String expectAge;
    //爱好
    @ParamCheck
    private String hobby;
    //宗教
    @ParamCheck
    private String religion;
    //教育
    @ParamCheck
    private String edutication;
    //吸烟/喝酒
    @ParamCheck
    private String smoke;
    //是否期待小孩
    @ParamCheck
    private String hasBaby;
    //经度
    @ParamCheck
    private String longitude;
    //维度
    @ParamCheck
    private String latitude;
    //图片地址
    private String imgPath;
    //创建时间
    private int createTime;
    //修改时间
    private int updateTime;
    //注册IP
    private String ip;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getExpectShape() {
        return expectShape;
    }

    public void setExpectShape(String expectShape) {
        this.expectShape = expectShape;
    }

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

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getExpectType() {
        return expectType;
    }

    public void setExpectType(String expectType) {
        this.expectType = expectType;
    }

    public String getExpectSex() {
        return expectSex;
    }

    public void setExpectSex(String expectSex) {
        this.expectSex = expectSex;
    }

    public String getExpectRace() {
        return expectRace;
    }

    public void setExpectRace(String expectRace) {
        this.expectRace = expectRace;
    }

    public String getExpectAge() {
        return expectAge;
    }

    public void setExpectAge(String expectAge) {
        this.expectAge = expectAge;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEdutication() {
        return edutication;
    }

    public void setEdutication(String edutication) {
        this.edutication = edutication;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getHasBaby() {
        return hasBaby;
    }

    public void setHasBaby(String hasBaby) {
        this.hasBaby = hasBaby;
    }
}
