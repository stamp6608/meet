package com.cn.meet.model.common;

import java.io.Serializable;

public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -2640614494974637739L;

    private String page;

    private String rows;


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }
}
