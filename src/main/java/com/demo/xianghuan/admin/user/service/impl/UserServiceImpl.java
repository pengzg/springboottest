package com.demo.xianghuan.admin.user.service.impl;

import com.demo.xianghuan.admin.user.cache.UserCache;
import com.demo.xianghuan.admin.user.dao.IUserDao;
import com.demo.xianghuan.admin.user.model.User;
import com.demo.xianghuan.admin.user.service.IUserService;
import com.demo.xianghuan.admin.user.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @company 社区盒子
 * @author feizhang
 * @version 1.0
 * @date 
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private IUserDao userDao;


	
	/**
	 * 插入单条记录，用id作主键，把null全替换为""
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public Integer insert(User vo) {
		return userDao.insert(vo);
	}



	@Override
	public User find(Integer id) {
		// TODO Auto-generated method stub
		return userDao.find(id);
	}



	@Override
	public List<UserVO> getList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<UserVO> listNew = new ArrayList<UserVO>();
		List<User> list = userDao.select(map);
		UserVO userVO = null;
		for (User vo:list) {
			userVO = new UserVO();
			BeanUtils.copyProperties(vo, userVO);
			listNew.add(userVO);
			
		}
		
		return listNew;
	}



	@Override
	public String update(User vo) {
		// TODO Auto-generated method stub
		String msg = "";
		User user = this.find(vo.getId());
		if (null == user) {
			msg = "用户不存在";
		} else {
			userDao.update(vo);
			UserCache.getInstance().put(vo.getId().toString(), vo);
		}
		return msg;
	}


}
