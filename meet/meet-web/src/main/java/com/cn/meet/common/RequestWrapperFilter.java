package com.cn.meet.common;


import com.alibaba.fastjson.JSON;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.Constant;
import com.cn.meet.service.UserService;
import com.cn.meet.util.AesEncryptUtils;
import com.cn.meet.util.GeneralUtils;
import com.cn.meet.util.IPUtils;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: meet
 * @description: 请求处理过滤器
 * @author: Stamp.M
 * @create: 2019-03-19 21:42
 **/
@Slf4j
@WebFilter(filterName = "requestWrapperFilter", urlPatterns = {"/*"})
public class RequestWrapperFilter implements Filter {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private UserService userService;

    //所有有效请求路径集合
    ImmutableList paths = ImmutableList.of("/user/verify", "/user/vCode", "/user/rUser",
            "/user/info","/user/login");
    //非token请求路径集合
    ImmutableList excludeTokenPaths = ImmutableList.of("/user/verify", "/user/vCode", "/user/rUser",
            "/user/login");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        BodyRequestWrapper requestWrapper = null;
        String servletPath = "";
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            // 遇到post方法才对request进行包装
            String methodType = httpRequest.getMethod();
            servletPath = httpRequest.getRequestURI().toString();
            // 获取请求全IP地址
            String ip = IPUtils.getRealIp((HttpServletRequest)request, 1);
            log.info(" HttpServletRequest: IP:{}, MethodType:{}, ServletPath:{}", ip, methodType, servletPath);
            requestWrapper = new BodyRequestWrapper((HttpServletRequest) request);
            if(requestWrapper == null) return;
            //仅支持POST请求格式
            if(!StringUtils.equals(methodType,"POST")
                    || StringUtils.isBlank(servletPath)
                    || !paths.contains(servletPath)){
                log.error("不支持的请求方法: {}", methodType);
                requestWrapper.getSession().setAttribute(Constant.ERROR_SESSION_ENUM, ResponseCodeEnum.NON_SUPPORT_TYPE);
                requestWrapper.getRequestDispatcher("/error/msg").forward(requestWrapper,response);
                return;
            }
        }
        String json = requestWrapper.getJson();
        if(StringUtils.isBlank(json)){
            requestWrapper.getSession().setAttribute(Constant.ERROR_SESSION_ENUM, ResponseCodeEnum.DECRYPT_ERROR);
            requestWrapper.getRequestDispatcher("/error/msg").forward(requestWrapper,response);
            return;
        }
        log.info("<<< 解密前参数: {} >>>",json);
        String paramStr;
        try{
            //参数解密
            paramStr = AesEncryptUtils.decrypt(json);
            log.info("<<< 解密后参数：{} >>>", paramStr);
        }catch (Exception e){
            log.error("参数解密失败... json:{}",json);
            requestWrapper.getSession().setAttribute(Constant.ERROR_SESSION_ENUM, ResponseCodeEnum.DECRYPT_ERROR);
            requestWrapper.getRequestDispatcher("/error/msg").forward(requestWrapper,response);
            return;
        }
        if(!excludeTokenPaths.contains(servletPath)){
            String token = JSON.parseObject(paramStr).getString("token");
            String telephone = JSON.parseObject(paramStr).getString("telephone");
            if(StringUtils.isBlank(token) || StringUtils.isBlank(telephone)){
                requestWrapper.getSession().setAttribute(Constant.ERROR_SESSION_ENUM, ResponseCodeEnum.TOKEN_CHECK_ERROR);
                requestWrapper.getRequestDispatcher("/error/msg").forward(requestWrapper,response);
                return;
            }
            Object obj = redisTemplate.opsForValue().get(telephone+ Constant.USER_TOKEN);
            String cacheToken = GeneralUtils.getStringValue(obj);
            if(StringUtils.isBlank(cacheToken)){
                //缓存获取token失败，从数据库中获取token
                log.info("从缓存获取token失败...从数据库中获取token......");
                cacheToken = userService.getUserToken(telephone);
            }
            if(StringUtils.isBlank(cacheToken) || !StringUtils.equals(cacheToken, token)){
                requestWrapper.getSession().setAttribute(Constant.ERROR_SESSION_ENUM, ResponseCodeEnum.TOKEN_CHECK_ERROR);
                requestWrapper.getRequestDispatcher("/error/msg").forward(requestWrapper,response);
                return;
            }
        }
        requestWrapper.setDecryptJson(paramStr);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
    }
}
