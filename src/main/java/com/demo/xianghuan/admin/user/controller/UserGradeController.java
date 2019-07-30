
package com.demo.xianghuan.admin.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.demo.xianghuan.admin.user.vo.UserGradeVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.xianghuan.admin.user.model.UserGrade;
import com.demo.xianghuan.admin.user.service.IUserGradeService;

/**
 * @company 社区盒子
 * @author feizhang
 * @version 1.0
 * @date 
 */

@Controller
@RequestMapping("/base/userGradeControl")
public class UserGradeController{
	private final static Logger logger = LoggerFactory.getLogger(UserGradeController.class);

	@Autowired
	private IUserGradeService userGradeService;

	/**
	 * 增加一条记录
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(UserGrade vo) {
		String id = "";
		try {
			logger.info("日志成功了");
			id = userGradeService.insert(vo)+"";
			// redisDao.set("thisisone", "test");
		} catch (Exception e) {
			e.printStackTrace();
			id = ("操作失败！"+e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return id;
	}

	/**
	 * 增加一条记录
	 * @return JSON
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public List<UserGradeVO> getList(UserGrade vo) {
		List<UserGradeVO> list = new ArrayList<UserGradeVO>();
		UserGradeVO uVO = new UserGradeVO();
		list.add(uVO);
		try {
			logger.info("日志成功了");

			// redisDao.set("thisisone", "test");
		} catch (Exception e) {
			e.printStackTrace();

			logger.error(e.getMessage(), e);
		}
		return list;
	}

	public Map<?, ?> getQueryCondition(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> queryParams = new HashMap<String, Object>();
		//	
		String ug_id = request.getParameter("ug_id");
		if (StringUtils.isNotBlank(ug_id)) {
			queryParams.put("ug_id", ug_id);
		}
		//会员等级名称	
		String ug_title = request.getParameter("ug_title");
		if (StringUtils.isNotBlank(ug_title)) {
			queryParams.put("ug_title", ug_title);
		}
		//优惠比例	
		String ug_scale = request.getParameter("ug_scale");
		if (StringUtils.isNotBlank(ug_scale)) {
			queryParams.put("ug_scale", ug_scale);
		}
		//消费金额	
		String ug_amount = request.getParameter("ug_amount");
		if (StringUtils.isNotBlank(ug_amount)) {
			queryParams.put("ug_amount", ug_amount);
		}
		//会员图标	
		String ug_icon = request.getParameter("ug_icon");
		if (StringUtils.isNotBlank(ug_icon)) {
			queryParams.put("ug_icon", ug_icon);
		}
		//会员描述	
		String ug_desc = request.getParameter("ug_desc");
		if (StringUtils.isNotBlank(ug_desc)) {
			queryParams.put("ug_desc", ug_desc);
		}
		//状态 1-启用 2-禁用	
		String ug_status = request.getParameter("ug_status");
		if (StringUtils.isNotBlank(ug_status)) {
			queryParams.put("ug_status", ug_status);
		}
		//删除标志位 1	
		String ug_dr = request.getParameter("ug_dr");
		if (StringUtils.isNotBlank(ug_dr)) {
			queryParams.put("ug_dr", ug_dr);
		}
		//创建时间	
		String ug_addtime = request.getParameter("ug_addtime");
		if (StringUtils.isNotBlank(ug_addtime)) {
			queryParams.put("ug_addtime", ug_addtime);
		}
		//创建人	
		String ug_adduser = request.getParameter("ug_adduser");
		if (StringUtils.isNotBlank(ug_adduser)) {
			queryParams.put("ug_adduser", ug_adduser);
		}
		//更新时间	
		String ug_updatetime = request.getParameter("ug_updatetime");
		if (StringUtils.isNotBlank(ug_updatetime)) {
			queryParams.put("ug_updatetime", ug_updatetime);
		}
		//会员成长值最低值	
		String ug_growth_low = request.getParameter("ug_growth_low");
		if (StringUtils.isNotBlank(ug_growth_low)) {
			queryParams.put("ug_growth_low", ug_growth_low);
		}
		//会员成长值最高值	
		String ug_growth_top = request.getParameter("ug_growth_top");
		if (StringUtils.isNotBlank(ug_growth_top)) {
			queryParams.put("ug_growth_top", ug_growth_top);
		}
		//会员递减数值	
		String ug_decrease = request.getParameter("ug_decrease");
		if (StringUtils.isNotBlank(ug_decrease)) {
			queryParams.put("ug_decrease", ug_decrease);
		}
		//小于等于50	
		String ug_discount_little = request.getParameter("ug_discount_little");
		if (StringUtils.isNotBlank(ug_discount_little)) {
			queryParams.put("ug_discount_little", ug_discount_little);
		}
		//50元-100元 折扣	
		String ug_discount_middle = request.getParameter("ug_discount_middle");
		if (StringUtils.isNotBlank(ug_discount_middle)) {
			queryParams.put("ug_discount_middle", ug_discount_middle);
		}
		//大于等于100元	
		String ug_discount_max = request.getParameter("ug_discount_max");
		if (StringUtils.isNotBlank(ug_discount_max)) {
			queryParams.put("ug_discount_max", ug_discount_max);
		}
		return queryParams;
	}
}