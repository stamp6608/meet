package com.cn.meet.mapper;


import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.req.oracle.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserMapper {
     Integer checkPhone(String phone);
     Integer savePhoneVerify(PhoneInfoReq phoneInfoReq);
     Integer checkAliasName(String aliasName);
     Integer saveUserInfo(UserInfoReq userInfoReq);
     UserInfoEntity getUserInfo(UserInfo2Req userInfo2Req);
     String getUserToken(String telephone);
     List<UserInfoEntity> getAllUser();
     Integer updateUserLocation(UserInfo3Req userInfoReq);
     Integer logout(BaseReq baseReq);
     List<UserInfoEntity> getvicinity(@Param("minlng") BigDecimal minlng, @Param("maxlng") BigDecimal maxlng,
                                      @Param("minlat") BigDecimal minlat, @Param("maxlat") BigDecimal maxlat);
     List<UserInfoEntity> getvicinitysort(@Param("longitude") BigDecimal longitude,
                                       @Param("latitude") BigDecimal latitude);
}
