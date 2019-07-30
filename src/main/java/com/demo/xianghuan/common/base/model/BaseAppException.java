package com.demo.xianghuan.common.base.model;

public class BaseAppException implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//主键	
	private String bae_id;
	//公司	
	private String bae_orgid;
	//设备名	
	private String bae_device_name;
	//1.盒子安卓 2盒子ios 3小店安卓 4 小店ios	
	private Integer bae_device_type;
	//设备号	
	private String bae_device_code;
	//系统版本	
	private String bae_sys_version;
	//页面	
	private String bae_page;
	//异常内容	
	private String bae_msg;
	//用户id	
	private String bae_userid;
	//添加时间	
	private String bae_addtime;
	//columns END

	public void setBae_id(String bae_id) {
		this.bae_id = bae_id;
	}
	
	public String getBae_id() {
		return this.bae_id;
	}
	public void setBae_orgid(String bae_orgid) {
		this.bae_orgid = bae_orgid;
	}
	
	public String getBae_orgid() {
		return this.bae_orgid;
	}
	public void setBae_device_name(String bae_device_name) {
		this.bae_device_name = bae_device_name;
	}
	
	public String getBae_device_name() {
		return this.bae_device_name;
	}
	public void setBae_device_type(Integer bae_device_type) {
		this.bae_device_type = bae_device_type;
	}
	
	public Integer getBae_device_type() {
		return this.bae_device_type;
	}
	public void setBae_device_code(String bae_device_code) {
		this.bae_device_code = bae_device_code;
	}
	
	public String getBae_device_code() {
		return this.bae_device_code;
	}
	public void setBae_sys_version(String bae_sys_version) {
		this.bae_sys_version = bae_sys_version;
	}
	
	public String getBae_sys_version() {
		return this.bae_sys_version;
	}
	public void setBae_page(String bae_page) {
		this.bae_page = bae_page;
	}
	
	public String getBae_page() {
		return this.bae_page;
	}
	public void setBae_msg(String bae_msg) {
		this.bae_msg = bae_msg;
	}
	
	public String getBae_msg() {
		return this.bae_msg;
	}
	public void setBae_userid(String bae_userid) {
		this.bae_userid = bae_userid;
	}
	
	public String getBae_userid() {
		return this.bae_userid;
	}
	public void setBae_addtime(String bae_addtime) {
		this.bae_addtime = bae_addtime;
	}
	
	public String getBae_addtime() {
		return this.bae_addtime;
	}

}

