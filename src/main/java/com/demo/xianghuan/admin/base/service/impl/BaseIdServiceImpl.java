package com.demo.xianghuan.admin.base.service.impl;

import com.demo.xianghuan.admin.base.service.IBaseIdService;
import com.demo.xianghuan.admin.base.dao.IBaseIdDao;
import com.sqhz.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Transactional
@Service("baseIdService")
public class BaseIdServiceImpl implements IBaseIdService {

	@Autowired
	protected IBaseIdDao baseIdDao;

	public String createId(String orgid) {
		return this.createId(orgid, 1)[0];
	}

	public String createId(String tableName, String orgidname, String orgidvalue) {
		Map map = new HashMap();
		map.put("table_name", tableName);
		map.put("org_id_name", orgidname);
		map.put("org_id_value", orgidvalue);
		int count = baseIdDao.createId(map);
		String id = orgidvalue + String.format("%0" + 5 + "d", count + 1);
		return id;
	}

	public String[] createId(String orgid, int size) {
		if (!StringUtils.isNotBlank(orgid))
			orgid = "999999";
		String ts = DateUtil.getCurrentDateToString5();
		String ts1 = ts.substring(2, ts.length());

		Random random = new Random();
		Object[] values = new Object[size];
		String[] ids = new String[size];
		HashSet<Integer> hashSet = new HashSet<Integer>();

		// 生成随机数字并存入HashSet
		while (hashSet.size() < values.length) {
			hashSet.add(random.nextInt(900000) + 1);
		}
		values = hashSet.toArray();

		for (int i = 0; i < size; i++) {
			ids[i] = orgid + ts1 + String.format("%0" + 6 + "d", values[i]);
		}

		return ids;
	}

	public String createId(String tableName, String idname, String orgidname, String orgidvalue) {
		String id = "";
		Map map = new HashMap();
		map.put("table_name", tableName);
		map.put("id_name", idname);
		map.put("org_id_name", orgidname);
		map.put("org_id_value", orgidvalue);
		String maxid = baseIdDao.getMaxId(map);
		if (maxid == null) {
			// 当获取值为空时
			id = orgidvalue + String.format("%0" + 5 + "d", 1);
		} else {
			BigDecimal bd = new BigDecimal(maxid);
			id = bd.add(new BigDecimal("1")).toString();
			// id = orgidvalue + String.format("%0" + 5 + "d", count + 1);
		}
		return id;
	}

	//
	public Integer getRecordCount(String sql) {
		Map map = new HashMap();
		map.put("sql", sql);
		return baseIdDao.getRecordCount(map);
	}

	public List getObjectList(@Param(value = "sql") String sql) {
		Map map = new HashMap();
		map.put("sql", sql);
		return baseIdDao.getObjectList(map);
	}

}
