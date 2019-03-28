package com.cn.meet.common;


import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.Constant;
import com.cn.meet.util.AesEncryptUtils;
import com.cn.meet.util.IPUtils;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

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

    //所有有效请求路径集合
    ImmutableList verfyPaths = new ImmutableList.Builder<String>()
            .add("/user/verify")
            .build();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        BodyRequestWrapper requestWrapper = null;
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            // 遇到post方法才对request进行包装
            String methodType = httpRequest.getMethod();
            String servletPath = httpRequest.getRequestURI().toString();
            // 获取请求全IP地址
            String ip = IPUtils.getRealIp((HttpServletRequest)request, 1);
            log.info(" HttpServletRequest: IP:{}, MethodType:{}, ServletPath:{}", ip, methodType, servletPath);
            requestWrapper = new BodyRequestWrapper((HttpServletRequest) request);
            if(requestWrapper == null) return;
            //仅支持POST请求格式
            if(!StringUtils.equals(methodType,"POST")){
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
        //todo 待token校验
        requestWrapper.setDecryptJson(paramStr);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
    }
}
