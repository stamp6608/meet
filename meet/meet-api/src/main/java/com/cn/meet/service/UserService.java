package com.cn.meet.service;

import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.mapper.UserMapper;
import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.req.oracle.PhoneInfoReq;
import com.cn.meet.req.oracle.UserInfo2Req;
import com.cn.meet.req.oracle.UserInfo3Req;
import com.cn.meet.req.oracle.UserInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/** 
* @Description: 用户管理Service
* @Author: Stamp.M 
* @Date: 2019/3/21 
*/ 
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /** 
    * @Description: 校验手机号是否已经注册
    * @Param: [phone]
    * @return: Boolean
    * @Author: Stamp.M 
    * @Date: 2019/3/21 
    */ 
    public Boolean checkPhone(String phone) {
        return userMapper.checkPhone(phone) != 0;
    }

    /**
    * @Description: 注册手机验证信息
    * @Param: [phoneInfoReq]
    * @return: void
    * @Author: Stamp.M
    * @Date: 2019/3/23
    */
    @Transactional
    public void savePhoneVerify(PhoneInfoReq phoneInfoReq) throws GeneralException{
        Integer res = userMapper.savePhoneVerify(phoneInfoReq);
        if(res != 1) throw GeneralException.initEnumGeneralException(ResponseCodeEnum.INNER_ERROR);
    }

    /** 
    * @Description: 校验用户别名是否已经存在 
    * @Param: [aliasName] 
    * @return: boolean 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */ 
    public boolean checkAliasName(String aliasName){
        return userMapper.checkAliasName(aliasName) != 0;
    }

    /** 
    * @Description: 保存用户信息
    * @Param: [userInfoReq] 
    * @return: void 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */
    @Transactional
    public void saveUserInfo(UserInfoReq userInfoReq) throws GeneralException{
        Integer res = userMapper.saveUserInfo(userInfoReq);
        if(res != 1) throw GeneralException.initEnumGeneralException(ResponseCodeEnum.INNER_ERROR);
    }

    /** 
    * @Description: 用户信息查询 
    * @Param: [userInfo2Req] 
    * @return: com.cn.meet.model.entity.UserInfoEntity 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */ 
    public UserInfoEntity getUserInfo(UserInfo2Req userInfo2Req){
        return userMapper.getUserInfo(userInfo2Req);
    }

    
    /** 
    * @Description: 获取用户token
    * @Param: [telephone] 
    * @return: com.cn.meet.model.entity.UserInfoEntity 
    * @Author: Stamp.M
    * @Date: 2019/3/28 
    */ 
    public String getUserToken(String telephone){
        return userMapper.getUserToken(telephone);
    }
    
    /** 
    * @Description: 获取所有用户信息
    * @Param: [] 
    * @return: java.util.List<com.cn.meet.model.entity.UserInfoEntity> 
    * @Author: Stamp.M 
    * @Date: 2019/3/28 
    */ 
    public List<UserInfoEntity> getAllUser(){
        return userMapper.getAllUser();
    }

    /**
     * @Description: 更改用户经度和维度信息
     * @Param: [userInfoReq]
     * @return: void
     * @Author: Stamp.M
     * @Date: 2019/3/23
     */
    @Transactional
    public void updateUserLocation(UserInfo3Req userInfoReq) throws GeneralException{
        Integer res = userMapper.updateUserLocation(userInfoReq);
        if(res != 1) throw GeneralException.initEnumGeneralException(ResponseCodeEnum.INNER_ERROR);
    }

}
