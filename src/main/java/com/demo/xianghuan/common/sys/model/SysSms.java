package com.demo.xianghuan.common.sys.model;

import java.util.Date;

public class SysSms implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private String ss_id;
	//触发发送短信 来源ID	
	private Integer ss_source_id;
	//触发短信发送 来源类型 1-用户(C) 2-商家 3-店铺	
	private String ss_source_type;
	//手机号码	
	private String ss_mobile;
	//短信码[验证码、优惠码等]	
	private String ss_code;
	//短信类型 1-验证码 2-普通短信	
	private String ss_type;
	//短信内容	
	private String ss_content;
	//短信发送状态 1-成功 2-失败	
	private Integer ss_state;
	//短信发送 返回信息	
	private String ss_msg;
	//短信发送时间戳	
	private Long ss_send_time;
	//	
	private Date ss_add_time;
	//columns END

	public void setSs_id(String ss_id) {
		this.ss_id = ss_id;
	}
	
	public String getSs_id() {
		return this.ss_id;
	}
	public void setSs_source_id(Integer ss_source_id) {
		this.ss_source_id = ss_source_id;
	}
	
	public Integer getSs_source_id() {
		return this.ss_source_id;
	}
	public void setSs_source_type(String ss_source_type) {
		this.ss_source_type = ss_source_type;
	}
	
	public String getSs_source_type() {
		return this.ss_source_type;
	}
	public void setSs_mobile(String ss_mobile) {
		this.ss_mobile = ss_mobile;
	}
	
	public String getSs_mobile() {
		return this.ss_mobile;
	}
	public void setSs_code(String ss_code) {
		this.ss_code = ss_code;
	}
	
	public String getSs_code() {
		return this.ss_code;
	}
	public void setSs_type(String ss_type) {
		this.ss_type = ss_type;
	}
	
	public String getSs_type() {
		return this.ss_type;
	}
	public void setSs_content(String ss_content) {
		this.ss_content = ss_content;
	}
	
	public String getSs_content() {
		return this.ss_content;
	}
	public void setSs_state(Integer ss_state) {
		this.ss_state = ss_state;
	}
	
	public Integer getSs_state() {
		return this.ss_state;
	}
	public void setSs_msg(String ss_msg) {
		this.ss_msg = ss_msg;
	}
	
	public String getSs_msg() {
		return this.ss_msg;
	}
	public void setSs_send_time(Long ss_send_time) {
		this.ss_send_time = ss_send_time;
	}
	
	public Long getSs_send_time() {
		return this.ss_send_time;
	}
	public void setSs_add_time(Date ss_add_time) {
		this.ss_add_time = ss_add_time;
	}
	
	public Date getSs_add_time() {
		return this.ss_add_time;
	}

}

