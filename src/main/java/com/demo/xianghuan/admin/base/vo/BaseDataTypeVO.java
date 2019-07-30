package com.demo.xianghuan.admin.base.vo;

public class BaseDataTypeVO implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//主键id	
	private String bdt_id;
	//字典类型编码	
	private String bdt_code;
	//类型名称	
	private String bdt_name;
	//排序	
	private Integer bdt_order;
	//字典类型 1-系统 2-用户	
	private String bdt_type;
	//所属运营商	
	private String bdt_org;
	//描述	
	private String bdt_des;
	//状态 1启用 0-禁用	
	private Integer bdt_state;
	//删除标志位	
	private Integer bdt_dr;
	//	
	private String bdt_adduser;
	//	
	private String bdt_adddate;
	//	
	private String bdt_modifyuser;
	//	
	private String bdt_modifydate;
	//	
	private String bdt_deleteuser;
	//	
	private String bdt_deletedate;
	//是否总公司	
	private String bdt_isgroup;
	//columns END

	public void setBdt_id(String bdt_id) {
		this.bdt_id = bdt_id;
	}
	
	public String getBdt_id() {
		return this.bdt_id;
	}
	public void setBdt_code(String bdt_code) {
		this.bdt_code = bdt_code;
	}
	
	public String getBdt_code() {
		return this.bdt_code;
	}
	public void setBdt_name(String bdt_name) {
		this.bdt_name = bdt_name;
	}
	
	public String getBdt_name() {
		return this.bdt_name;
	}
	public void setBdt_order(Integer bdt_order) {
		this.bdt_order = bdt_order;
	}
	
	public Integer getBdt_order() {
		return this.bdt_order;
	}
	public void setBdt_type(String bdt_type) {
		this.bdt_type = bdt_type;
	}
	
	public String getBdt_type() {
		return this.bdt_type;
	}
	public void setBdt_org(String bdt_org) {
		this.bdt_org = bdt_org;
	}
	
	public String getBdt_org() {
		return this.bdt_org;
	}
	public void setBdt_des(String bdt_des) {
		this.bdt_des = bdt_des;
	}
	
	public String getBdt_des() {
		return this.bdt_des;
	}
	public void setBdt_state(Integer bdt_state) {
		this.bdt_state = bdt_state;
	}
	
	public Integer getBdt_state() {
		return this.bdt_state;
	}
	public void setBdt_dr(Integer bdt_dr) {
		this.bdt_dr = bdt_dr;
	}
	
	public Integer getBdt_dr() {
		return this.bdt_dr;
	}
	public void setBdt_adduser(String bdt_adduser) {
		this.bdt_adduser = bdt_adduser;
	}
	
	public String getBdt_adduser() {
		return this.bdt_adduser;
	}
	public void setBdt_adddate(String bdt_adddate) {
		this.bdt_adddate = bdt_adddate;
	}
	
	public String getBdt_adddate() {
		return this.bdt_adddate;
	}
	public void setBdt_modifyuser(String bdt_modifyuser) {
		this.bdt_modifyuser = bdt_modifyuser;
	}
	
	public String getBdt_modifyuser() {
		return this.bdt_modifyuser;
	}
	public void setBdt_modifydate(String bdt_modifydate) {
		this.bdt_modifydate = bdt_modifydate;
	}
	
	public String getBdt_modifydate() {
		return this.bdt_modifydate;
	}
	public void setBdt_deleteuser(String bdt_deleteuser) {
		this.bdt_deleteuser = bdt_deleteuser;
	}
	
	public String getBdt_deleteuser() {
		return this.bdt_deleteuser;
	}
	public void setBdt_deletedate(String bdt_deletedate) {
		this.bdt_deletedate = bdt_deletedate;
	}
	
	public String getBdt_deletedate() {
		return this.bdt_deletedate;
	}
	public void setBdt_isgroup(String bdt_isgroup) {
		this.bdt_isgroup = bdt_isgroup;
	}
	
	public String getBdt_isgroup() {
		return this.bdt_isgroup;
	}

}

