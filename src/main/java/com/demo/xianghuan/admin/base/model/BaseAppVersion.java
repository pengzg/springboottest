package com.demo.xianghuan.admin.base.model;

public class BaseAppVersion implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//主键ID	
	private String bv_id;
	//APP类型 1-android 2-ios	
	private String bv_app_type;
	//版本号	
	private String bv_version1;
	//下载地址	
	private String bv_down_url;
	//更新内容	
	private String bv_desc;
	//状态 1-启用 2-禁用	
	private Integer bv_state;
	//删除标志位 	
	private Integer bv_dr;
	//	
	private String bv_addtime;
	//	
	private Integer bv_adduser;
	//否是强制升级 1-强制 2-不强制	
	private Integer bv_upgrade;
	//1app业务员端 2 小店端	
	private Integer bv_source;
	//	
	private String bv_version_name;
	//columns END

	public void setBv_id(String bv_id) {
		this.bv_id = bv_id;
	}
	
	public String getBv_id() {
		return this.bv_id;
	}
	public void setBv_app_type(String bv_app_type) {
		this.bv_app_type = bv_app_type;
	}
	
	public String getBv_app_type() {
		return this.bv_app_type;
	}
	public void setBv_version1(String bv_version1) {
		this.bv_version1 = bv_version1;
	}
	
	public String getBv_version1() {
		return this.bv_version1;
	}
	public void setBv_down_url(String bv_down_url) {
		this.bv_down_url = bv_down_url;
	}
	
	public String getBv_down_url() {
		return this.bv_down_url;
	}
	public void setBv_desc(String bv_desc) {
		this.bv_desc = bv_desc;
	}
	
	public String getBv_desc() {
		return this.bv_desc;
	}
	public void setBv_state(Integer bv_state) {
		this.bv_state = bv_state;
	}
	
	public Integer getBv_state() {
		return this.bv_state;
	}
	public void setBv_dr(Integer bv_dr) {
		this.bv_dr = bv_dr;
	}
	
	public Integer getBv_dr() {
		return this.bv_dr;
	}
	public void setBv_addtime(String bv_addtime) {
		this.bv_addtime = bv_addtime;
	}
	
	public String getBv_addtime() {
		return this.bv_addtime;
	}
	public void setBv_adduser(Integer bv_adduser) {
		this.bv_adduser = bv_adduser;
	}
	
	public Integer getBv_adduser() {
		return this.bv_adduser;
	}
	public void setBv_upgrade(Integer bv_upgrade) {
		this.bv_upgrade = bv_upgrade;
	}
	
	public Integer getBv_upgrade() {
		return this.bv_upgrade;
	}
	public void setBv_source(Integer bv_source) {
		this.bv_source = bv_source;
	}
	
	public Integer getBv_source() {
		return this.bv_source;
	}
	public void setBv_version_name(String bv_version_name) {
		this.bv_version_name = bv_version_name;
	}
	
	public String getBv_version_name() {
		return this.bv_version_name;
	}

}

