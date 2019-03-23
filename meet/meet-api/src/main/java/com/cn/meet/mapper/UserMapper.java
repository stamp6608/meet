package com.cn.meet.mapper;


import com.cn.meet.req.oracle.PhoneInfoReq;
import com.cn.meet.req.oracle.UserInfoReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     Integer checkPhone(String phone);
     Integer savePhoneVerify(PhoneInfoReq phoneInfoReq);
     Integer checkAliasName(String aliasName);
     Integer saveUserInfo(UserInfoReq userInfoReq);
}
