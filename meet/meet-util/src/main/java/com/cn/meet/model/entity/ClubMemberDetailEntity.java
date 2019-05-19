package com.cn.meet.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: meet
 * @description: 俱乐部成员详情
 * @author: Stamp.M
 * @create: 2019-04-12 20:10
 **/
public class ClubMemberDetailEntity implements Serializable{

    private static final long serialVersionUID = 8028434257303276845L;

    //用户id
    private Integer userId;
    //用户名
    private String userName;
    //俱乐部ID
    private String clubId;
    //成员类型 0 管理员; 1 VIP; 2 红牌; 3 处; 4 小妹; 5 包养中; 6 普通
    private Integer type;

    //手机号，唯一标识
    private String telephone;
    //语言
    private String language;
    //国家
    private String country;
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

    public String getExpectShape() {
        return expectShape;
    }

    public void setExpectShape(String expectShape) {
        this.expectShape = expectShape;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getLevNum() {
        return levNum;
    }

    public void setLevNum(Integer levNum) {
        this.levNum = levNum;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
