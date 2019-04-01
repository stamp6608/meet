package com.cn.meet.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: meet
 * @description: 文件路径配置
 * @author: Stamp.M
 * @create: 2019-04-01 13:47
 **/
@Component
@ConfigurationProperties(prefix = "file.path")
public class FilePathConfig {
    private String register;

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }
}
