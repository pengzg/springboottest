
package com.demo.xianghuan.admin.base.controller;

import com.demo.xianghuan.admin.base.model.BaseDataType;
import com.demo.xianghuan.admin.base.service.IBaseDataTypeService;
import com.demo.xianghuan.utils.Result;
import com.demo.xianghuan.utils.HttpCode;
import com.demo.xianghuan.utils.Pager;
import com.demo.xianghuan.utils.Query;
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
@RequestMapping("/admin/base/baseDataTypeControl")
public class BaseDataTypeController{
	private static final Logger log = LoggerFactory.getLogger(BaseDataTypeController.class);
	@Autowired
	private IBaseDataTypeService baseDataTypeService;

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
		result.setData(HttpCode.OK, baseDataTypeService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param bdt_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  bdt_id) {
		Result result = new Result();
		try{
			BaseDataType vo = baseDataTypeService.find(bdt_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseDataType vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseDataType vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseDataTypeService.insert(vo);
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
	public Result update(HttpServletRequest request,BaseDataType vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBdt_id()!=null){
				baseDataTypeService.update(vo);
			}else{
				baseDataTypeService.insert(vo);
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
	 * @param bdt_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  bdt_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseDataType vo = baseDataTypeService.find(bdt_id);
			//设置删除标志位
			baseDataTypeService.update(vo);
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
		//主键id	
		String bdt_id = request.getParameter("bdt_id");
		if (StringUtils.isNotBlank(bdt_id)) {
			queryParams.put("bdt_id", bdt_id);
		}
		//字典类型编码	
		String bdt_code = request.getParameter("bdt_code");
		if (StringUtils.isNotBlank(bdt_code)) {
			queryParams.put("bdt_code", bdt_code);
		}
		//类型名称	
		String bdt_name = request.getParameter("bdt_name");
		if (StringUtils.isNotBlank(bdt_name)) {
			queryParams.put("bdt_name", bdt_name);
		}
		//排序	
		String bdt_order = request.getParameter("bdt_order");
		if (StringUtils.isNotBlank(bdt_order)) {
			queryParams.put("bdt_order", bdt_order);
		}
		//字典类型 1-系统 2-用户	
		String bdt_type = request.getParameter("bdt_type");
		if (StringUtils.isNotBlank(bdt_type)) {
			queryParams.put("bdt_type", bdt_type);
		}
		//所属运营商	
		String bdt_org = request.getParameter("bdt_org");
		if (StringUtils.isNotBlank(bdt_org)) {
			queryParams.put("bdt_org", bdt_org);
		}
		//描述	
		String bdt_des = request.getParameter("bdt_des");
		if (StringUtils.isNotBlank(bdt_des)) {
			queryParams.put("bdt_des", bdt_des);
		}
		//状态 1启用 0-禁用	
		String bdt_state = request.getParameter("bdt_state");
		if (StringUtils.isNotBlank(bdt_state)) {
			queryParams.put("bdt_state", bdt_state);
		}
		//删除标志位	
		String bdt_dr = request.getParameter("bdt_dr");
		if (StringUtils.isNotBlank(bdt_dr)) {
			queryParams.put("bdt_dr", bdt_dr);
		}
		//	
		String bdt_adduser = request.getParameter("bdt_adduser");
		if (StringUtils.isNotBlank(bdt_adduser)) {
			queryParams.put("bdt_adduser", bdt_adduser);
		}
		//	
		String bdt_adddate = request.getParameter("bdt_adddate");
		if (StringUtils.isNotBlank(bdt_adddate)) {
			queryParams.put("bdt_adddate", bdt_adddate);
		}
		//	
		String bdt_modifyuser = request.getParameter("bdt_modifyuser");
		if (StringUtils.isNotBlank(bdt_modifyuser)) {
			queryParams.put("bdt_modifyuser", bdt_modifyuser);
		}
		//	
		String bdt_modifydate = request.getParameter("bdt_modifydate");
		if (StringUtils.isNotBlank(bdt_modifydate)) {
			queryParams.put("bdt_modifydate", bdt_modifydate);
		}
		//	
		String bdt_deleteuser = request.getParameter("bdt_deleteuser");
		if (StringUtils.isNotBlank(bdt_deleteuser)) {
			queryParams.put("bdt_deleteuser", bdt_deleteuser);
		}
		//	
		String bdt_deletedate = request.getParameter("bdt_deletedate");
		if (StringUtils.isNotBlank(bdt_deletedate)) {
			queryParams.put("bdt_deletedate", bdt_deletedate);
		}
		//是否总公司	
		String bdt_isgroup = request.getParameter("bdt_isgroup");
		if (StringUtils.isNotBlank(bdt_isgroup)) {
			queryParams.put("bdt_isgroup", bdt_isgroup);
		}
		return queryParams;
	}
}