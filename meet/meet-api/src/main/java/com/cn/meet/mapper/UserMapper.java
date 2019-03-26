package com.cn.meet.mapper;


import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.req.oracle.PhoneInfoReq;
import com.cn.meet.req.oracle.UserInfo2Req;
import com.cn.meet.req.oracle.UserInfo3Req;
import com.cn.meet.req.oracle.UserInfoReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     Integer checkPhone(String phone);
     Integer savePhoneVerify(PhoneInfoReq phoneInfoReq);
     Integer checkAliasName(String aliasName);
     Integer saveUserInfo(UserInfoReq userInfoReq);
     UserInfoEntity getUserInfo(UserInfo2Req userInfo2Req);
     Integer updateUserLocation(UserInfo3Req userInfoReq);
}
