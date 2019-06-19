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
     * @api {POST} http://url/club/clubList  3.1俱乐部信息分页查询
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 俱乐部信息分页查询（根据俱乐部信用度排序）
     * @apiParam {String} page   页码
     * @apiParam {String} pageSize 	 页数
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[]
     * }
     * </b>
     * 加密此json对象后返回
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
     * @api {POST} http://url/club/fetchClubs  3.2根据俱乐部ID或者俱乐部名称查询俱乐部信息
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 根据俱乐部ID或者俱乐部名称查询俱乐部信息 (最多返回10条记录)
     * @apiParam {String} [clubId]   俱乐部ID
     * @apiParam {String} [clubName] 俱乐部名称
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[]
     * }
     * </b>
     * 加密此json对象后返回
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
     * @api {POST} http://url/club/addClub  3.3新增俱乐部
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 新增俱乐部
     * </b>
     * @apiParam {Integer} userId    用户ID
     * @apiParam {String} userName 	 创建人用户名
     * @apiParam {String} clubId     俱乐部id 如(nfjfm88jj)
     * @apiParam {String} clubName   俱乐部名称
     * @apiParam {BigDecimal} longitude  经度
     * @apiParam {BigDecimal} latitude   维度
     * @apiParam {String} location      俱乐部地址
     * @apiParam {String} level         俱乐部级别 (如"lev1"或 “lev2"等)
     * @apiParam {String} country       国家
     * @apiSuccessExample {Object}    返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":""
     * }
     * </b>
     * 加密此json对象后返回
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
     * @api {POST} http://url/club/clubMembers  3.4俱乐部成员查询
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 俱乐部成员查询
     * @apiParam {String} clubId   俱乐部ID
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[]
     * }
     * </b>
     * 加密此json对象后返回
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
     * @api {POST} http://url/club/addMember  3.5 加入俱乐部成员
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 加入俱乐部成员
     * @apiParam {String} clubId     俱乐部ID
     * @apiParam {Integer} userId    用户ID
     * @apiParam {String} userName 	 用户名
     * @apiParam {Integer} type     成员类型 0 管理员; 1 VIP; 2 红牌; 3 处; 4 小妹; 5 包养中; 6 普通
     *
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[]
     * }
     * </b>
     * 加密此json对象后返回
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
     * @api {POST} http://url/club/setMember  3.6 俱乐部成员类型设置
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 俱乐部成员类型设置
     * @apiParam {String} clubId     俱乐部ID
     * @apiParam {Integer} userId    用户ID
     * @apiParam {Integer} type     成员类型 0 管理员; 1 VIP; 2 红牌; 3 处; 4 小妹; 5 包养中; 6 普通
     *
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[]
     * }
     * </b>
     * 加密此json对象后返回
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
     * @api {POST} http://url/club/outMember  3.7 踢出俱乐部成员
     * @apiVersion 1.0.0
     * @apiGroup 3俱乐部
     * @apiDescription 踢出俱乐部成员
     * @apiParam {String} clubId     俱乐部ID
     * @apiParam {Integer} userId    用户ID
     *
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[]
     * }
     * </b>
     * 加密此json对象后返回
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
