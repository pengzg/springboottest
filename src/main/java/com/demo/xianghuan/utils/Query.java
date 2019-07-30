package com.demo.xianghuan.utils;

import com.demo.xianghuan.utils.Pager;

import java.util.Map;

public class Query {
    private Map<String, Object> queryParams;
    private com.demo.xianghuan.utils.Pager pager;

    public Query() {
    }

    public Map<String, Object> getQueryParams() {
        return this.queryParams;
    }

    public void setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public com.demo.xianghuan.utils.Pager getPager() {
        return this.pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
