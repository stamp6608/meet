package com.cn.meet.service;

import com.cn.meet.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    /*public List<UserInfo> getAll(UserInfo UserInfo) {
        if (UserInfo.getPage() != null && UserInfo.getRows() != null) {
            PageHelper.startPage(UserInfo.getPage(), UserInfo.getRows(), "id");
        }
        return userInfoMapper.selectAll();
    }*/

   /* public UserInfo getById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }*/

    /*public void deleteById(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(UserInfo country) {
        if (country.getId() != null) {
            userInfoMapper.updateByPrimaryKey(country);
        } else {
            userInfoMapper.insert(country);
        }
    }*/
}
