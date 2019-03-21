package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 情感状况枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum Emotion {
    SINGLE("单身","0"), MARRIED("已婚","1"), DISSOCIATON("离异", "2"),LOVE("恋爱中","3");
    private Emotion(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(Emotion s : Emotion.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(Emotion s : Emotion.values()){
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
