package com.cn.meet.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 俱乐部级别对应会费
 * @author: Stamp.M
 * @create: 2019-05-19 20:44
 **/
public enum ClubCharge {

    LEVEL1("lev1","100"), LEVEL2("lev2","1000"), LEVEL3("lev3", "10000"),
    LEVEL4("lev4","50000");
    ClubCharge(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(ClubCharge s : ClubCharge.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(ClubCharge s : ClubCharge.values()){
            if(StringUtils.equals(s.getName(), name)){
                return s.index;
            }
        }
        return "";
    }


    //成员变量
    private String name;
    private String index;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
