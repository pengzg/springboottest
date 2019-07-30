
package com.demo.xianghuan.admin.user.controller;

import com.demo.xianghuan.admin.user.model.User;
import com.demo.xianghuan.admin.user.service.IUserService;
import com.demo.xianghuan.admin.user.vo.UserVO;
import com.demo.xianghuan.component.RedisDao;
import com.demo.xianghuan.utils.RepBase;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @company 社区盒子
 * @author feizhang
 * @version 1.0
 * @date 
 */

@RestController
@RequestMapping("/base/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUserService userService;

	@Autowired
	private RedisDao redisDao;



	/**
	 * 增加一条记录
	 * @param User vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(User vo) {
		String id = "";
		try {
			id = userService.insert(vo)+"";
			redisDao.del("thisisone");
		} catch (Exception e) {
			e.printStackTrace();
			id = ("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return id;
	}

	/**
	 * 增加一条记录
	 * @param User vo
	 * @return JSON
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public User getDetail(Integer id) {
		User vo= new User();
		
		try {
			if (StringUtils.isNotBlank(id+"")) {
				vo = userService.find(id);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setAvatar("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return vo;
	}

	/**
	 * 增加一条记录
	 * @param User vo
	 * @return JSON
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public RepBase getList(Integer id) {
		RepBase repBase = new RepBase();
		List<UserVO> list= new ArrayList<UserVO>();
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			list = userService.getList(map);
			repBase.setRepData(list);
			repBase.setRepCode("00");
			repBase.setRepMsg("成功");
		} catch (Exception e) {
			e.printStackTrace();
			
			log.error(e.getMessage(), e);
		}
		return repBase;
	}
	
	/**
	 * 增加一条记录
	 * @param User vo
	 * @return JSON
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(User vo) {
		String msg = "成功";
		try {
			msg = userService.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
			msg = ("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return msg;
	}

	/**
	 * 发送信息
	 * @param User vo
	 * @return JSON
	 */
	@RequestMapping("/sendMsg")
	@ResponseBody
	public String sendMsg(String msg) {
		try {
			//amqpSender.psSend(msg);
		} catch (Exception e) {
			e.printStackTrace();
			msg = ("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return msg;
	}

		public Map<?, ?> getQueryCondition(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> queryParams = new HashMap<String, Object>();


		return queryParams;
	}

}