package com.demo.xianghuan.admin.base.model;

public class BaseAttachment implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;


	//columns START111
	//自增id
	private String ba_id;
	//所属公司
	private String ba_orgid;
	//商品图片标题
	private String ba_tittle;
	//路径
	private String ba_path;

	//类型（0-其他；1-图片；2-视频）
	private Integer ba_type;
	//附件尺寸
	private Integer ba_size;
	//原始文件名称
	private String ba_file_name;
	//附件描述
	private String ba_description;
	//状态
	private Integer ba_state;
	//添加时间
	private String ba_add_time;
	//上传用户id
	private String ba_adduserid;
	//
	private Integer ba_dr;
	//columns END

	public void setBa_id(String ba_id) {
		this.ba_id = ba_id;
	}

	public String getBa_id() {
		return this.ba_id;
	}
	public void setBa_orgid(String ba_orgid) {
		this.ba_orgid = ba_orgid;
	}

	public String getBa_orgid() {
		return this.ba_orgid;
	}
	public void setBa_tittle(String ba_tittle) {
		this.ba_tittle = ba_tittle;
	}

	public String getBa_tittle() {
		return this.ba_tittle;
	}
	public void setBa_path(String ba_path) {
		this.ba_path = ba_path;
	}

	public String getBa_path() {
		return this.ba_path;
	}
	public void setBa_type(Integer ba_type) {
		this.ba_type = ba_type;
	}

	public Integer getBa_type() {
		return this.ba_type;
	}
	public void setBa_size(Integer ba_size) {
		this.ba_size = ba_size;
	}

	public Integer getBa_size() {
		return this.ba_size;
	}
	public void setBa_file_name(String ba_file_name) {
		this.ba_file_name = ba_file_name;
	}

	public String getBa_file_name() {
		return this.ba_file_name;
	}
	public void setBa_description(String ba_description) {
		this.ba_description = ba_description;
	}

	public String getBa_description() {
		return this.ba_description;
	}
	public void setBa_state(Integer ba_status) {
		this.ba_state = ba_state;
	}

	public Integer getBa_state() {
		return this.ba_state;
	}
	public void setBa_add_time(String ba_add_time) {
		this.ba_add_time = ba_add_time;
	}

	public String getBa_add_time() {
		return this.ba_add_time;
	}
	public void setBa_adduserid(String ba_adduserid) {
		this.ba_adduserid = ba_adduserid;
	}

	public String getBa_adduserid() {
		return this.ba_adduserid;
	}
	public void setBa_dr(Integer ba_dr) {
		this.ba_dr = ba_dr;
	}

	public Integer getBa_dr() {
		return this.ba_dr;
	}


}

