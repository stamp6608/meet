package com.cn.meet.req.oracle;

/**
 * @program: meet
 * @description: 俱乐部成员
 * @author: Stamp.M
 * @create: 2019-04-12 20:10
 **/
public class ClubMemberReq extends BaseReq{

    //用户id
    private Integer userId;
    //用户名
    private String userName;
    //俱乐部ID
    private String clubId;
    //成员类型 0 管理员; 1 VIP; 2 红牌; 3 处; 4 小妹; 5 包养中; 6 普通
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

}
