
package com.demo.xianghuan.admin.base.controller;

import com.demo.xianghuan.admin.base.model.BaseParameter;
import com.demo.xianghuan.admin.base.service.IBaseParameterService;
import com.sqhz.common.result.Result;
import com.sqhz.web.model.HttpCode;
import com.sqhz.web.model.Pager;
import com.sqhz.web.model.Query;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/base/baseParameterControl")
public class BaseParameterController{
	private static final Logger log = LoggerFactory.getLogger(BaseParameterController.class);
	@Autowired
	private IBaseParameterService baseParameterService;

	/**
	 * 获取数据表格
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Result dataGrid(HttpServletRequest request, Pager pager) {
		Query query = new Query();
		query.setPager(pager);
		query.setQueryParams((Map<String, Object>) getQueryCondition(request));
		Result result = new Result();
		result.setData(HttpCode.OK, baseParameterService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param bp_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  bp_id) {
		Result result = new Result();
		try{
			BaseParameter vo = baseParameterService.find(bp_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseParameter vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseParameter vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseParameterService.insert(vo);
			result.setData(HttpCode.OK, null, "添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, "添加失败！");
		}
		return result;
	}

	/**
	 * 修改一条记录
	 * @param vo
	 * @return JSON
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(HttpServletRequest request,BaseParameter vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBp_id()!=null){
				baseParameterService.update(vo);
			}else{
				baseParameterService.insert(vo);
			}
			result.setData(HttpCode.OK, null, "编辑成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, "编辑失败！");
		}
		return result;
	}

	
	/**
	 * 从页面的表单获取一条记录id，并删除多条记录
	 * @param bp_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  bp_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseParameter vo = baseParameterService.find(bp_id);
			//设置删除标志位
			baseParameterService.update(vo);
			result.setData(HttpCode.OK, null, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, "删除失败！");
			log.error(e.getMessage(), e);
		}
		return result;
	}


	public Map<String, Object> getQueryCondition(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> queryParams = new HashMap<String, Object>();
		//主键	
		String bp_id = request.getParameter("bp_id");
		if (StringUtils.isNotBlank(bp_id)) {
			queryParams.put("bp_id", bp_id);
		}
		//键	
		String bp_key = request.getParameter("bp_key");
		if (StringUtils.isNotBlank(bp_key)) {
			queryParams.put("bp_key", bp_key);
		}
		//值	
		String bp_value = request.getParameter("bp_value");
		if (StringUtils.isNotBlank(bp_value)) {
			queryParams.put("bp_value", bp_value);
		}
		//备注	
		String bp_remark = request.getParameter("bp_remark");
		if (StringUtils.isNotBlank(bp_remark)) {
			queryParams.put("bp_remark", bp_remark);
		}
		//版本	
		String bp_version = request.getParameter("bp_version");
		if (StringUtils.isNotBlank(bp_version)) {
			queryParams.put("bp_version", bp_version);
		}
		//新增人	
		String bp_adduser = request.getParameter("bp_adduser");
		if (StringUtils.isNotBlank(bp_adduser)) {
			queryParams.put("bp_adduser", bp_adduser);
		}
		//修改人	
		String bp_updateuser = request.getParameter("bp_updateuser");
		if (StringUtils.isNotBlank(bp_updateuser)) {
			queryParams.put("bp_updateuser", bp_updateuser);
		}
		//状态	
		String bp_state = request.getParameter("bp_state");
		if (StringUtils.isNotBlank(bp_state)) {
			queryParams.put("bp_state", bp_state);
		}
		//删除标志位	
		String bp_dr = request.getParameter("bp_dr");
		if (StringUtils.isNotBlank(bp_dr)) {
			queryParams.put("bp_dr", bp_dr);
		}
		//新增时间	
		String bp_addtime = request.getParameter("bp_addtime");
		if (StringUtils.isNotBlank(bp_addtime)) {
			queryParams.put("bp_addtime", bp_addtime);
		}
		//修改时间	
		String bp_updatetime = request.getParameter("bp_updatetime");
		if (StringUtils.isNotBlank(bp_updatetime)) {
			queryParams.put("bp_updatetime", bp_updatetime);
		}
		//	
		String bp_level = request.getParameter("bp_level");
		if (StringUtils.isNotBlank(bp_level)) {
			queryParams.put("bp_level", bp_level);
		}
		return queryParams;
	}
}