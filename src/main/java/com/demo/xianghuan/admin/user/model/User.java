package com.demo.xianghuan.admin.user.model;


public class User implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private Integer id;
	//	
	private Integer company_id;
	//	
	private Integer open_card_id;
	//公众平台open_id	
	private String open_id;
	//用户名	
	private String user_name;
	//昵称	
	private String nickname;
	//	
	private String realname;
	//主持人头像	
	private String avatar;
	//手机号	
	private String mobile;
	//用户邮箱	
	private String email;
	//是否激活过邮箱	
	private Integer is_check_email;
	//生日	
	private java.util.Date birthday;
	//0：女，1：男，2：未知	
	private Boolean gender;
	//所在国家	
	private String country;
	//所在省	
	private String province;
	//所在城市	
	private String city;
	//所在地区	
	private String district;
	//密码	
	private String password;
	//	
	private String hash;
	//	
	private String intro;
	//用户来自哪里？ weixin sinaweibo qq baidu glassapp ...	
	private String user_from;
	//上次登录的时间	
	private java.util.Date last_login_time;
	//推广人	
	private String spread;
	//推广码	
	private String spread_code;
	//推广时间	
	private String spread_time;
	//用户角色字段 10：总部  20：物业 30 社区  40 商家  50 店铺 60： 街道办 88：普通用户(会员);89推广员	
	private Integer user_type;
	//关联的id	
	private Integer type_id;
	//	
	private java.util.Date follow_time;
	//	
	private Boolean status;
	//	
	private java.util.Date update_time;
	//	
	private java.util.Date add_time;
	//是否关注 1是 0否	
	private Integer is_followed;
	//取消关注时间	
	private java.util.Date unfollow_time;
	//1关注，2未关注	
	private Integer is_scan;
	//推广码	
	private String extension;
	//是否已在app上注册过1 是 2 否	
	private Integer is_app;
	//会员等级	
	private Integer user_level;
	//	
	private String wx_open_id;
	//	
	private String qq_open_id;
	//1登陆 2 未登录	
	private Integer login_status;
	//启用标志位1启用 0禁用	
	private Integer status1;
	//生效时间	
	private java.util.Date start_efficient_time;
	//失效时间	
	private java.util.Date end_efficient_time;
	//推广人临时码	
	private Integer temp_spread;
	//columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	
	public Integer getCompany_id() {
		return this.company_id;
	}
	public void setOpen_card_id(Integer open_card_id) {
		this.open_card_id = open_card_id;
	}
	
	public Integer getOpen_card_id() {
		return this.open_card_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	
	public String getOpen_id() {
		return this.open_id;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_name() {
		return this.user_name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public String getRealname() {
		return this.realname;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setIs_check_email(Integer is_check_email) {
		this.is_check_email = is_check_email;
	}
	
	public Integer getIs_check_email() {
		return this.is_check_email;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	public Boolean getGender() {
		return this.gender;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getProvince() {
		return this.province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getDistrict() {
		return this.district;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public String getHash() {
		return this.hash;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getIntro() {
		return this.intro;
	}
	public void setUser_from(String user_from) {
		this.user_from = user_from;
	}
	
	public String getUser_from() {
		return this.user_from;
	}
	public void setLast_login_time(java.util.Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	
	public java.util.Date getLast_login_time() {
		return this.last_login_time;
	}
	public void setSpread(String spread) {
		this.spread = spread;
	}
	
	public String getSpread() {
		return this.spread;
	}
	public void setSpread_code(String spread_code) {
		this.spread_code = spread_code;
	}
	
	public String getSpread_code() {
		return this.spread_code;
	}
	public void setSpread_time(String spread_time) {
		this.spread_time = spread_time;
	}
	
	public String getSpread_time() {
		return this.spread_time;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	
	public Integer getUser_type() {
		return this.user_type;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	
	public Integer getType_id() {
		return this.type_id;
	}
	public void setFollow_time(java.util.Date follow_time) {
		this.follow_time = follow_time;
	}
	
	public java.util.Date getFollow_time() {
		return this.follow_time;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Boolean getStatus() {
		return this.status;
	}
	public void setUpdate_time(java.util.Date update_time) {
		this.update_time = update_time;
	}
	
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}
	public void setAdd_time(java.util.Date add_time) {
		this.add_time = add_time;
	}
	
	public java.util.Date getAdd_time() {
		return this.add_time;
	}
	public void setIs_followed(Integer is_followed) {
		this.is_followed = is_followed;
	}
	
	public Integer getIs_followed() {
		return this.is_followed;
	}
	public void setUnfollow_time(java.util.Date unfollow_time) {
		this.unfollow_time = unfollow_time;
	}
	
	public java.util.Date getUnfollow_time() {
		return this.unfollow_time;
	}
	public void setIs_scan(Integer is_scan) {
		this.is_scan = is_scan;
	}
	
	public Integer getIs_scan() {
		return this.is_scan;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return this.extension;
	}
	public void setIs_app(Integer is_app) {
		this.is_app = is_app;
	}
	
	public Integer getIs_app() {
		return this.is_app;
	}
	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}
	
	public Integer getUser_level() {
		return this.user_level;
	}
	public void setWx_open_id(String wx_open_id) {
		this.wx_open_id = wx_open_id;
	}
	
	public String getWx_open_id() {
		return this.wx_open_id;
	}
	public void setQq_open_id(String qq_open_id) {
		this.qq_open_id = qq_open_id;
	}
	
	public String getQq_open_id() {
		return this.qq_open_id;
	}
	public void setLogin_status(Integer login_status) {
		this.login_status = login_status;
	}
	
	public Integer getLogin_status() {
		return this.login_status;
	}
	public void setStatus1(Integer status1) {
		this.status1 = status1;
	}
	
	public Integer getStatus1() {
		return this.status1;
	}
	public void setStart_efficient_time(java.util.Date start_efficient_time) {
		this.start_efficient_time = start_efficient_time;
	}
	
	public java.util.Date getStart_efficient_time() {
		return this.start_efficient_time;
	}
	public void setEnd_efficient_time(java.util.Date end_efficient_time) {
		this.end_efficient_time = end_efficient_time;
	}
	
	public java.util.Date getEnd_efficient_time() {
		return this.end_efficient_time;
	}
	public void setTemp_spread(Integer temp_spread) {
		this.temp_spread = temp_spread;
	}
	
	public Integer getTemp_spread() {
		return this.temp_spread;
	}

}

