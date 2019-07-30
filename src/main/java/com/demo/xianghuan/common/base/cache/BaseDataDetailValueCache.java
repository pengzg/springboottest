package com.demo.xianghuan.common.base.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.xianghuan.common.base.model.BaseData;
import com.demo.xianghuan.common.base.service.IBaseDataService;
import com.demo.xianghuan.component.RedisDao;
import com.demo.xianghuan.component.SpringUtils;
import com.demo.xianghuan.utils.BusinessException;
import com.demo.xianghuan.utils.GlobalConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//根据字典类型编码取列表信息
public class BaseDataDetailValueCache  {


	private static final Logger logger = LoggerFactory.getLogger(BaseDataDetailValueCache.class);

	// 过期时间(单位为秒);
	private int refreshPeriod = 100000;

	// 关键字前缀字符;
	private String keyPrefix = "BaseDataDetailValueCache_$$$";

	private static final long serialVersionUID = -4397192926052141162L;

	private static BaseDataDetailValueCache instance = null;
	private RedisDao redisDao = (RedisDao) SpringUtils.getBean("redisDao");

	private static Object lock = new Object();

	public static BaseDataDetailValueCache getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new BaseDataDetailValueCache();
				}
			}
		}
		return instance;
	}

	private String key;
	
	private void setKeyValue(String orgid,String datatype, String code) {
		if (StringUtils.isNotEmpty(orgid))
			key = this.keyPrefix + "_" + orgid +"_"+datatype+ "_" + code;
		else
			key = this.keyPrefix + "_" + GlobalConstants.ORG_FAULT_VALUE+"_"+datatype + "_" + code;
	}
	
	private void setKeyValue(String datatype,String code) {
		this.setKeyValue(null, code);
	}
	
	// 添加被缓存的对象;
	public void put(String dataType,String code, Object value) {
		this.setKeyValue(GlobalConstants.ORG_FAULT_VALUE,dataType,code);
		redisDao.setObj(this.key, value);
	}
	
	
	// 添加被缓存的对象;
		public void put(String orgid,String dataType,String code, Object value) {
			this.setKeyValue(orgid,dataType,code);
			redisDao.setObj(this.key, value);
		}

	// 删除被缓存的对象;
	public void remove(String dataType,String code ) {
		this.setKeyValue(dataType,code);
		redisDao.del(this.key);
	}
	
	public void remove(String orgid,String dataType,String code ) {
		this.setKeyValue(orgid,dataType,code);
		redisDao.del(this.key);
	}

	
	public String getName(String datatype, String code) {
		try {
			BaseData vo = this.get(GlobalConstants.ORG_FAULT_VALUE,datatype, code);
			if (vo == null)
				return "";
			return vo.getBd_name();

		} catch (Exception e) {
			return "";
		}
	}
	
	public String getName(String orgid,String datatype, String code) {
		try {
			BaseData vo = this.get(orgid,datatype, code);
			if (vo == null)
				return "";
			return vo.getBd_name();
		} catch (Exception e) {
			return "";
		}
	}

	// 获取被缓存的对象;
	public BaseData get(String orgid,String datatype, String code) throws BusinessException {
		this.setKeyValue(orgid,datatype,code);
		IBaseDataService baseDataService = (IBaseDataService) SpringUtils.getBean("baseDataService");
		BaseData vo = null;
		try {
			vo = (BaseData)redisDao.getObj(this.key);
			if (vo == null) {
				throw new BusinessException("SYS_E998", "cache not find");
			}
			return vo;
		} catch (Exception nre) {
			List<BaseData> list = null;
			Map<String, Object> map = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(orgid))
				map.put("bd_org", orgid);
			map.put("bdt_code", datatype);
			map.put("bd_code", code);
			list = baseDataService.select(map);
			if (list == null || list.size() == 0) {
				throw new BusinessException("SYS_E999", "取系统类型定义缓存出错");
			}
			vo = list.get(0);
			put(orgid, datatype, code, vo);
			return vo;
		}

	}
}
