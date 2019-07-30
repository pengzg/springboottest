package com.demo.xianghuan.common.sys.model;

public class SysLoginLog implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//主键	
	private String sll_id;
	//机构编码	
	private String sll_orgid;
	//登陆账号	
	private String sll_logincode;
	//登陆名称	
	private String sll_loginname;
	//登陆时间	
	private String sll_logintime;
	//登陆IP	
	private String sll_ip;
	//登陆地址	
	private String sll_netaddress;
	//纬度	
	private String sll_longitude;
	//纬度	
	private String sll_latitude;
	//设备号	
	private String sll_equipment;
	//来源 1 web 2 手机	
	private String sll_source;
	//登陆状态	
	private Integer sll_state;
	//标志位	
	private Integer sll_dr;
	//登陆信息	
	private String sll_msg;
	//版本号	
	private Integer sll_version;
	//时间	
	private String sll_ts;
	//columns END

	public void setSll_id(String sll_id) {
		this.sll_id = sll_id;
	}
	
	public String getSll_id() {
		return this.sll_id;
	}
	public void setSll_orgid(String sll_orgid) {
		this.sll_orgid = sll_orgid;
	}
	
	public String getSll_orgid() {
		return this.sll_orgid;
	}
	public void setSll_logincode(String sll_logincode) {
		this.sll_logincode = sll_logincode;
	}
	
	public String getSll_logincode() {
		return this.sll_logincode;
	}
	public void setSll_loginname(String sll_loginname) {
		this.sll_loginname = sll_loginname;
	}
	
	public String getSll_loginname() {
		return this.sll_loginname;
	}
	public void setSll_logintime(String sll_logintime) {
		this.sll_logintime = sll_logintime;
	}
	
	public String getSll_logintime() {
		return this.sll_logintime;
	}
	public void setSll_ip(String sll_ip) {
		this.sll_ip = sll_ip;
	}
	
	public String getSll_ip() {
		return this.sll_ip;
	}
	public void setSll_netaddress(String sll_netaddress) {
		this.sll_netaddress = sll_netaddress;
	}
	
	public String getSll_netaddress() {
		return this.sll_netaddress;
	}
	public void setSll_longitude(String sll_longitude) {
		this.sll_longitude = sll_longitude;
	}
	
	public String getSll_longitude() {
		return this.sll_longitude;
	}
	public void setSll_latitude(String sll_latitude) {
		this.sll_latitude = sll_latitude;
	}
	
	public String getSll_latitude() {
		return this.sll_latitude;
	}
	public void setSll_equipment(String sll_equipment) {
		this.sll_equipment = sll_equipment;
	}
	
	public String getSll_equipment() {
		return this.sll_equipment;
	}
	public void setSll_source(String sll_source) {
		this.sll_source = sll_source;
	}
	
	public String getSll_source() {
		return this.sll_source;
	}
	public void setSll_state(Integer sll_state) {
		this.sll_state = sll_state;
	}
	
	public Integer getSll_state() {
		return this.sll_state;
	}
	public void setSll_dr(Integer sll_dr) {
		this.sll_dr = sll_dr;
	}
	
	public Integer getSll_dr() {
		return this.sll_dr;
	}
	public void setSll_msg(String sll_msg) {
		this.sll_msg = sll_msg;
	}
	
	public String getSll_msg() {
		return this.sll_msg;
	}
	public void setSll_version(Integer sll_version) {
		this.sll_version = sll_version;
	}
	
	public Integer getSll_version() {
		return this.sll_version;
	}
	public void setSll_ts(String sll_ts) {
		this.sll_ts = sll_ts;
	}
	
	public String getSll_ts() {
		return this.sll_ts;
	}

}

