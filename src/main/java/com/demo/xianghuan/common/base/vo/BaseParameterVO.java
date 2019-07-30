package com.demo.xianghuan.common.base.vo;

import java.util.Date;

public class BaseParameterVO implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//主键	
	private String bp_id;
	//键	
	private String bp_key;
	//值	
	private String bp_value;
	//备注	
	private String bp_remark;
	//版本	
	private Integer bp_version;
	//新增人	
	private String bp_adduser;
	//修改人	
	private String bp_updateuser;
	//状态	
	private Integer bp_state;
	//删除标志位	
	private Integer bp_dr;
	//新增时间	
	private Date bp_addtime;
	//修改时间	
	private Date bp_updatetime;
	//	
	private Integer bp_level;
	//columns END

	public void setBp_id(String bp_id) {
		this.bp_id = bp_id;
	}
	
	public String getBp_id() {
		return this.bp_id;
	}
	public void setBp_key(String bp_key) {
		this.bp_key = bp_key;
	}
	
	public String getBp_key() {
		return this.bp_key;
	}
	public void setBp_value(String bp_value) {
		this.bp_value = bp_value;
	}
	
	public String getBp_value() {
		return this.bp_value;
	}
	public void setBp_remark(String bp_remark) {
		this.bp_remark = bp_remark;
	}
	
	public String getBp_remark() {
		return this.bp_remark;
	}
	public void setBp_version(Integer bp_version) {
		this.bp_version = bp_version;
	}
	
	public Integer getBp_version() {
		return this.bp_version;
	}
	public void setBp_adduser(String bp_adduser) {
		this.bp_adduser = bp_adduser;
	}
	
	public String getBp_adduser() {
		return this.bp_adduser;
	}
	public void setBp_updateuser(String bp_updateuser) {
		this.bp_updateuser = bp_updateuser;
	}
	
	public String getBp_updateuser() {
		return this.bp_updateuser;
	}
	public void setBp_state(Integer bp_state) {
		this.bp_state = bp_state;
	}
	
	public Integer getBp_state() {
		return this.bp_state;
	}
	public void setBp_dr(Integer bp_dr) {
		this.bp_dr = bp_dr;
	}
	
	public Integer getBp_dr() {
		return this.bp_dr;
	}
	public void setBp_addtime(Date bp_addtime) {
		this.bp_addtime = bp_addtime;
	}
	
	public Date getBp_addtime() {
		return this.bp_addtime;
	}
	public void setBp_updatetime(Date bp_updatetime) {
		this.bp_updatetime = bp_updatetime;
	}
	
	public Date getBp_updatetime() {
		return this.bp_updatetime;
	}
	public void setBp_level(Integer bp_level) {
		this.bp_level = bp_level;
	}
	
	public Integer getBp_level() {
		return this.bp_level;
	}

}

