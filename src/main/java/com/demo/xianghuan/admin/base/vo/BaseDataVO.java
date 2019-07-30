package com.demo.xianghuan.admin.base.vo;

public class BaseDataVO implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private String bd_id;
	//字典编码	
	private String bd_code;
	//名称	
	private String bd_name;
	//排序	
	private Integer bd_order;
	//父级id	
	private String bd_pid;
	//字典类型id	
	private String bd_datatypeid;
	//所属运营商	
	private String bd_org;
	//描述	
	private String bd_des;
	//状态 1启用 0-禁用	
	private Integer bd_state;
	//删除标识位	
	private Integer bd_dr;
	//	
	private String bd_adduser;
	//	
	private String bd_adddate;
	//	
	private String bd_modifyuser;
	//	
	private String bd_modifydate;
	//	
	private String bd_deleteuser;
	//	
	private String bd_deletedate;
	//columns END

	public void setBd_id(String bd_id) {
		this.bd_id = bd_id;
	}
	
	public String getBd_id() {
		return this.bd_id;
	}
	public void setBd_code(String bd_code) {
		this.bd_code = bd_code;
	}
	
	public String getBd_code() {
		return this.bd_code;
	}
	public void setBd_name(String bd_name) {
		this.bd_name = bd_name;
	}
	
	public String getBd_name() {
		return this.bd_name;
	}
	public void setBd_order(Integer bd_order) {
		this.bd_order = bd_order;
	}
	
	public Integer getBd_order() {
		return this.bd_order;
	}
	public void setBd_pid(String bd_pid) {
		this.bd_pid = bd_pid;
	}
	
	public String getBd_pid() {
		return this.bd_pid;
	}
	public void setBd_datatypeid(String bd_datatypeid) {
		this.bd_datatypeid = bd_datatypeid;
	}
	
	public String getBd_datatypeid() {
		return this.bd_datatypeid;
	}
	public void setBd_org(String bd_org) {
		this.bd_org = bd_org;
	}
	
	public String getBd_org() {
		return this.bd_org;
	}
	public void setBd_des(String bd_des) {
		this.bd_des = bd_des;
	}
	
	public String getBd_des() {
		return this.bd_des;
	}
	public void setBd_state(Integer bd_state) {
		this.bd_state = bd_state;
	}
	
	public Integer getBd_state() {
		return this.bd_state;
	}
	public void setBd_dr(Integer bd_dr) {
		this.bd_dr = bd_dr;
	}
	
	public Integer getBd_dr() {
		return this.bd_dr;
	}
	public void setBd_adduser(String bd_adduser) {
		this.bd_adduser = bd_adduser;
	}
	
	public String getBd_adduser() {
		return this.bd_adduser;
	}
	public void setBd_adddate(String bd_adddate) {
		this.bd_adddate = bd_adddate;
	}
	
	public String getBd_adddate() {
		return this.bd_adddate;
	}
	public void setBd_modifyuser(String bd_modifyuser) {
		this.bd_modifyuser = bd_modifyuser;
	}
	
	public String getBd_modifyuser() {
		return this.bd_modifyuser;
	}
	public void setBd_modifydate(String bd_modifydate) {
		this.bd_modifydate = bd_modifydate;
	}
	
	public String getBd_modifydate() {
		return this.bd_modifydate;
	}
	public void setBd_deleteuser(String bd_deleteuser) {
		this.bd_deleteuser = bd_deleteuser;
	}
	
	public String getBd_deleteuser() {
		return this.bd_deleteuser;
	}
	public void setBd_deletedate(String bd_deletedate) {
		this.bd_deletedate = bd_deletedate;
	}
	
	public String getBd_deletedate() {
		return this.bd_deletedate;
	}

}

