package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 期待类型枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum ExpectType {
    NONE("无","0"), CHAT("聊天","1"), APPOINTMENT("约会", "2"),MAKE("交友","3"),
    NETCHAT("网聊","4"), FRIEND("朋友", "5"),HOOKUP("约炮","6");
    private ExpectType(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(ExpectType s : ExpectType.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(ExpectType s : ExpectType.values()){
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
