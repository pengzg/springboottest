package com.demo.xianghuan.utils;

import org.apache.commons.lang.StringUtils;

public class Pager {
    private int page;
    private int rows;
    private String sort;
    private String order;

    public Pager() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSort() {
        if (StringUtils.isNotEmpty(this.sort) && this.sort.lastIndexOf("_nameref") > -1) {
            this.sort = this.sort.substring(0, this.sort.lastIndexOf("_nameref"));
        }

        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}