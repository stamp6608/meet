package com.cn.meet.req.oracle;

/**
 * @program: meet
 * @description: 请求基础类
 * @author: Stamp.M
 * @create: 2019-03-28 18:42
 **/
public class BaseReq {
    //手机号
    private String telephone;
    //登陆成功的令牌
    private String token;
    //页码
    private Integer page;
    //页数
    private Integer pageSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
