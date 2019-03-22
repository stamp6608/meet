package com.cn.meet.controller;

import com.cn.meet.annotations.SecurityParameter;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.req.oracle.PhoneInfoReq;
import com.cn.meet.service.UserService;
import com.cn.meet.util.GeneralUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @SecurityParameter(outEncode = true)
    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity verify(BodyRequestWrapper request) throws GeneralException {
        PhoneInfoReq phone = (PhoneInfoReq) GeneralUtils.mapperParams(request, PhoneInfoReq.class);
        //手机号是否注册过验证
        if (userService.checkPhone(phone.getTelephone()))
            throw GeneralException.initEnumGeneralException(ResponseCodeEnum.PARAMETER_CHECK_ERROR);
        //todo 向手机短信验证平台获取短信验证码(此处暂时先留白，具体后面接入短信平台)
        //模拟获取短信验证码为 73748332；
        String verificationCode = "73748332";
        request.getSession().setAttribute(phone.getTelephone(), verificationCode);
        return ResponseEntity.initResponse();
    }

//    @SecurityParameter(outEncode = false)
  /*  @RequestMapping
    public PageInfo<UserInfo> getAll(UserInfo userInfo) {
        List<UserInfo> userInfoList = userInfoService.getAll(userInfo);
        return new PageInfo<UserInfo>(userInfoList);
    }

    @RequestMapping(value = "/add")
    public UserInfo add() {
        return new UserInfo();
    }

    @RequestMapping(value = "/view/{id}")
    public UserInfo view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView();
        UserInfo userInfo = userInfoService.getById(id);
        return userInfo;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        userInfoService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(UserInfo userInfo) {
        ModelMap result = new ModelMap();
        String msg = userInfo.getId() == null ? "新增成功!" : "更新成功!";
        userInfoService.save(userInfo);
        result.put("userInfo", userInfo);
        result.put("msg", msg);
        return result;
    }*/
}
