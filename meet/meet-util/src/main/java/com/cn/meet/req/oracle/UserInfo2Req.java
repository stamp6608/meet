package com.cn.meet.req.oracle;

import com.cn.meet.annotations.ParamCheck;

/**
 * @program: meet
 * @description: 用户信息查询2
 * @author: Stamp.M
 * @create: 2019-03-23 22:33
 **/
public class UserInfo2Req extends BaseReq{

    //别名
    @ParamCheck
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
