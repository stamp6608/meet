package com.cn.meet.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: meet
 * @description: 用户信息类
 * @author: Stamp.M
 * @create: 2019-03-16 20:21
 **/
public class UserInfoEntity implements Serializable{

    private static final long serialVersionUID = -4884300323260301077L;
    private Integer id;
    //手机号，唯一标识
    private String telephone;
    //语言
    private String language;
    //国家
    private String country;
    //别名
    private String aliasName;
    //生日
    private String birthday;
    //身高/体重
    private String weight;
    //性别
    private String sex;
    //体型
    private String shape;
    //种族
    private String race;
    //情感状况
    private String emotion;
    //自我介绍
    private String selfIntroduction;
    //期待类型
    private String expectType;
    //期待约会性别
    private String expectSex;
    //期待约会体型
    private String expectShape;
    //期待约会种族
    private String expectRace;
    //期待约会年龄
    private String expectAge;
    //城市
    private String city;
    //爱好
    private String hobby;
    //宗教
    private String religion;
    //教育
    private String edutication;
    //吸烟/喝酒
    private String smoke;
    //是否期待小孩
    private String hasBaby;
    //经度
    private BigDecimal longitude;
    //维度
    private BigDecimal latitude;
    //登陆成功的令牌
    private String token;
    //图片路径
    private String imgPath;
    //距离
    private String distance;
    //信用度
    private Integer levNum;
    //是否在线（1 在线  0离线）
    private String online;
    //状态 0启用 1禁用 2删除
    private Integer status;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Integer getLevNum() {
        return levNum;
    }

    public void setLevNum(Integer levNum) {
        this.levNum = levNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
