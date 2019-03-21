package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 爱好枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum Hobby {
    NONE("无","0"), MOVIE("电影","1"), READ("读书", "2"),TV("电视","3"), MUSIC("音乐","4"),
    FAMILY("家庭", "5"),PET("宠物","6"),DIRINK("喝酒", "7"), HOTEL("旅馆","8"),
    SHOP("购物","9"), PHYSICAL("看体育节目", "10"),SPROTS("运动","11"),BAR("酒吧", "12"),
    DANCE("跳舞", "13"),GAME("游戏","14");
    private Hobby(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(Hobby s : Hobby.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(Hobby s : Hobby.values()){
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
