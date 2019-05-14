package com.cn.meet.model.entity;

import java.io.Serializable;

/**
 * @program: meet
 * @description: 俱乐部荣誉勋章 (多对多)
 * @author: Stamp.M
 * @create: 2019-04-12 20:11
 **/
public class ClubHonorEntity implements Serializable{

    private static final long serialVersionUID = -2528434469545419850L;

    private Integer id;
    //俱乐部id
    private Integer clubId;
    //荣誉勋章id 0 荣誉勋章0; 1 荣誉勋章1; 2 荣誉勋章2; 3 荣誉勋章3; 4 荣誉勋章4; 5 荣誉勋章5; 6 荣誉勋章6
    private Integer honorId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getHonorId() {
        return honorId;
    }

    public void setHonorId(Integer honorId) {
        this.honorId = honorId;
    }
}
