package com.demo.xianghuan.common.base.service;

import java.util.List;

public interface IBaseIdService {

	public String createId(String tableName, String orgidname, String orgidvalue);
	
	//获取最大主键
	public String createId(String tableName, String idname, String orgidname, String orgidvalue);

	public String createId(String orgid);

	// 批量获取主键
	public String[] createId(String orgid, int size);
	
	//查询记录条数
	public Integer getRecordCount(String sql);
	
	//查询数据对象
	public List getObjectList(String sql);
}
