
package com.demo.xianghuan.admin.sys.controller;

import com.demo.xianghuan.admin.sys.model.SysRole;
import com.demo.xianghuan.admin.sys.service.ISysRoleService;
import com.demo.xianghuan.admin.sys.vo.SysRoleVO;
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
@RequestMapping("/admin/base/sysRoleControl")
public class SysRoleController{
	private static final Logger log = LoggerFactory.getLogger(SysRoleController.class);
	@Autowired
	private ISysRoleService sysRoleService;

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
		result.setData(HttpCode.OK, sysRoleService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param sr_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  sr_id) {
		Result result = new Result();
		try{
			SysRoleVO vo = sysRoleService.getDetail(sr_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param SysRole vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(SysRole vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			sysRoleService.insert(vo);
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
	public Result update(HttpServletRequest request,SysRole vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getSr_id()!=null){
				sysRoleService.update(vo);
			}else{
				sysRoleService.insert(vo);
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
	 * @param sr_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  sr_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			SysRole vo = sysRoleService.find(sr_id);
			//设置删除标志位
			sysRoleService.update(vo);
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
		String sr_id = request.getParameter("sr_id");
		if (StringUtils.isNotBlank(sr_id)) {
			queryParams.put("sr_id", sr_id);
		}
		//	
		String sr_name = request.getParameter("sr_name");
		if (StringUtils.isNotBlank(sr_name)) {
			queryParams.put("sr_name", sr_name);
		}
		//	
		String sr_order = request.getParameter("sr_order");
		if (StringUtils.isNotBlank(sr_order)) {
			queryParams.put("sr_order", sr_order);
		}
		//	
		String sr_pid = request.getParameter("sr_pid");
		if (StringUtils.isNotBlank(sr_pid)) {
			queryParams.put("sr_pid", sr_pid);
		}
		//	
		String sr_state = request.getParameter("sr_state");
		if (StringUtils.isNotBlank(sr_state)) {
			queryParams.put("sr_state", sr_state);
		}
		//	
		String sr_version = request.getParameter("sr_version");
		if (StringUtils.isNotBlank(sr_version)) {
			queryParams.put("sr_version", sr_version);
		}
		//	
		String sr_dr = request.getParameter("sr_dr");
		if (StringUtils.isNotBlank(sr_dr)) {
			queryParams.put("sr_dr", sr_dr);
		}
		//	
		String sr_ts = request.getParameter("sr_ts");
		if (StringUtils.isNotBlank(sr_ts)) {
			queryParams.put("sr_ts", sr_ts);
		}
		//	
		String sr_code = request.getParameter("sr_code");
		if (StringUtils.isNotBlank(sr_code)) {
			queryParams.put("sr_code", sr_code);
		}
		//	
		String sr_userid = request.getParameter("sr_userid");
		if (StringUtils.isNotBlank(sr_userid)) {
			queryParams.put("sr_userid", sr_userid);
		}
		//	
		String sr_roletype = request.getParameter("sr_roletype");
		if (StringUtils.isNotBlank(sr_roletype)) {
			queryParams.put("sr_roletype", sr_roletype);
		}
		//	
		String sr_addtime = request.getParameter("sr_addtime");
		if (StringUtils.isNotBlank(sr_addtime)) {
			queryParams.put("sr_addtime", sr_addtime);
		}
		//	
		String sr_updatetime = request.getParameter("sr_updatetime");
		if (StringUtils.isNotBlank(sr_updatetime)) {
			queryParams.put("sr_updatetime", sr_updatetime);
		}
		return queryParams;
	}
}