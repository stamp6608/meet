package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

/**
 * @program: meet
 * @description: 搜索附近的人排序
 * @author: Stamp.M
 * @create: 2019-03-28 18:41
 **/
public class VicinityReq2 extends BaseReq{
    //经度
    @ParamCheck
    private String lon;
    //维度
    @ParamCheck
    private String lat;


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
