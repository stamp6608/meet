package com.cn.meet.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: meet
 * @description: 俱乐部
 * @author: Stamp.M
 * @create: 2019-04-12 19:36
 **/
public class ClubEntity implements Serializable{
    private static final long serialVersionUID = 8281264404154203448L;

    private Integer id;
    //俱乐部id
    private String clubId;
    //俱乐部名称
    private String clubName;
    //国家
    private String country;
    //信用等级
    private String level;
    //信用度
    private Integer levNum;
    //入会费用
    private BigDecimal credit;
    //俱乐部描述
    private String desc;
    //俱乐部地址
    private String location;
    //俱乐部经度
    private BigDecimal longitude;
    //俱乐部维度
    private BigDecimal latitude;
    //总消费
    private BigDecimal consume;
    //在线时间
    private Integer onlineTime;
    //俱乐部图片地址
    private String imgUrl;
    //入会费
    private BigDecimal payFee;
    //俱乐部推广
    private String spread;
    //俱乐部竞价
    private BigDecimal matchCharge;
    //状态 0有效 1关闭 2删除
    private Integer status;


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

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public BigDecimal getMatchCharge() {
        return matchCharge;
    }

    public void setMatchCharge(BigDecimal matchCharge) {
        this.matchCharge = matchCharge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getLevNum() {
        return levNum;
    }

    public void setLevNum(Integer levNum) {
        this.levNum = levNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getConsume() {
        return consume;
    }

    public void setConsume(BigDecimal consume) {
        this.consume = consume;
    }

    public Integer getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
