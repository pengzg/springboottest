package com.demo.xianghuan.common.sys.vo;

public class SysUserVO implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//主键	
	private String su_id;
	//图像	
	private String su_img;
	//登陆名	
	private String su_loginname;
	//用户描述	
	private String su_name;
	//用户拼音	
	private String su_querycode;
	//密码	
	private String su_pwd;
	//所属公司	
	private String su_orgid;
	//有效开始日期	
	private String su_startdate;
	//有效结束日期	
	private String su_enddate;
	//用户类型  1车销  2跑单 4配送 5管理员	
	private Integer su_usertype;
	//角色	
	private Integer su_role;
	//用户状态	
	private Integer su_state;
	//最后登陆日期	
	private String su_lastlogin;
	//创建时间	
	private String su_addtime;
	//	
	private String su_updatetime;
	//删除标志位	
	private Integer su_dr;
	//时间	
	private String su_ts;
	//唯一哈希值	
	private String su_hash;
	//unionid	
	private String su_unionid;
	private String su_mobile;
	//columns END

	public void setSu_id(String su_id) {
		this.su_id = su_id;
	}
	
	public String getSu_id() {
		return this.su_id;
	}
	public void setSu_img(String su_img) {
		this.su_img = su_img;
	}
	
	public String getSu_img() {
		return this.su_img;
	}
	public void setSu_loginname(String su_loginname) {
		this.su_loginname = su_loginname;
	}
	
	public String getSu_loginname() {
		return this.su_loginname;
	}
	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}
	
	public String getSu_name() {
		return this.su_name;
	}
	public void setSu_querycode(String su_querycode) {
		this.su_querycode = su_querycode;
	}
	
	public String getSu_querycode() {
		return this.su_querycode;
	}
	public void setSu_pwd(String su_pwd) {
		this.su_pwd = su_pwd;
	}
	
	public String getSu_pwd() {
		return this.su_pwd;
	}
	public void setSu_orgid(String su_orgid) {
		this.su_orgid = su_orgid;
	}
	
	public String getSu_orgid() {
		return this.su_orgid;
	}
	public void setSu_startdate(String su_startdate) {
		this.su_startdate = su_startdate;
	}
	
	public String getSu_startdate() {
		return this.su_startdate;
	}
	public void setSu_enddate(String su_enddate) {
		this.su_enddate = su_enddate;
	}
	
	public String getSu_enddate() {
		return this.su_enddate;
	}
	public void setSu_usertype(Integer su_usertype) {
		this.su_usertype = su_usertype;
	}
	
	public Integer getSu_usertype() {
		return this.su_usertype;
	}
	public void setSu_role(Integer su_role) {
		this.su_role = su_role;
	}
	
	public Integer getSu_role() {
		return this.su_role;
	}
	public void setSu_state(Integer su_state) {
		this.su_state = su_state;
	}
	
	public Integer getSu_state() {
		return this.su_state;
	}
	public void setSu_lastlogin(String su_lastlogin) {
		this.su_lastlogin = su_lastlogin;
	}
	
	public String getSu_lastlogin() {
		return this.su_lastlogin;
	}
	public void setSu_addtime(String su_addtime) {
		this.su_addtime = su_addtime;
	}
	
	public String getSu_addtime() {
		return this.su_addtime;
	}
	public void setSu_updatetime(String su_updatetime) {
		this.su_updatetime = su_updatetime;
	}
	
	public String getSu_updatetime() {
		return this.su_updatetime;
	}
	public void setSu_dr(Integer su_dr) {
		this.su_dr = su_dr;
	}
	
	public Integer getSu_dr() {
		return this.su_dr;
	}
	public void setSu_ts(String su_ts) {
		this.su_ts = su_ts;
	}
	
	public String getSu_ts() {
		return this.su_ts;
	}
	public void setSu_hash(String su_hash) {
		this.su_hash = su_hash;
	}
	
	public String getSu_hash() {
		return this.su_hash;
	}
	public void setSu_unionid(String su_unionid) {
		this.su_unionid = su_unionid;
	}
	
	public String getSu_unionid() {
		return this.su_unionid;
	}
	public String getSu_mobile() {
		return su_mobile;
	}

	public void setSu_mobile(String su_mobile) {
		this.su_mobile = su_mobile;
	}

}

