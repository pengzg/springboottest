package com.demo.xianghuan.utils;

import java.util.ArrayList;
import java.util.List;

public class DataGrid<T> {
    private Integer total = 0;
    private List<T> resultList = new ArrayList();
    private List<T> footer;

    public DataGrid() {
    }

    public List<T> getFooter() {
        return this.footer;
    }

    public void setFooter(List<T> footer) {
        this.footer = footer;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return this.resultList;
    }

    public void setRows(List<T> resultList) {
        this.resultList = resultList;
    }
}
