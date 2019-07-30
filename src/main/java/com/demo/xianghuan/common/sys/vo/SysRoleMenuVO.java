package com.demo.xianghuan.common.sys.vo;

public class SysRoleMenuVO implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private String srm_id;
	//	
	private String srm_roleid;
	//	
	private String srm_menuid;
	//	
	private Integer srm_state;
	//	
	private Integer srm_dr;
	//	
	private String srm_addtime;
	//	
	private String srm_updatetime;
	//	
	private String srm_ts;
	//columns END

	public void setSrm_id(String srm_id) {
		this.srm_id = srm_id;
	}
	
	public String getSrm_id() {
		return this.srm_id;
	}
	public void setSrm_roleid(String srm_roleid) {
		this.srm_roleid = srm_roleid;
	}
	
	public String getSrm_roleid() {
		return this.srm_roleid;
	}
	public void setSrm_menuid(String srm_menuid) {
		this.srm_menuid = srm_menuid;
	}
	
	public String getSrm_menuid() {
		return this.srm_menuid;
	}
	public void setSrm_state(Integer srm_state) {
		this.srm_state = srm_state;
	}
	
	public Integer getSrm_state() {
		return this.srm_state;
	}
	public void setSrm_dr(Integer srm_dr) {
		this.srm_dr = srm_dr;
	}
	
	public Integer getSrm_dr() {
		return this.srm_dr;
	}
	public void setSrm_addtime(String srm_addtime) {
		this.srm_addtime = srm_addtime;
	}
	
	public String getSrm_addtime() {
		return this.srm_addtime;
	}
	public void setSrm_updatetime(String srm_updatetime) {
		this.srm_updatetime = srm_updatetime;
	}
	
	public String getSrm_updatetime() {
		return this.srm_updatetime;
	}
	public void setSrm_ts(String srm_ts) {
		this.srm_ts = srm_ts;
	}
	
	public String getSrm_ts() {
		return this.srm_ts;
	}

}

