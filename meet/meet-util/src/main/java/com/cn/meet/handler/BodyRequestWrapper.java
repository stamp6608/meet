package com.cn.meet.handler;

import com.alibaba.fastjson.JSON;
import com.cn.meet.util.HttpHelper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


/**
 * @program: meet
 * @description: POST请求参数处理
 * @author: Stamp.M
 * @create: 2019-03-19 21:48
 **/
public class BodyRequestWrapper extends HttpServletRequestWrapper {

    private String json;
    private String decryptJson;
    private final byte[] body;

    public BodyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        json = HttpHelper.getBodyString(request);
        body = json.getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }


    public String getJson() {
        String res = "";
        if (StringUtils.isNotBlank(json)) {
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
