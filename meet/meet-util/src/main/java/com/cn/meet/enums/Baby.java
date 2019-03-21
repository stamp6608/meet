package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 是否期待小孩枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum Baby {
    NONE("无","1"),COHABIT("已育同住","2"), SEPARATION("已育分居", "0"),NOBABY("无小孩","1"), SINGLE("独身主义者","2");

    private Baby(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(Baby s : Baby.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(Baby s : Baby.values()){
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
