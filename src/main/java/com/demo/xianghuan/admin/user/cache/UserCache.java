package com.demo.xianghuan.admin.user.cache;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.xianghuan.admin.user.model.User;
import com.demo.xianghuan.admin.user.service.IUserService;
import com.demo.xianghuan.component.RedisDao;
import com.demo.xianghuan.component.SpringUtils;


public class UserCache  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1073046899006230462L;

	private static final Logger logger = LoggerFactory.getLogger(UserCache.class);

	// 关键字前缀字符;
	
	private String keyPrefix = "USERCACHE_$$_";

	private static UserCache instance = null;

	private static Object lock = new Object();

	private RedisDao redisDao = (RedisDao) SpringUtils.getBean("redisDao");
	
	private UserCache() {
	}

	public static UserCache getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new UserCache();
				}
			}
		}
		return instance;
	}

	//把缓存里放值
	public void put(String key,Object obj) {
		redisDao.setObj(this.keyPrefix+ key, obj);
	}

	// 删除被缓存的对象;
	
	public void remove(String code) {
		redisDao.delObj(this.keyPrefix + code);
	}


	
	
	
	// 获取被缓存的对象;
	public User get(String key) {
		IUserService userService = (IUserService) SpringUtils.getBean("userService");
		User obj = null;
		obj = (User)redisDao.getObj(this.keyPrefix+ key);
		if (null == obj) {
			obj = userService.find(Integer.valueOf(key.toString()));
			if(null != obj){
				this.put(key, obj);
			} else {
				logger.info("缓存["+this.keyPrefix + key +"]不存在");
			}
		}
		
		
		
		return obj;
	}
	
	// 获取被缓存的值;
	public String getKeyValue(String key){
		String keyValue="";
		User vo = this.get(key);
		
		if(vo == null)
			keyValue="";
		else
			keyValue = vo.getNickname();
		return keyValue;
	}
}
