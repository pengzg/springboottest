package com.demo.xianghuan.common.sys.vo;

import java.util.ArrayList;
import java.util.List;

public class MenusListVO{
    private String sm_id;
    //
    private String sm_name;
    //
    private String sm_url;
    //
    private String sm_pid;
    //
    private String sm_iconcls;
    //菜单级别
    private String sm_level;



    private List<MenusListVO> childMenus = new ArrayList<>();

    public String getSm_id() {
        return sm_id;
    }

    public void setSm_id(String sm_id) {
        this.sm_id = sm_id;
    }

    public String getSm_name() {
        return sm_name;
    }


    public void setSm_name(String sm_name) {
        this.sm_name = sm_name;
    }

    public String getSm_url() {
        return sm_url;
    }

    public void setSm_url(String sm_url) {
        this.sm_url = sm_url;
    }

    public String getSm_pid() {
        return sm_pid;
    }

    public void setSm_pid(String sm_pid) {
        this.sm_pid = sm_pid;
    }

    public String getSm_iconcls() {
        return sm_iconcls;
    }

    public void setSm_iconcls(String sm_iconcls) {
        this.sm_iconcls = sm_iconcls;
    }

    public String getSm_level() {
        return sm_level;
    }

    public void setSm_level(String sm_level) {
        this.sm_level = sm_level;
    }

    public List<MenusListVO> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenusListVO> childMenus) {
        this.childMenus = childMenus;
    }
}
