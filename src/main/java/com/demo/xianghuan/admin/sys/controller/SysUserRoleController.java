
package com.demo.xianghuan.admin.sys.controller;

import com.demo.xianghuan.admin.sys.model.SysUserRole;
import com.demo.xianghuan.admin.sys.service.ISysUserRoleService;
import com.demo.xianghuan.admin.sys.vo.SysUserRoleVO;
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
@RequestMapping("/admin/base/sysUserRoleControl")
public class SysUserRoleController{
	private static final Logger log = LoggerFactory.getLogger(SysUserRoleController.class);
	@Autowired
	private ISysUserRoleService sysUserRoleService;

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
		result.setData(HttpCode.OK, sysUserRoleService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param sur_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  sur_id) {
		Result result = new Result();
		try{
			SysUserRoleVO vo = sysUserRoleService.getDetail(sur_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param SysUserRole vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(SysUserRole vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			sysUserRoleService.insert(vo);
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
	public Result update(HttpServletRequest request,SysUserRole vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getSur_id()!=null){
				sysUserRoleService.update(vo);
			}else{
				sysUserRoleService.insert(vo);
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
	 * @param sur_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  sur_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			SysUserRole vo = sysUserRoleService.find(sur_id);
			//设置删除标志位
			sysUserRoleService.update(vo);
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
		String sur_id = request.getParameter("sur_id");
		if (StringUtils.isNotBlank(sur_id)) {
			queryParams.put("sur_id", sur_id);
		}
		//	
		String sur_roleid = request.getParameter("sur_roleid");
		if (StringUtils.isNotBlank(sur_roleid)) {
			queryParams.put("sur_roleid", sur_roleid);
		}
		//	
		String sur_userid = request.getParameter("sur_userid");
		if (StringUtils.isNotBlank(sur_userid)) {
			queryParams.put("sur_userid", sur_userid);
		}
		//	
		String sur_state = request.getParameter("sur_state");
		if (StringUtils.isNotBlank(sur_state)) {
			queryParams.put("sur_state", sur_state);
		}
		//	
		String sur_dr = request.getParameter("sur_dr");
		if (StringUtils.isNotBlank(sur_dr)) {
			queryParams.put("sur_dr", sur_dr);
		}
		//	
		String sur_addtime = request.getParameter("sur_addtime");
		if (StringUtils.isNotBlank(sur_addtime)) {
			queryParams.put("sur_addtime", sur_addtime);
		}
		//	
		String sur_updatetime = request.getParameter("sur_updatetime");
		if (StringUtils.isNotBlank(sur_updatetime)) {
			queryParams.put("sur_updatetime", sur_updatetime);
		}
		//	
		String sur_ts = request.getParameter("sur_ts");
		if (StringUtils.isNotBlank(sur_ts)) {
			queryParams.put("sur_ts", sur_ts);
		}
		return queryParams;
	}
}