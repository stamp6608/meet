package com.cn.meet.service;

import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.exception.GeneralException;
import com.cn.meet.mapper.UserMapper;
import com.cn.meet.req.oracle.PhoneInfoReq;
import com.cn.meet.req.oracle.UserInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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


}
