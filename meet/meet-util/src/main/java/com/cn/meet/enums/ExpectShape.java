package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 期待约会体型枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum ExpectShape {
    BALANCE("匀称","1"),NORMAL("一般","0"), CONCERT("协调", "2"),FAT("胖","3"),
    MUSCULAR("肌肉","4"), THIN("瘦", "5"),STRONG("强壮","6");
    private ExpectShape(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(ExpectShape s : ExpectShape.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(ExpectShape s : ExpectShape.values()){
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
