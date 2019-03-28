package com.cn.meet.advice;

import com.cn.meet.model.common.Constant;
import com.cn.meet.model.entity.UserInfoEntity;
import com.cn.meet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @program: meet
 * @description: 初始化缓存
 * @author: Stamp.M
 * @create: 2019-03-28 14:47
 **/
@Slf4j
@Component
public class InitCache {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Resource
    private UserService userService;

    @PostConstruct
    public void initCache() {
        log.info("init cache begin......");
        List<UserInfoEntity> list = userService.getAllUser();
        log.info(" cur size of users is : {}",list.size());
        redisTemplate.opsForValue().set(Constant.USERS_CACHE_INIT, list);
        log.info("init cache end......");
//        List<UserInfoEntity> users = (List<UserInfoEntity>)redisTemplate.opsForValue().get(Constant.USERS_CACHE_INIT);
//        log.info(" cur length is : "+users);
    }

}
