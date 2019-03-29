package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

/**
 * @program: meet
 * @description: 搜索附近的人
 * @author: Stamp.M
 * @create: 2019-03-28 18:41
 **/
public class VicinityReq extends BaseReq{
    //半径距离(单位km)
    @ParamCheck
    private String radii;
    //经度
    @ParamCheck
    private String lon;
    //维度
    @ParamCheck
    private String lat;


    public String getRadii() {
        return radii;
    }

    public void setRadii(String radii) {
        this.radii = radii;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
