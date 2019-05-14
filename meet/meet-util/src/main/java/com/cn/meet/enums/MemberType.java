package com.cn.meet.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: meet
 * @description: 俱乐部成员类型枚举
 * @author: Stamp.M
 * @create: 2019-03-17 22:12
 **/
public enum MemberType {
    ADMIN("管理员","0"), VIP("VIP","1"), REDCARD("红牌", "2"),FIRST("处","3"), SISTER("小妹","4"),
    BELONGED("包养中", "5"),NORMAL("普通","6");

    MemberType(String name, String index){
        this.name=name;
        this.index=index;
    }

    public static String getName(String index){
        for(MemberType s : MemberType.values()){
            if(StringUtils.equals(s.getIndex(), index)){
                return s.name;
            }
        }
        return "";
    }

    public static String getIndex(String name){
        for(MemberType s : MemberType.values()){
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
