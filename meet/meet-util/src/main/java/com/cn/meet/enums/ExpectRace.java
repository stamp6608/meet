package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 期待约会种族枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum ExpectRace {
    OTHER("其它","0"), ASIA("亚洲","1"), AFRICA("非洲", "2"),LATIN("拉丁","3"),
    MIDDLE("中东","4"), MESTIZO("混血", "5"),AMERICA("美洲","6"),SOURCE("南亚", "5"),
    EUROPE("欧洲","6");
    private ExpectRace(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(ExpectRace s : ExpectRace.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(ExpectRace s : ExpectRace.values()){
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
