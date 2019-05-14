package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 荣誉勋章类型枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum HonorType {
    NEW("荣誉勋章0","0"), HONOR1("荣誉勋章1","1"), HONOR2("荣誉勋章2", "2"),HONOR3("荣誉勋章3","3"), HONOR4("荣誉勋章4","4"),
    HONOR5("荣誉勋章5", "5"),HONOR6("荣誉勋章6","6");

    HonorType(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(HonorType s : HonorType.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(HonorType s : HonorType.values()){
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
