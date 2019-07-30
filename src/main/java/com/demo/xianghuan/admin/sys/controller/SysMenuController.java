
package com.demo.xianghuan.admin.sys.controller;

import com.demo.xianghuan.admin.sys.model.SysMenu;
import com.demo.xianghuan.admin.sys.service.ISysMenuService;
import com.demo.xianghuan.admin.sys.vo.SysMenuVO;
import com.demo.xianghuan.utils.*;
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
@RequestMapping("/admin/base/sysMenuControl")
public class SysMenuController{
	private static final Logger log = LoggerFactory.getLogger(SysMenuController.class);
	@Autowired
	private ISysMenuService sysMenuService;

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
		result.setData(HttpCode.OK, sysMenuService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param sm_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  sm_id) {
		Result result = new Result();
		try{
			SysMenuVO vo = sysMenuService.getDetail(sm_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param SysMenu vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(SysMenu vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			sysMenuService.insert(vo);
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
	public Result update(HttpServletRequest request,SysMenu vo) {
		Result result = new Result();
		try {

			sysMenuService.updateOrInsert(vo);
			result.setData(HttpCode.OK, null, "操作成功！");
		}catch (BusinessException e1) {
			e1.printStackTrace();
			log.error(e1.getMessage(), e1);
			result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, e1.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, "操作失败！");
		}
		return result;
	}

	
	/**
	 * 从页面的表单获取一条记录id，并删除多条记录
	 * @param sm_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  sm_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			SysMenu vo = sysMenuService.find(sm_id);
			//设置删除标志位
			sysMenuService.update(vo);
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
		String sm_id = request.getParameter("sm_id");
		if (StringUtils.isNotBlank(sm_id)) {
			queryParams.put("sm_id", sm_id);
		}
		//	
		String sm_name = request.getParameter("sm_name");
		if (StringUtils.isNotBlank(sm_name)) {
			queryParams.put("sm_name", sm_name);
		}
		//	
		String sm_url = request.getParameter("sm_url");
		if (StringUtils.isNotBlank(sm_url)) {
			queryParams.put("sm_url", sm_url);
		}
		//	
		String sm_pid = request.getParameter("sm_pid");
		if (StringUtils.isNotBlank(sm_pid)) {
			queryParams.put("sm_pid", sm_pid);
		}
		//	
		String sm_iconcls = request.getParameter("sm_iconcls");
		if (StringUtils.isNotBlank(sm_iconcls)) {
			queryParams.put("sm_iconcls", sm_iconcls);
		}
		//	
		String sm_descript = request.getParameter("sm_descript");
		if (StringUtils.isNotBlank(sm_descript)) {
			queryParams.put("sm_descript", sm_descript);
		}
		//	
		String sm_typeid = request.getParameter("sm_typeid");
		if (StringUtils.isNotBlank(sm_typeid)) {
			queryParams.put("sm_typeid", sm_typeid);
		}
		//	
		String sm_seq = request.getParameter("sm_seq");
		if (StringUtils.isNotBlank(sm_seq)) {
			queryParams.put("sm_seq", sm_seq);
		}
		//	
		String sm_target = request.getParameter("sm_target");
		if (StringUtils.isNotBlank(sm_target)) {
			queryParams.put("sm_target", sm_target);
		}
		//	
		String sm_systemid = request.getParameter("sm_systemid");
		if (StringUtils.isNotBlank(sm_systemid)) {
			queryParams.put("sm_systemid", sm_systemid);
		}
		//	
		String sm_state = request.getParameter("sm_state");
		if (StringUtils.isNotBlank(sm_state)) {
			queryParams.put("sm_state", sm_state);
		}
		//	
		String sm_ts = request.getParameter("sm_ts");
		if (StringUtils.isNotBlank(sm_ts)) {
			queryParams.put("sm_ts", sm_ts);
		}
		//	
		String sm_dr = request.getParameter("sm_dr");
		if (StringUtils.isNotBlank(sm_dr)) {
			queryParams.put("sm_dr", sm_dr);
		}
		//	
		String sm_adduser = request.getParameter("sm_adduser");
		if (StringUtils.isNotBlank(sm_adduser)) {
			queryParams.put("sm_adduser", sm_adduser);
		}
		//	
		String sm_adddate = request.getParameter("sm_adddate");
		if (StringUtils.isNotBlank(sm_adddate)) {
			queryParams.put("sm_adddate", sm_adddate);
		}
		//	
		String sm_modifyuser = request.getParameter("sm_modifyuser");
		if (StringUtils.isNotBlank(sm_modifyuser)) {
			queryParams.put("sm_modifyuser", sm_modifyuser);
		}
		//	
		String sm_modifydate = request.getParameter("sm_modifydate");
		if (StringUtils.isNotBlank(sm_modifydate)) {
			queryParams.put("sm_modifydate", sm_modifydate);
		}
		//	
		String sm_deleteuser = request.getParameter("sm_deleteuser");
		if (StringUtils.isNotBlank(sm_deleteuser)) {
			queryParams.put("sm_deleteuser", sm_deleteuser);
		}
		//	
		String sm_deletedate = request.getParameter("sm_deletedate");
		if (StringUtils.isNotBlank(sm_deletedate)) {
			queryParams.put("sm_deletedate", sm_deletedate);
		}
		//	
		String sm_version = request.getParameter("sm_version");
		if (StringUtils.isNotBlank(sm_version)) {
			queryParams.put("sm_version", sm_version);
		}
		//菜单级别	
		String sm_level = request.getParameter("sm_level");
		if (StringUtils.isNotBlank(sm_level)) {
			queryParams.put("sm_level", sm_level);
		}
		return queryParams;
	}
}