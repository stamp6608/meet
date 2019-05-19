package com.cn.meet.mapper;

import com.cn.meet.model.entity.BaseEntity;
import com.cn.meet.model.entity.ClubEntity;
import com.cn.meet.model.entity.ClubMemberDetailEntity;
import com.cn.meet.req.oracle.ClubInfoReq;
import com.cn.meet.req.oracle.ClubMemberReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: meet
 * @description: 俱乐部Mapper
 * @author: Stamp.M
 * @create: 2019-05-15 21:16
 **/
@Mapper
public interface ClubMapper {
    List<ClubEntity> fetchClubList(BaseEntity baseEntity);
    List<ClubEntity> fetchClubInfos(ClubInfoReq clubInfoReq);
    List<ClubMemberDetailEntity> fetchClubMemberInfos(ClubInfoReq clubInfoReq);
    void addClub(ClubInfoReq clubInfoReq);
    void addClubMember(ClubMemberReq clubMemberReq);
    void setClubMember(ClubMemberReq clubMemberReq);
    void removeClubMember(ClubMemberReq clubMemberReq);
}
