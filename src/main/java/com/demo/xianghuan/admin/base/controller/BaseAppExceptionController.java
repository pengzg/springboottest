
package com.demo.xianghuan.admin.base.controller;

import com.demo.xianghuan.admin.base.model.BaseAppException;
import com.demo.xianghuan.admin.base.service.IBaseAppExceptionService;
import com.demo.xianghuan.utils.HttpCode;
import com.demo.xianghuan.utils.Pager;
import com.demo.xianghuan.utils.Query;
import com.demo.xianghuan.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/base/baseAppExceptionControl")
public class BaseAppExceptionController{
	private static final Logger log = LoggerFactory.getLogger(BaseAppExceptionController.class);
	@Autowired
	private IBaseAppExceptionService baseAppExceptionService;

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
		result.setData(HttpCode.OK, baseAppExceptionService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param bae_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  bae_id) {
		Result result = new Result();
		try{
			BaseAppException vo = baseAppExceptionService.find(bae_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseAppException vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseAppException vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseAppExceptionService.insert(vo);
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
	public Result update(HttpServletRequest request,BaseAppException vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBae_id()!=null){
				baseAppExceptionService.update(vo);
			}else{
				baseAppExceptionService.insert(vo);
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
	 * @param bae_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  bae_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseAppException vo = baseAppExceptionService.find(bae_id);
			//设置删除标志位
			baseAppExceptionService.update(vo);
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
		String bae_id = request.getParameter("bae_id");
		if (StringUtils.isNotBlank(bae_id)) {
			queryParams.put("bae_id", bae_id);
		}
		//公司	
		String bae_orgid = request.getParameter("bae_orgid");
		if (StringUtils.isNotBlank(bae_orgid)) {
			queryParams.put("bae_orgid", bae_orgid);
		}
		//设备名	
		String bae_device_name = request.getParameter("bae_device_name");
		if (StringUtils.isNotBlank(bae_device_name)) {
			queryParams.put("bae_device_name", bae_device_name);
		}
		//1.盒子安卓 2盒子ios 3小店安卓 4 小店ios	
		String bae_device_type = request.getParameter("bae_device_type");
		if (StringUtils.isNotBlank(bae_device_type)) {
			queryParams.put("bae_device_type", bae_device_type);
		}
		//设备号	
		String bae_device_code = request.getParameter("bae_device_code");
		if (StringUtils.isNotBlank(bae_device_code)) {
			queryParams.put("bae_device_code", bae_device_code);
		}
		//系统版本	
		String bae_sys_version = request.getParameter("bae_sys_version");
		if (StringUtils.isNotBlank(bae_sys_version)) {
			queryParams.put("bae_sys_version", bae_sys_version);
		}
		//页面	
		String bae_page = request.getParameter("bae_page");
		if (StringUtils.isNotBlank(bae_page)) {
			queryParams.put("bae_page", bae_page);
		}
		//异常内容	
		String bae_msg = request.getParameter("bae_msg");
		if (StringUtils.isNotBlank(bae_msg)) {
			queryParams.put("bae_msg", bae_msg);
		}
		//用户id	
		String bae_userid = request.getParameter("bae_userid");
		if (StringUtils.isNotBlank(bae_userid)) {
			queryParams.put("bae_userid", bae_userid);
		}
		//添加时间	
		String bae_addtime = request.getParameter("bae_addtime");
		if (StringUtils.isNotBlank(bae_addtime)) {
			queryParams.put("bae_addtime", bae_addtime);
		}
		return queryParams;
	}
}