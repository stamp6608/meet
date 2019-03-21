package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 吸烟/喝酒枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum Smoke {
    NEVER("从不","1"),SOMETIMES("偶尔","2"), USUALLY("经常", "3"), NONE("无", "0");
    private Smoke(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(Smoke s : Smoke.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(Smoke s : Smoke.values()){
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
