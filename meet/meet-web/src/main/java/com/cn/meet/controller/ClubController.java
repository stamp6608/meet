package com.cn.meet.controller;

import com.cn.meet.annotations.SecurityParameter;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.model.entity.BaseEntity;
import com.cn.meet.model.entity.ClubEntity;
import com.cn.meet.model.entity.ClubMemberDetailEntity;
import com.cn.meet.req.oracle.BaseReq;
import com.cn.meet.req.oracle.ClubInfoReq;
import com.cn.meet.req.oracle.ClubMemberReq;
import com.cn.meet.service.ClubService;
import com.cn.meet.util.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: meet
 * @description: 俱乐部类
 * @author: Stamp.M
 * @create: 2019-05-14 20:57
 **/
@RestController
@RequestMapping("club")
@Slf4j
public class ClubController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource
    private ClubService clubService;


    /** 
    * @Description: 俱乐部信息分页查询（根据俱乐部信用度排序）
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/15 
    */ 
    @SecurityParameter
    @PostMapping("clubList")
    @ResponseBody
    public ResponseEntity clubList(BodyRequestWrapper request) throws GeneralException {

        BaseReq baseReq = (BaseReq) GeneralUtils.mapperParams(request, BaseReq.class);
        log.info(" 俱乐部信息分页查询...... ");
        Integer page = baseReq.getPage();
        Integer pageSize = baseReq.getPageSize();
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setMax((page - 1) * pageSize);
        baseEntity.setSize(pageSize);
        List<ClubEntity> clubs = clubService.fetchClubList(baseEntity);
        return ResponseEntity.initSuccessResponse(clubs);
    }

    /** 
    * @Description: 根据俱乐部ID或者俱乐部名称查询俱乐部信息 (最多返回10条记录)
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/15 
    */ 
    @SecurityParameter
    @PostMapping("fetchClubs")
    @ResponseBody
    public ResponseEntity fetchClubs(BodyRequestWrapper request) throws GeneralException {

        ClubInfoReq clubReq = (ClubInfoReq) GeneralUtils.mapperParams(request, ClubInfoReq.class);
        log.info(" 根据俱乐部ID或者俱乐部名称查询俱乐部信息...... ");
        List<ClubEntity> clubs = clubService.fetchClubInfos(clubReq);
        return ResponseEntity.initSuccessResponse(clubs);
    }


    /** 
    * @Description: 新增俱乐部
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/19 
    */ 
    @SecurityParameter
    @PostMapping("addClub")
    @ResponseBody
    public ResponseEntity addClub(BodyRequestWrapper request) throws GeneralException {

        ClubInfoReq clubReq = (ClubInfoReq) GeneralUtils.mapperParams(request, ClubInfoReq.class);
        clubService.addClub(clubReq);
        return ResponseEntity.initResponse();
    }

    /** 
    * @Description: 俱乐部成员查询
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/19 
    */ 
    @SecurityParameter
    @PostMapping("clubMembers")
    @ResponseBody
    public ResponseEntity clubMembers(BodyRequestWrapper request) throws GeneralException {

        ClubInfoReq clubInfoReq = (ClubInfoReq) GeneralUtils.mapperParams(request, ClubInfoReq.class);
        List<ClubMemberDetailEntity> clubs = clubService.fetchClubMemberInfos(clubInfoReq);
        return ResponseEntity.initSuccessResponse(clubs);
    }

    /** 
    * @Description: 加入俱乐部成员
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/19 
    */ 
    @SecurityParameter
    @PostMapping("addMember")
    @ResponseBody
    public ResponseEntity addMember(BodyRequestWrapper request) throws GeneralException {

        ClubMemberReq clubReq = (ClubMemberReq) GeneralUtils.mapperParams(request, ClubMemberReq.class);
        clubService.addClubMember(clubReq);
        return ResponseEntity.initResponse();
    }

    /** 
    * @Description: 俱乐部成员类型设置 （0 管理员; 1 VIP; 2 红牌; 3 处; 4 小妹; 5 包养中; 6 普通）
    * @Param: [request]
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/19 
    */ 
    @SecurityParameter
    @PostMapping("setMember")
    @ResponseBody
    public ResponseEntity setMember(BodyRequestWrapper request) throws GeneralException {

        ClubMemberReq clubReq = (ClubMemberReq) GeneralUtils.mapperParams(request, ClubMemberReq.class);
        clubService.setClubMember(clubReq);
        return ResponseEntity.initResponse();
    }

    /** 
    * @Description: 踢出俱乐部成员
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/5/19 
    */ 
    @SecurityParameter
    @PostMapping("outMember")
    @ResponseBody
    public ResponseEntity outMember(BodyRequestWrapper request) throws GeneralException {

        ClubMemberReq clubReq = (ClubMemberReq) GeneralUtils.mapperParams(request, ClubMemberReq.class);
        clubService.removeClubMember(clubReq);
        return ResponseEntity.initResponse();
    }



}
