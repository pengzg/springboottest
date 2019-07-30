package com.demo.xianghuan.utils;

import java.io.Serializable;

public class RepBase implements Serializable {

    private String repCode;

    private String repMsg;

    private Object repData;

    public String getRepCode() {
        return repCode;
    }

    public void setRepCode(String repCode) {
        this.repCode = repCode;
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg;
    }

    public Object getRepData() {
        return repData;
    }

    public void setRepData(Object repData) {
        this.repData = repData;
    }

    public void setSuccess(String msg) {
        this.setRepMsg(msg);
        this.setRepCode("00");
    }
}
