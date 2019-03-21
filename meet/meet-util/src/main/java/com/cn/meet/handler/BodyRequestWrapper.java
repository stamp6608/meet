package com.cn.meet.handler;

import com.cn.meet.util.HttpHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;


/**
 * @program: meet
 * @description: POST请求参数处理
 * @author: Stamp.M
 * @create: 2019-03-19 21:48
 **/
public class BodyRequestWrapper extends HttpServletRequestWrapper {

    private String json;

    public BodyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        json = HttpHelper.getBodyString(request);
    }


    public String getJson() {
        return json;
    }
}
