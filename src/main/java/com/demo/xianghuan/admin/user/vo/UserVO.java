package com.demo.xianghuan.admin.user.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.demo.xianghuan.admin.user.cache.UserCache;
import com.demo.xianghuan.admin.user.model.User;

public class UserVO extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7150395653016865542L;

	
	private String spread_nameref;

	public String getSpread_nameref() {
		if (StringUtils.isNotBlank(getSpread())) {
				spread_nameref = UserCache.getInstance().getKeyValue(getSpread());
		}
		return spread_nameref;
	}

	public void setSpread_nameref(String spread_nameref) {
		this.spread_nameref = spread_nameref;
	}


}
