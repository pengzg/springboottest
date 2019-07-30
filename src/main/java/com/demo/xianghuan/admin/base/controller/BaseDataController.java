
package com.demo.xianghuan.admin.base.controller;

import com.demo.xianghuan.admin.base.model.BaseData;
import com.demo.xianghuan.admin.base.service.IBaseDataService;
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
@RequestMapping("/admin/base/baseDataControl")
public class BaseDataController{
	private static final Logger log = LoggerFactory.getLogger(BaseDataController.class);
	@Autowired
	private IBaseDataService baseDataService;

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
		result.setData(HttpCode.OK, baseDataService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param bd_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  bd_id) {
		Result result = new Result();
		try{
			BaseData vo = baseDataService.find(bd_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseData vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseData vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseDataService.insert(vo);
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
	public Result update(HttpServletRequest request,BaseData vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBd_id()!=null){
				baseDataService.update(vo);
			}else{
				baseDataService.insert(vo);
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
	 * @param bd_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  bd_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseData vo = baseDataService.find(bd_id);
			//设置删除标志位
			baseDataService.update(vo);
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
		//	
		String bd_id = request.getParameter("bd_id");
		if (StringUtils.isNotBlank(bd_id)) {
			queryParams.put("bd_id", bd_id);
		}
		//字典编码	
		String bd_code = request.getParameter("bd_code");
		if (StringUtils.isNotBlank(bd_code)) {
			queryParams.put("bd_code", bd_code);
		}
		//名称	
		String bd_name = request.getParameter("bd_name");
		if (StringUtils.isNotBlank(bd_name)) {
			queryParams.put("bd_name", bd_name);
		}
		//排序	
		String bd_order = request.getParameter("bd_order");
		if (StringUtils.isNotBlank(bd_order)) {
			queryParams.put("bd_order", bd_order);
		}
		//父级id	
		String bd_pid = request.getParameter("bd_pid");
		if (StringUtils.isNotBlank(bd_pid)) {
			queryParams.put("bd_pid", bd_pid);
		}
		//字典类型id	
		String bd_datatypeid = request.getParameter("bd_datatypeid");
		if (StringUtils.isNotBlank(bd_datatypeid)) {
			queryParams.put("bd_datatypeid", bd_datatypeid);
		}
		//所属运营商	
		String bd_org = request.getParameter("bd_org");
		if (StringUtils.isNotBlank(bd_org)) {
			queryParams.put("bd_org", bd_org);
		}
		//描述	
		String bd_des = request.getParameter("bd_des");
		if (StringUtils.isNotBlank(bd_des)) {
			queryParams.put("bd_des", bd_des);
		}
		//状态 1启用 0-禁用	
		String bd_state = request.getParameter("bd_state");
		if (StringUtils.isNotBlank(bd_state)) {
			queryParams.put("bd_state", bd_state);
		}
		//删除标识位	
		String bd_dr = request.getParameter("bd_dr");
		if (StringUtils.isNotBlank(bd_dr)) {
			queryParams.put("bd_dr", bd_dr);
		}
		//	
		String bd_adduser = request.getParameter("bd_adduser");
		if (StringUtils.isNotBlank(bd_adduser)) {
			queryParams.put("bd_adduser", bd_adduser);
		}
		//	
		String bd_adddate = request.getParameter("bd_adddate");
		if (StringUtils.isNotBlank(bd_adddate)) {
			queryParams.put("bd_adddate", bd_adddate);
		}
		//	
		String bd_modifyuser = request.getParameter("bd_modifyuser");
		if (StringUtils.isNotBlank(bd_modifyuser)) {
			queryParams.put("bd_modifyuser", bd_modifyuser);
		}
		//	
		String bd_modifydate = request.getParameter("bd_modifydate");
		if (StringUtils.isNotBlank(bd_modifydate)) {
			queryParams.put("bd_modifydate", bd_modifydate);
		}
		//	
		String bd_deleteuser = request.getParameter("bd_deleteuser");
		if (StringUtils.isNotBlank(bd_deleteuser)) {
			queryParams.put("bd_deleteuser", bd_deleteuser);
		}
		//	
		String bd_deletedate = request.getParameter("bd_deletedate");
		if (StringUtils.isNotBlank(bd_deletedate)) {
			queryParams.put("bd_deletedate", bd_deletedate);
		}
		return queryParams;
	}
}