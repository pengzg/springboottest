
package com.demo.xianghuan.admin.base.controller;

import com.demo.xianghuan.admin.base.model.BaseAppVersion;
import com.demo.xianghuan.admin.base.service.IBaseAppVersionService;
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
@RequestMapping("/admin/base/baseAppVersionControl")
public class BaseAppVersionController{
	private static final Logger log = LoggerFactory.getLogger(BaseAppVersionController.class);
	@Autowired
	private IBaseAppVersionService baseAppVersionService;

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
		result.setData(HttpCode.OK, baseAppVersionService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param bv_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  bv_id) {
		Result result = new Result();
		try{
			BaseAppVersion vo = baseAppVersionService.find(bv_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseAppVersion vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseAppVersion vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseAppVersionService.insert(vo);
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
	public Result update(HttpServletRequest request,BaseAppVersion vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBv_id()!=null){
				baseAppVersionService.update(vo);
			}else{
				baseAppVersionService.insert(vo);
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
	 * @param bv_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  bv_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseAppVersion vo = baseAppVersionService.find(bv_id);
			//设置删除标志位
			baseAppVersionService.update(vo);
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
		//主键ID	
		String bv_id = request.getParameter("bv_id");
		if (StringUtils.isNotBlank(bv_id)) {
			queryParams.put("bv_id", bv_id);
		}
		//APP类型 1-android 2-ios	
		String bv_app_type = request.getParameter("bv_app_type");
		if (StringUtils.isNotBlank(bv_app_type)) {
			queryParams.put("bv_app_type", bv_app_type);
		}
		//版本号	
		String bv_version1 = request.getParameter("bv_version1");
		if (StringUtils.isNotBlank(bv_version1)) {
			queryParams.put("bv_version1", bv_version1);
		}
		//下载地址	
		String bv_down_url = request.getParameter("bv_down_url");
		if (StringUtils.isNotBlank(bv_down_url)) {
			queryParams.put("bv_down_url", bv_down_url);
		}
		//更新内容	
		String bv_desc = request.getParameter("bv_desc");
		if (StringUtils.isNotBlank(bv_desc)) {
			queryParams.put("bv_desc", bv_desc);
		}
		//状态 1-启用 2-禁用	
		String bv_state = request.getParameter("bv_state");
		if (StringUtils.isNotBlank(bv_state)) {
			queryParams.put("bv_state", bv_state);
		}
		//删除标志位 	
		String bv_dr = request.getParameter("bv_dr");
		if (StringUtils.isNotBlank(bv_dr)) {
			queryParams.put("bv_dr", bv_dr);
		}
		//	
		String bv_addtime = request.getParameter("bv_addtime");
		if (StringUtils.isNotBlank(bv_addtime)) {
			queryParams.put("bv_addtime", bv_addtime);
		}
		//	
		String bv_adduser = request.getParameter("bv_adduser");
		if (StringUtils.isNotBlank(bv_adduser)) {
			queryParams.put("bv_adduser", bv_adduser);
		}
		//否是强制升级 1-强制 2-不强制	
		String bv_upgrade = request.getParameter("bv_upgrade");
		if (StringUtils.isNotBlank(bv_upgrade)) {
			queryParams.put("bv_upgrade", bv_upgrade);
		}
		//1app业务员端 2 小店端	
		String bv_source = request.getParameter("bv_source");
		if (StringUtils.isNotBlank(bv_source)) {
			queryParams.put("bv_source", bv_source);
		}
		//	
		String bv_version_name = request.getParameter("bv_version_name");
		if (StringUtils.isNotBlank(bv_version_name)) {
			queryParams.put("bv_version_name", bv_version_name);
		}
		return queryParams;
	}
}