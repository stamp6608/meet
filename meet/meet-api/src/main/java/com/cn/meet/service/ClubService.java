package com.cn.meet.service;

import com.cn.meet.enums.ClubCharge;
import com.cn.meet.mapper.ClubMapper;
import com.cn.meet.model.entity.BaseEntity;
import com.cn.meet.model.entity.ClubEntity;
import com.cn.meet.model.entity.ClubMemberDetailEntity;
import com.cn.meet.req.oracle.ClubInfoReq;
import com.cn.meet.req.oracle.ClubMemberReq;
import com.cn.meet.util.GeneralUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @program: meet
 * @description: 俱乐部service
 * @author: Stamp.M
 * @create: 2019-05-15 21:16
 **/
@Service
public class ClubService {

    @Resource
    private ClubMapper clubMapper;

    public List<ClubEntity> fetchClubList(BaseEntity baseEntity){
        return clubMapper.fetchClubList(baseEntity);
    }

    public List<ClubEntity> fetchClubInfos(ClubInfoReq clubInfoReq){
        return clubMapper.fetchClubInfos(clubInfoReq);
    }

    public List<ClubMemberDetailEntity> fetchClubMemberInfos(ClubInfoReq clubInfoReq){
        return clubMapper.fetchClubMemberInfos(clubInfoReq);
    }

    @Transactional
    public void addClub(ClubInfoReq clubInfoReq){
        String clubId = GeneralUtils.buildToken();
        clubInfoReq.setClubId(clubId);
        clubInfoReq.setCharge(new BigDecimal(ClubCharge.getIndex(clubInfoReq.getLevel())));
        clubMapper.addClub(clubInfoReq);
        //新增俱乐部管理员
        ClubMemberReq clubMemberReq = new ClubMemberReq();
        clubMemberReq.setUserId(clubInfoReq.getUserId());
        clubMemberReq.setClubId(clubId);
        clubMemberReq.setType(0);
        clubMemberReq.setUserName(clubInfoReq.getUserName());
        clubMapper.addClubMember(clubMemberReq);
    }

    @Transactional
    public void addClubMember(ClubMemberReq clubMemberReq){
        clubMemberReq.setType(6);
        clubMapper.addClubMember(clubMemberReq);
    }

    @Transactional
    public void setClubMember(ClubMemberReq clubMemberReq){
        clubMapper.setClubMember(clubMemberReq);
    }

    @Transactional
    public void removeClubMember(ClubMemberReq clubMemberReq){
        clubMapper.removeClubMember(clubMemberReq);
    }

}
