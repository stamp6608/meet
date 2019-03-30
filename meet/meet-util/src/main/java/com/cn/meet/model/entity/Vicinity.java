package com.cn.meet.model.entity;

import java.math.BigDecimal;

/**
 * @program: meet
 * @description: 搜索附近的人实体类
 * @author: Stamp.M
 * @create: 2019-03-28 18:41
 **/
public class Vicinity extends BaseEntity{
    //最小经度
    private BigDecimal minlng;
    //最大经度
    private BigDecimal maxlng;
    //最小维度
    private BigDecimal minlat;
    //最小维度
    private BigDecimal maxlat;
    //经度
    private BigDecimal longitude;
    //维度
    private BigDecimal latitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getMinlng() {
        return minlng;
    }

    public void setMinlng(BigDecimal minlng) {
        this.minlng = minlng;
    }

    public BigDecimal getMaxlng() {
        return maxlng;
    }

    public void setMaxlng(BigDecimal maxlng) {
        this.maxlng = maxlng;
    }

    public BigDecimal getMinlat() {
        return minlat;
    }

    public void setMinlat(BigDecimal minlat) {
        this.minlat = minlat;
    }

    public BigDecimal getMaxlat() {
        return maxlat;
    }

    public void setMaxlat(BigDecimal maxlat) {
        this.maxlat = maxlat;
    }
}
