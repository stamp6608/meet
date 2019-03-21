package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 性别枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum Sex {
    MAN("男","1"),WOMAN("女","2"), OTHER("其他", "0");

    private Sex(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(Sex s : Sex.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(Sex s : Sex.values()){
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
