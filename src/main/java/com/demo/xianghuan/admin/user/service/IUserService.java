package com.demo.xianghuan.admin.user.service;

import java.util.List;
import java.util.Map;

import com.demo.xianghuan.admin.user.model.User;
import com.demo.xianghuan.admin.user.vo.UserVO;
/**
 * @company 社区盒子
 * @author feizhang
 * @version 1.0
 * @date 
 */


public interface IUserService {
	

	public Integer insert(User vo);

	public User find(Integer id);

	public List<UserVO> getList(Map<String, Object> map);

	public String update(User vo);


}
