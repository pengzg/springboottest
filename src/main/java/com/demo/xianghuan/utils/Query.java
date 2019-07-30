package com.demo.xianghuan.utils;

import com.sqhz.web.model.Pager;

import java.util.Map;

public class Query {
    private Map<String, Object> queryParams;
    private com.sqhz.web.model.Pager pager;

    public Query() {
    }

    public Map<String, Object> getQueryParams() {
        return this.queryParams;
    }

    public void setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public com.sqhz.web.model.Pager getPager() {
        return this.pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
