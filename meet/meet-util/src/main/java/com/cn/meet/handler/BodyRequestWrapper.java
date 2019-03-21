package com.cn.meet.handler;

import com.alibaba.fastjson.JSON;
import com.cn.meet.util.HttpHelper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;


/**
 * @program: meet
 * @description: POST请求参数处理
 * @author: Stamp.M
 * @create: 2019-03-19 21:48
 **/
public class BodyRequestWrapper extends HttpServletRequestWrapper{

    private String json;
    private String decryptJson;

    public BodyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        json = HttpHelper.getBodyString(request);
    }


    public String getJson() {
        String res = "";
        if(StringUtils.isNotBlank(json)){
            res = JSON.parseObject(json).getString("param");
        }
        return res;
    }

    public String getDecryptJson() {
        return decryptJson;
    }

    public void setDecryptJson(String decryptJson) {
        this.decryptJson = decryptJson;
    }
}
