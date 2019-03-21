package com.cn.meet.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     Integer checkPhone(String phone);
}
