package com.cn.meet.mapper;


import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.model.entity.Vicinity;
import com.cn.meet.req.oracle.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer checkPhone(String phone);

    void savePhoneVerify(PhoneInfoReq phoneInfoReq);

    Integer checkAliasName(String aliasName);

    void saveUserInfo(UserInfoReq userInfoReq);

    UserInfoEntity getUserInfo(UserInfo2Req userInfo2Req);

    String getUserToken(String telephone);

    List<UserInfoEntity> getAllUser();

    void updateUserLocation(UserInfo3Req userInfoReq);

    void logout(BaseReq baseReq);

    List<UserInfoEntity> getvicinity(Vicinity vici);

    List<UserInfoEntity> getvicinitysort(Vicinity vici);

    void updateUserFilePath(@Param("telephone") String telephone, @Param("filePath")String filePath);
}
