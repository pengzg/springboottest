package com.demo.xianghuan.common.base.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface IBaseIdDao {
	
	public int createId(Map map);
	//获取最大ID
	public String getMaxId(Map map);
	
	
	//查询记录条数
	public Integer getRecordCount(Map map);
	
	//查询数据对象
	public List<Map<String, Object>> getObjectList(Map map);
	
}
