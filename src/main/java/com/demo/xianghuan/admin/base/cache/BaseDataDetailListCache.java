package com.demo.xianghuan.admin.base.cache;

import com.demo.xianghuan.admin.base.model.BaseData;
import com.demo.xianghuan.admin.base.service.IBaseDataService;
import com.demo.xianghuan.component.RedisDao;
import com.demo.xianghuan.component.SpringUtils;
import com.demo.xianghuan.utils.BusinessException;
import com.demo.xianghuan.utils.GlobalConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


 

//@Component
public class BaseDataDetailListCache  {

	private static final Logger logger = LoggerFactory.getLogger(BaseDataDetailValueCache.class);

	// 关键字前缀字符;
	
	//aaaa
	
	private String keyPrefix = "BaseDataDetailListCache_VO_";

	   private static final long serialVersionUID = -4397192926052141162L;

	private static BaseDataDetailListCache instance = null;

	private RedisDao redisDao = (RedisDao) SpringUtils.getBean("redisDao");
	private static Object lock = new Object();

	private BaseDataDetailListCache() {
	}

	public static BaseDataDetailListCache getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new BaseDataDetailListCache();
				}
			}
		}
		return instance;
	}

	// 添加被缓存的对象;
	public void put(String code,Object value) {
		instance.put(GlobalConstants.ORG_FAULT_VALUE,code, value);
	}
	
	public void put(String orgid,String code,Object value) {
		redisDao.setObj(this.keyPrefix + "_" + orgid + "_" + code, value);
	}

	// 删除被缓存的对象;
	public void remove(String code) {
		this.remove(GlobalConstants.ORG_FAULT_VALUE, code);
	}
	
	public void remove(String orgid,String code) {
		redisDao.del(this.keyPrefix + "_" + orgid + "_" + code);
	}

	
	//更新操作
	public void refreshUpdate(String code){
		List<BaseData> list = getDetailList(code);
		redisDao.setObj(this.keyPrefix + "_" + GlobalConstants.ORG_FAULT_VALUE + "_" + code, list);
	}
	public void refreshUpdate(String orgid,String code){
		List<BaseData> list = getDetailList(orgid,code);
		redisDao.setObj(this.keyPrefix + "_" + orgid + "_" + code, list);
	}

	private List<BaseData> getDetailList(String code) {
		return this.getDetailList(GlobalConstants.ORG_FAULT_VALUE, code);
	}
	
	private List<BaseData> getDetailList(String orgid,String code) {
		IBaseDataService baseDataService = (IBaseDataService) SpringUtils.getBean("baseDataService");
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(orgid))
			map.put("bd_org", orgid);
		map.put("bdt_code", code);
		map.put("bd_status", "" + GlobalConstants.STATUS_ON);
		map.put("bd_dr", "" + GlobalConstants.SAVE);
		List<BaseData> list = baseDataService.select(map);
		return list;
	}
	
	// 获取被缓存的对象;
	public List<BaseData> get(String code) throws BusinessException {
		return this.get(GlobalConstants.ORG_FAULT_VALUE, code);
	}
	
	// 获取被缓存的对象;
	public  List<BaseData>  get(String orgid,String code) throws BusinessException {
		List<BaseData> list = null;
		try {
			List<Object> objs = (List<Object>) redisDao.getObj(this.keyPrefix + "_" + orgid + "_" + code);
			list = ObjectToBaseData(objs);
			if (list == null || list.size() == 0) {
				throw new BusinessException("SYS_E998", "cache not find");
			}
			return list;
		} catch (Exception e) {
			// Cache中没有则从库获得数据.
			list = this.getDetailList(orgid,code);
			// 存放在Cache中 键值myKey
			if (list == null || list.size() == 0) {
				logger.error(e.getMessage(), e);
				logger.error("字典缓存列表异常：orgid：["+orgid+"] code:["+code+"]");
//				throw new BusinessException("SYS_E999", "取系统类型定义缓存出错");
			}
			redisDao.setObj(this.keyPrefix + "_" + orgid + "_" + code, list);
			return list;
		}

	}
	
	private List<BaseData> ObjectToBaseData(List<Object> objs ) {
		List<BaseData> list = new ArrayList<BaseData>();
		for(Object obj : objs) {
			list.add((BaseData)obj);
		}
		return list;
	}
}
