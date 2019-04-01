package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

/**
 * @program: meet
 * @description: 文件下载
 * @author: Stamp.M
 * @create: 2019-03-16 20:21
 **/
public class FileReq extends BaseReq{

    //文件下载路径
    @ParamCheck
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
