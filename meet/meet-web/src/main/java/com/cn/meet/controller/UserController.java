package com.cn.meet.controller;

import com.cn.meet.annotations.SecurityParameter;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.Constant;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.model.common.Token;
import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.model.entity.Vicinity;
import com.cn.meet.req.oracle.*;
import com.cn.meet.service.UserService;
import com.cn.meet.util.DateUtils;
import com.cn.meet.util.GeneralUtils;
import com.cn.meet.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: meet
 * @description: 用户管理类
 * @author: Stamp.M
 * @create: 2019-03-06 19:20
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    // 支持多类型的数据缓存
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Resource
    private UserService userService;

    /**
     * @api {POST} http://url/user/verify  1.1获取手机短信验证 (需接入第三方手机短信验证平台)
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 获取手机短信验证 (需接入第三方手机短信验证平台)
     * @apiParam {String} telephone    手机号
     * @apiParam {String} language 	   语种
     * @apiParam {String} country      国家
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{}
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity verify(BodyRequestWrapper request) throws GeneralException {
        PhoneInfoReq phone = (PhoneInfoReq) GeneralUtils.mapperParams(request, PhoneInfoReq.class);
        //手机号是否注册过验证
        if (userService.checkPhone(phone.getTelephone()))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.PHNOE_EXIST_ERROR);

        //todo 向手机短信验证平台获取短信验证码(此处暂时先留白，具体后面接入短信平台)
        //模拟获取短信验证码为 73748332；
        String verificationCode = "73748332";
        request.getSession().setAttribute(phone.getTelephone(), verificationCode);
        return ResponseEntity.initResponse();
    }


    /**
     * @api {POST} http://url/user/vCode  1.2手机短信验证码验证
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 手机短信验证码验证
     * @apiParam {String} telephone    手机号
     * @apiParam {String} language 	   语种
     * @apiParam {String} country      国家
     * @apiParam {String} verifyCode   短信验证码
     * @apiSuccessExample {Object} 返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{}
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/vCode")
    @ResponseBody
    public ResponseEntity vCode(BodyRequestWrapper request) throws GeneralException {
        PhoneInfoReq phone = (PhoneInfoReq) GeneralUtils.mapperParams(request, PhoneInfoReq.class);
        String verifyCode = phone.getVerifyCode();
        Object obj = request.getSession().getAttribute(phone.getTelephone());
        String code = GeneralUtils.getStringValue(obj);
        if (StringUtils.isBlank(verifyCode) || StringUtils.isBlank(code)
                || !StringUtils.equals(verifyCode, code))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.PHONE_VERIFY_ERROR);
        //保存手机信息
        userService.savePhoneVerify(phone);
        //销毁短信验证码
        request.getSession().removeAttribute(phone.getTelephone());
        return ResponseEntity.initResponse();
    }

    /**
     * @api {POST} http://url/user/rUser  1.3用户信息注册
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 用户信息注册，请在http的header中设置ip。
     * </b>
     * 各选项用对应数字表示，多选请用","分割
     * @apiParam {String} telephone    手机号
     * @apiParam {String} language 	   语种
     * @apiParam {String} country      国家
     * @apiParam {String} aliasName    别名
     * @apiParam {String} birthday     生日
     * @apiParam {String} weight       身高/体重
     * @apiParam {String} sex          性别 (MAN("男","1"),WOMAN("女","2"), OTHER("其他", "0"))
     * @apiParam {String} city         城市
     * @apiParam {String} shape        体型 (BALANCE("匀称","1"),NORMAL("一般","0"), CONCERT("协调", "2"),FAT("胖","3"),MUSCULAR("肌肉","4"), THIN("瘦", "5"),STRONG("强壮","6"))
     * @apiParam {String} race         种族 (OTHER("其它","0"), ASIA("亚洲","1"), AFRICA("非洲", "2"),LATIN("拉丁","3"),MIDDLE("中东","4"), MESTIZO("混血", "5"),AMERICA("美洲","6"),SOURCE("南亚", "5"),EUROPE("欧洲","6"))
     * @apiParam {String} emotion      情感状况 (SINGLE("单身","0"), MARRIED("已婚","1"), DISSOCIATON("离异", "2"),LOVE("恋爱中","3"))
     * @apiParam {String} selfIntroduction   自我介绍
     * @apiParam {String} expectType   期待类型 (NONE("无","0"), CHAT("聊天","1"), APPOINTMENT("约会", "2"),MAKE("交友","3"), NETCHAT("网聊","4"), FRIEND("朋友", "5"),HOOKUP("约炮","6"))
     * @apiParam {String} expectSex   期待约会性别 (MAN("男","1"), WOMAN("女","2"), APPOINTMENT("其它", "0"))
     * @apiParam {String} expectShape  期待约会体型 ( BALANCE("匀称","1"),NORMAL("一般","0"), CONCERT("协调", "2"),FAT("胖","3"),MUSCULAR("肌肉","4"), THIN("瘦", "5"),STRONG("强壮","6"))
     * @apiParam {String} expectRace   期待约会种族 (OTHER("其它","0"), ASIA("亚洲","1"), AFRICA("非洲", "2"),LATIN("拉丁","3"),MIDDLE("中东","4"), MESTIZO("混血", "5"),AMERICA("美洲","6"),SOURCE("南亚", "7"),EUROPE("欧洲","8"))
     * @apiParam {String} expectAge   期待约会年龄
     * @apiParam {String} hobby       爱好 (NONE("无","0"), MOVIE("电影","1"), READ("读书", "2"),TV("电视","3"), MUSIC("音乐","4"),FAMILY("家庭", "5"),PET("宠物","6"),DIRINK("喝酒", "7"), HOTEL("旅馆","8"),SHOP("购物","9"), PHYSICAL("看体育节目", "10"),SPROTS("运动","11"),BAR("酒吧", "12"),DANCE("跳舞", "13"),GAME("游戏","14"))
     * @apiParam {String} religion    宗教 (NONE("无","0"), BUDDHIST("佛教","1"), CHRISTIAN("基督教", "2"),CATHOLIC("天主教","3"), SIKH("印度教","4"),ISLAMITE("伊斯兰教", "5"),OTHERS("其他教派","6"))
     * @apiParam {String} edutication 教育 (NONE("无","0"), HIGHSCHOOL("高中","1"), ACADEMIC("学院", "2"),COLLEAGE("本科","3"), JUNIOR("专科","4"),DOCTOR("博士", "5"),MASTER("硕士","6"))
     * @apiParam {String} smoke       吸烟/喝酒 (NEVER("从不","1"),SOMETIMES("偶尔","2"), USUALLY("经常", "3"), NONE("无", "0"))
     * @apiParam {String} hasBaby     是否期待小孩 (NONE("无","1"),COHABIT("已育同住","2"), SEPARATION("已育分居", "0"),NOBABY("无小孩","3"), SINGLE("独身主义者","4"))
     * @apiSuccessExample {Object}    返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{}
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/rUser")
    @ResponseBody
    public ResponseEntity registUser(BodyRequestWrapper request) throws GeneralException {
        UserInfoReq user = (UserInfoReq) GeneralUtils.mapperParams(request, UserInfoReq.class);
        //别名重复性校验
        if (userService.checkAliasName(user.getAliasName()))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.ALIAS_NAME_ERROR);
        user.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
        user.setUpdateTime(0);
        String ip = IPUtils.getRealIp(request, 0);
        user.setIp(ip);
        userService.saveUserInfo(user);
        return ResponseEntity.initResponse();
    }


    /**
     * @api {POST} http://url/user/info  1.4查询用户个人信息
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 查询用户个人信息, 数字解析同1.3的参数定义，多选用","分割
     * @apiParam {String} name 	      别名
     * @apiSuccessExample {Object}    返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{
     * "code" : 200,
     * "message" : "success",
     * "data" : {
     * "telephone" : "9847098888",     //手机号
     * "language" : "English",         //语种
     * "country" : "Philippines",      //国家
     * "aliasName" : "marry",          //别名
     * "birthday" : "10/5",            //生日
     * "weight" : "55-70",             //身高/体重
     * "sex" : "1",                    //性别
     * "shape" : "2",                  //体型
     * "race" : "3",                   //种族
     * "emotion" : "3",                //情感状况
     * "selfIntroduction" : "你好",     //自我介绍
     * "expectType" : "1,2",           //期待类型
     * "expectSex" : "1,2",            //期待约会性别
     * "expectShape" : "1,3,4",        //期待约会体型
     * "expectRace" : "2,3",           //期待约会种族
     * "expectAge" : "30-50",          //期待约会年龄
     * "city" : "Makaty",              //城市
     * "hobby" : "2,4,5",              //爱好
     * "religion" : "3",               //宗教
     * "edutication" : "2",            //教育
     * "smoke" : "1",                  //吸烟/喝酒
     * "hasBaby" : "0",                //是否期待小孩
     * "longitude" : 40.033075000000000,      //经度(BigDecimal 类型)
     * "latitude" : 116.314168000000000,      //维度(BigDecimal 类型)
     * "imgPath" : "url/path"，          //图片路径
     * }
     * }
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/info")
    @ResponseBody
    public ResponseEntity userInfo(BodyRequestWrapper request) throws GeneralException {
        UserInfo2Req userReq = (UserInfo2Req) GeneralUtils.mapperParams(request, UserInfo2Req.class);
        UserInfoEntity user = userService.getUserInfo(userReq);
        return ResponseEntity.initSuccessResponse(user);
    }

    /**
     * @api {POST} http://url/user/login  1.5用户登陆
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 用户登陆
     * @apiParam {String}     telephone    手机号
     * @apiParam {BigDecimal} longitude    经度
     * @apiParam {BigDecimal} latitude 	   维度
     * @apiSuccessExample {Object}     返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{
     * "telephone" : "9847098888",                     //手机号
     * "token" : "bb9c9590cece43debcb0844de24ff09e"    //token
     * }
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(BodyRequestWrapper request) throws GeneralException {
        UserInfo3Req userReq = (UserInfo3Req) GeneralUtils.mapperParams(request, UserInfo3Req.class);
        //手机号是否注册过验证
        if (!userService.checkPhone(userReq.getTelephone()))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.PHNOE_CHECK_ERROR);
        Token token = new Token();
        token.setTelephone(userReq.getTelephone());
        token.setToken(GeneralUtils.buildToken());
        log.info("用户{}登陆......, cur token : {}", userReq.getTelephone(), token.getToken());
        redisTemplate.opsForValue().set(token.getTelephone() + Constant.USER_TOKEN, token.getToken());
        //更新用户的经度和维度和token
        userReq.setToken(token.getToken());
        userService.updateUserLocation(userReq);
        return ResponseEntity.initSuccessResponse(token);
    }


    /**
     * @api {POST} http://url/user/logout  1.6用户登出(用户注销)
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 用户登出(用户注销)
     * @apiSuccessExample {Object}     返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{}
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity logout(BodyRequestWrapper request) throws GeneralException {
        BaseReq userReq = (BaseReq) GeneralUtils.mapperParams(request, BaseReq.class);
        log.info("用户{}注销......", userReq.getTelephone());
        userService.logout(userReq);
        redisTemplate.delete(userReq.getTelephone() + Constant.USER_TOKEN);
        return ResponseEntity.initResponse();
    }


    /**
     * @api {POST} http://url/user/nearby  1.7搜索附近的人(指定半径内的在线用户)
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 分页查询, 搜索附近的人(指定半径内的在线用户)
     * @apiParam {String}   radii    半径距离(单位km)
     * @apiParam {String}   lon      经度
     * @apiParam {String}   lat 	 维度
     * @apiParam {Integer}  page     页码
     * @apiParam {Integer}  pageSize 页数
     * @apiSuccessExample {Object}     返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[
     * {
     * "telephone" : "7490309389",
     * "language" : "English",
     * "country" : "Philippines",
     * "aliasName" : "测试下",
     * "birthday" : "10/5",
     * "weight" : "55-70",
     * "sex" : "1",
     * "shape" : "2",
     * "race" : "3",
     * "emotion" : "3",
     * "selfIntroduction" : "第一次来玩，请大家多多关照",
     * "expectType" : "1,2",
     * "expectSex" : "1,2",
     * "expectShape" : "1,3,4",
     * "expectRace" : "2,3",
     * "expectAge" : "30-50",
     * "city" : null,
     * "hobby" : "2,4,5",
     * "religion" : "3",
     * "edutication" : "2",
     * "smoke" : "1",
     * "hasBaby" : "0",
     * "longitude" : 116.310127000000000,  //经度
     * "latitude" : 40.064379000000000,    //维度
     * "token" : "29ec759ab7e84f119286831e335b69f1", //忽略
     * "imgPath" : null,
     * "distance" : "264"        //距离(单位m)
     * }
     * ......
     * ]
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/nearby")
    @ResponseBody
    public ResponseEntity getVicinity(BodyRequestWrapper request) throws GeneralException {
        VicinityReq vicinity = (VicinityReq) GeneralUtils.mapperParams(request, VicinityReq.class);
        log.info(" 搜索附近的人...... ");
        double r = 6371;//地球半径千米
        double radii = Double.valueOf(vicinity.getRadii());
        double lat = Double.valueOf(vicinity.getLat());
        double lon = Double.valueOf(vicinity.getLon());
        double dis = radii;
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(lat * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;//角度转为弧度
        double dlat = dis / r;
        dlat = dlat * 180 / Math.PI;
        double minlat = lat - dlat;
        double maxlat = lat + dlat;
        double minlng = lon - dlng;
        double maxlng = lon + dlng;
        Integer page = vicinity.getPage();
        Integer pageSize = vicinity.getPageSize();
        Vicinity vici = new Vicinity();
        vici.setTelephone(vicinity.getTelephone());
        vici.setMax((page - 1) * pageSize);
        vici.setSize(pageSize);
        vici.setMinlng(BigDecimal.valueOf(minlng));
        vici.setMaxlng(BigDecimal.valueOf(maxlng));
        vici.setMinlat(BigDecimal.valueOf(minlat));
        vici.setMaxlat(BigDecimal.valueOf(maxlat));
        vici.setLatitude(new BigDecimal(vicinity.getLat()));
        vici.setLongitude(new BigDecimal(vicinity.getLon()));
        List<UserInfoEntity> users = userService.getvicinity(vici);
        return ResponseEntity.initSuccessResponse(users);
    }

    /**
     * @api {POST} http://url/user/nearbysort  1.8搜索附近的人排序(由近及远查询)
     * @apiVersion 1.0.0
     * @apiGroup 1用户管理
     * @apiDescription 分页查询, 搜索附近的人排序(由近及远查询)
     * @apiParam {String}   lon      经度
     * @apiParam {String}   lat 	 维度
     * @apiParam {Integer}  page     页码
     * @apiParam {Integer}  pageSize 页数
     * @apiSuccessExample {Object}  返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":[
     * {
     * "telephone" : "7490309389",
     * "language" : "English",
     * "country" : "Philippines",
     * "aliasName" : "测试下",
     * "birthday" : "10/5",
     * "weight" : "55-70",
     * "sex" : "1",
     * "shape" : "2",
     * "race" : "3",
     * "emotion" : "3",
     * "selfIntroduction" : "第一次来玩，请大家多多关照",
     * "expectType" : "1,2",
     * "expectSex" : "1,2",
     * "expectShape" : "1,3,4",
     * "expectRace" : "2,3",
     * "expectAge" : "30-50",
     * "city" : null,
     * "hobby" : "2,4,5",
     * "religion" : "3",
     * "edutication" : "2",
     * "smoke" : "1",
     * "hasBaby" : "0",
     * "longitude" : 116.310127000000000,  //经度
     * "latitude" : 40.064379000000000,    //维度
     * "token" : "29ec759ab7e84f119286831e335b69f1", //忽略
     * "imgPath" : null,
     * "distance" : "264.0"       //(单位m)
     * }
     * ......
     * ]
     * }
     * </b>
     * 加密此json对象后返回
     */
    @SecurityParameter
    @PostMapping("/nearbysort")
    @ResponseBody
    public ResponseEntity getVicinitySort(BodyRequestWrapper request) throws GeneralException {
        VicinityReq2 vicinity = (VicinityReq2) GeneralUtils.mapperParams(request, VicinityReq2.class);
        log.info(" 搜索附近的人排序，由近及远...... ");
        Integer page = vicinity.getPage();
        Integer pageSize = vicinity.getPageSize();
        Vicinity vici = new Vicinity();
        vici.setTelephone(vicinity.getTelephone());
        vici.setMax((page - 1) * pageSize);
        vici.setSize(pageSize);
        vici.setLatitude(new BigDecimal(vicinity.getLat()));
        vici.setLongitude(new BigDecimal(vicinity.getLon()));
        List<UserInfoEntity> users = userService.getvicinitysort(vici);
        return ResponseEntity.initSuccessResponse(users);
    }


}
