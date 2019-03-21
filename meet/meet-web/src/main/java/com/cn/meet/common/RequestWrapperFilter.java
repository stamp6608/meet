package com.cn.meet.common;


import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.util.AesEncryptUtils;
import com.cn.meet.util.IPUtils;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@WebFilter(filterName = "requestWrapperFilter", urlPatterns = {"/*"})
public class RequestWrapperFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(RequestWrapperFilter.class);
    //所有有效请求路径集合
    ImmutableList verfyPaths = new ImmutableList.Builder<String>()
            .add("/user/verify")
            .build();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, GeneralException, ServletException {
        BodyRequestWrapper requestWrapper = null;
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            // 遇到post方法才对request进行包装
            String methodType = httpRequest.getMethod();
            String servletPath = httpRequest.getRequestURI().toString();
            // 获取请求全IP地址
            String ip = IPUtils.getRealIp((HttpServletRequest)request);
            logger.info(" HttpServletRequest: IP:{}, MethodType:{}, ServletPath:{}", ip, methodType, servletPath);
            //仅支持POST请求格式
            if(!StringUtils.equals(methodType,"POST")){
                logger.error("不支持的请求方法: {}", methodType);
                throw new GeneralException(ResponseCodeEnum.NON_SUPPORT_TYPE.getMessage(), ResponseCodeEnum.NON_SUPPORT_TYPE.getCode());
            }
            requestWrapper = new BodyRequestWrapper((HttpServletRequest) request);
            if(requestWrapper == null) return;
        }
        String json = requestWrapper.getJson();
        if(StringUtils.isBlank(json))
            throw new GeneralException(ResponseCodeEnum.DECRYPT_ERROR.getMessage(), ResponseCodeEnum.DECRYPT_ERROR.getCode());
        logger.info("<<< 解密前参数: {} >>>",json);
        String paramStr;
        try{
            //参数解密
            paramStr = AesEncryptUtils.decrypt(json);
            logger.info("<<< 解密后参数：{} >>>", paramStr);
        }catch (Exception e){
            logger.error("参数解密失败... json:{}",json);
            throw new GeneralException(ResponseCodeEnum.DECRYPT_ERROR.getMessage(), ResponseCodeEnum.DECRYPT_ERROR.getCode());
        }
        //todo 待手机号校验...

        requestWrapper.setDecryptJson(paramStr);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
    }
}
