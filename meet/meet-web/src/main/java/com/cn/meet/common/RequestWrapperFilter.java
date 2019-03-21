package com.cn.meet.common;


import com.cn.meet.exception.GeneralException;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.Constant;
import com.cn.meet.model.common.StatusCode;
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
                return;
            }
            requestWrapper = new BodyRequestWrapper((HttpServletRequest) request);
            if(requestWrapper == null) return;
        }
        String json = requestWrapper.getJson();
        if(StringUtils.isBlank(json))
            throw new GeneralException(Constant.PARAMETER_CHECK_ERROR, StatusCode.PARAMETER_CHECK_ERROR);
        logger.info(" 解密前参数: {} ",json);
        String paramStr;
        try{
            //参数解密
            paramStr = AesEncryptUtils.decrypt(json);
        }catch (Exception e){
            logger.error("参数解密失败... json:{}",json);
            throw new GeneralException(Constant.DECRYPT_ERROR, StatusCode.DECRYPT_ERROR);
        }
        //todo 待手机号校验...

        requestWrapper.getParameterMap().put("paramStr",new String[]{paramStr});
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
    }
}
