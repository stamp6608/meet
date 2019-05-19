package com.cn.meet.req.oracle;

import java.math.BigDecimal;

/**
 * @program: meet
 * @description: 俱乐部查询
 * @author: Stamp.M
 * @create: 2019-05-15 20:58
 **/
public class ClubInfoReq extends BaseReq {

    //创建人用户id
    private Integer userId;
    //创建人用户名
    private String userName;
    //俱乐部id
    private String clubId;
    private String clubName;
    //俱乐部经度
    private BigDecimal longitude;
    //俱乐部维度
    private BigDecimal latitude;
    //俱乐部地址
    private String location;
    //俱乐部级别
    private String level;
    //国家
    private String country;

    //俱乐部创建时间
    private Integer addTime;
    //俱乐部费用
    private BigDecimal charge;


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
