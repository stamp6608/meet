package com.cn.meet.controller;

import com.cn.meet.annotations.SecurityParameter;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.req.oracle.PhoneInfoReq;
import com.cn.meet.req.oracle.UserInfo2Req;
import com.cn.meet.req.oracle.UserInfoReq;
import com.cn.meet.service.UserService;
import com.cn.meet.util.DateUtils;
import com.cn.meet.util.GeneralUtils;
import com.cn.meet.util.IPUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @program: meet
 * @description: 用户管理类
 * @author: Stamp.M
 * @create: 2019-03-06 19:20
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @Description: 获取手机短信验证 (需接入第三方手机短信验证平台)
     * @Param: [userInfo]
     * @return: ResponseEntity
     * @Author: Stamp.M
     * @Date: 2019/3/21
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
    * @Description: 手机短信验证码验证
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */ 
    @SecurityParameter
    @PostMapping("/vCode")
    @ResponseBody
    public ResponseEntity vCode(BodyRequestWrapper request) throws GeneralException {
        PhoneInfoReq phone = (PhoneInfoReq) GeneralUtils.mapperParams(request, PhoneInfoReq.class);
        String verifyCode = phone.getVerifyCode();
        Object obj = request.getSession().getAttribute(phone.getTelephone());
        String code = Optional.ofNullable(obj)
                .map(a-> String.valueOf(a))
                .orElse("");
        if(StringUtils.isBlank(verifyCode) || StringUtils.isBlank(code)
                || !StringUtils.equals(verifyCode, code))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.PHONE_VERIFY_ERROR);
        //保存手机信息
        userService.savePhoneVerify(phone);
        //销毁短信验证码
        request.getSession().removeAttribute(phone.getTelephone());
        return ResponseEntity.initResponse();
    }

    /** 
    * @Description: 用户信息注册
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */ 
    @SecurityParameter
    @PostMapping("/rUser")
    @ResponseBody
    public ResponseEntity registUser(BodyRequestWrapper request) throws GeneralException {
        UserInfoReq user = (UserInfoReq) GeneralUtils.mapperParams(request, UserInfoReq.class);
        //别名重复性校验
        if(userService.checkAliasName(user.getAliasName()))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.ALIAS_NAME_ERROR);
        user.setCreateTime(DateUtils.getSecondTimestamp(new Date()));
        user.setUpdateTime(0);
        String ip= IPUtils.getRealIp(request, 0);
        user.setIp(ip);
        userService.saveUserInfo(user);
        return ResponseEntity.initResponse();
    }


    /** 
    * @Description: 查询用户个人信息
    * @Param: [request] 
    * @return: com.cn.meet.model.common.ResponseEntity 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */ 
    @SecurityParameter
    @PostMapping("/info")
    @ResponseBody
    public ResponseEntity userInfo(BodyRequestWrapper request) throws GeneralException {
        UserInfo2Req userReq = (UserInfo2Req) GeneralUtils.mapperParams(request, UserInfo2Req.class);
        UserInfoEntity user  = userService.getUserInfo(userReq);
        return ResponseEntity.initSuccessResponse(user);
    }


}
