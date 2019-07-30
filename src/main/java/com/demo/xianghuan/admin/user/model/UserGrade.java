package com.demo.xianghuan.admin.user.model;

import java.math.BigDecimal;

public class UserGrade implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private Integer ug_id;
	//会员等级名称	
	private String ug_title;
	//优惠比例	
	private BigDecimal ug_scale;
	//消费金额	
	private BigDecimal ug_amount;
	//会员图标	
	private String ug_icon;
	//会员描述	
	private String ug_desc;
	//状态 1-启用 2-禁用	
	private Integer ug_status;
	//删除标志位 1	
	private Integer ug_dr;
	//创建时间	
	private String ug_addtime;
	//创建人	
	private Long ug_adduser;
	//更新时间	
	private String ug_updatetime;
	//会员成长值最低值	
	private Integer ug_growth_low;
	//会员成长值最高值	
	private Integer ug_growth_top;
	//会员递减数值	
	private Integer ug_decrease;
	//小于等于50	
	private BigDecimal ug_discount_little;
	//50元-100元 折扣	
	private BigDecimal ug_discount_middle;
	//大于等于100元	
	private BigDecimal ug_discount_max;
	//columns END

	public void setUg_id(Integer ug_id) {
		this.ug_id = ug_id;
	}
	
	public Integer getUg_id() {
		return this.ug_id;
	}
	public void setUg_title(String ug_title) {
		this.ug_title = ug_title;
	}
	
	public String getUg_title() {
		return this.ug_title;
	}
	public void setUg_scale(BigDecimal ug_scale) {
		this.ug_scale = ug_scale;
	}
	
	public BigDecimal getUg_scale() {
		return this.ug_scale;
	}
	public void setUg_amount(BigDecimal ug_amount) {
		this.ug_amount = ug_amount;
	}
	
	public BigDecimal getUg_amount() {
		return this.ug_amount;
	}
	public void setUg_icon(String ug_icon) {
		this.ug_icon = ug_icon;
	}
	
	public String getUg_icon() {
		return this.ug_icon;
	}
	public void setUg_desc(String ug_desc) {
		this.ug_desc = ug_desc;
	}
	
	public String getUg_desc() {
		return this.ug_desc;
	}
	public void setUg_status(Integer ug_status) {
		this.ug_status = ug_status;
	}
	
	public Integer getUg_status() {
		return this.ug_status;
	}
	public void setUg_dr(Integer ug_dr) {
		this.ug_dr = ug_dr;
	}
	
	public Integer getUg_dr() {
		return this.ug_dr;
	}
	public void setUg_addtime(String ug_addtime) {
		this.ug_addtime = ug_addtime;
	}
	
	public String getUg_addtime() {
		return this.ug_addtime;
	}
	public void setUg_adduser(Long ug_adduser) {
		this.ug_adduser = ug_adduser;
	}
	
	public Long getUg_adduser() {
		return this.ug_adduser;
	}
	public void setUg_updatetime(String ug_updatetime) {
		this.ug_updatetime = ug_updatetime;
	}
	
	public String getUg_updatetime() {
		return this.ug_updatetime;
	}
	public void setUg_growth_low(Integer ug_growth_low) {
		this.ug_growth_low = ug_growth_low;
	}
	
	public Integer getUg_growth_low() {
		return this.ug_growth_low;
	}
	public void setUg_growth_top(Integer ug_growth_top) {
		this.ug_growth_top = ug_growth_top;
	}
	
	public Integer getUg_growth_top() {
		return this.ug_growth_top;
	}
	public void setUg_decrease(Integer ug_decrease) {
		this.ug_decrease = ug_decrease;
	}
	
	public Integer getUg_decrease() {
		return this.ug_decrease;
	}
	public void setUg_discount_little(BigDecimal ug_discount_little) {
		this.ug_discount_little = ug_discount_little;
	}
	
	public BigDecimal getUg_discount_little() {
		return this.ug_discount_little;
	}
	public void setUg_discount_middle(BigDecimal ug_discount_middle) {
		this.ug_discount_middle = ug_discount_middle;
	}
	
	public BigDecimal getUg_discount_middle() {
		return this.ug_discount_middle;
	}
	public void setUg_discount_max(BigDecimal ug_discount_max) {
		this.ug_discount_max = ug_discount_max;
	}
	
	public BigDecimal getUg_discount_max() {
		return this.ug_discount_max;
	}

}

