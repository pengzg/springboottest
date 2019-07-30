package com.demo.xianghuan.admin.base.model;

public class BaseAttachmentRel implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private String bar_id;
	//图片来源1商品，2 签到 3.订水库存	
	private Integer bar_source;
	//商品描述id	
	private String bar_source_id;
	//图片id	
	private String bar_attament_id;
	//状态	
	private Integer bar_state;
	//wtr_dr	
	private Integer bar_dr;
	//添加时间	
	private String bar_add_time;
	//操作人	
	private String bar_add_userid;
	//排序	
	private Integer bar_order;
	//columns END

	public void setBar_id(String bar_id) {
		this.bar_id = bar_id;
	}
	
	public String getBar_id() {
		return this.bar_id;
	}
	public void setBar_source(Integer bar_source) {
		this.bar_source = bar_source;
	}
	
	public Integer getBar_source() {
		return this.bar_source;
	}
	public void setBar_source_id(String bar_source_id) {
		this.bar_source_id = bar_source_id;
	}
	
	public String getBar_source_id() {
		return this.bar_source_id;
	}
	public void setBar_attament_id(String bar_attament_id) {
		this.bar_attament_id = bar_attament_id;
	}
	
	public String getBar_attament_id() {
		return this.bar_attament_id;
	}
	public void setBar_state(Integer bar_state) {
		this.bar_state = bar_state;
	}
	
	public Integer getBar_state() {
		return this.bar_state;
	}
	public void setBar_dr(Integer bar_dr) {
		this.bar_dr = bar_dr;
	}
	
	public Integer getBar_dr() {
		return this.bar_dr;
	}
	public void setBar_add_time(String bar_add_time) {
		this.bar_add_time = bar_add_time;
	}
	
	public String getBar_add_time() {
		return this.bar_add_time;
	}
	public void setBar_add_userid(String bar_add_userid) {
		this.bar_add_userid = bar_add_userid;
	}
	
	public String getBar_add_userid() {
		return this.bar_add_userid;
	}
	public void setBar_order(Integer bar_order) {
		this.bar_order = bar_order;
	}
	
	public Integer getBar_order() {
		return this.bar_order;
	}

}

