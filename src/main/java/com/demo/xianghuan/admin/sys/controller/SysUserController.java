
package com.demo.xianghuan.admin.sys.controller;

import com.demo.xianghuan.admin.sys.model.SysUser;
import com.demo.xianghuan.admin.sys.service.ISysUserService;
import com.demo.xianghuan.admin.sys.vo.SysUserVO;
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
@RequestMapping("/admin/base/sysUserControl")
public class SysUserController{
	private static final Logger log = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private ISysUserService sysUserService;

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
		result.setData(HttpCode.OK, sysUserService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param su_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  su_id) {
		Result result = new Result();
		try{
			SysUserVO vo = sysUserService.getDetail(su_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param SysUser vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(SysUser vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			sysUserService.insert(vo);
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
	public Result update(HttpServletRequest request,SysUser vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getSu_id()!=null){
				sysUserService.update(vo);
			}else{
				sysUserService.insert(vo);
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
	 * @param su_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  su_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			SysUser vo = sysUserService.find(su_id);
			//设置删除标志位
			sysUserService.update(vo);
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
		String su_id = request.getParameter("su_id");
		if (StringUtils.isNotBlank(su_id)) {
			queryParams.put("su_id", su_id);
		}
		//图像	
		String su_img = request.getParameter("su_img");
		if (StringUtils.isNotBlank(su_img)) {
			queryParams.put("su_img", su_img);
		}
		//登陆名	
		String su_loginname = request.getParameter("su_loginname");
		if (StringUtils.isNotBlank(su_loginname)) {
			queryParams.put("su_loginname", su_loginname);
		}
		//用户描述	
		String su_name = request.getParameter("su_name");
		if (StringUtils.isNotBlank(su_name)) {
			queryParams.put("su_name", su_name);
		}
		//用户拼音	
		String su_querycode = request.getParameter("su_querycode");
		if (StringUtils.isNotBlank(su_querycode)) {
			queryParams.put("su_querycode", su_querycode);
		}
		//密码	
		String su_pwd = request.getParameter("su_pwd");
		if (StringUtils.isNotBlank(su_pwd)) {
			queryParams.put("su_pwd", su_pwd);
		}
		//所属公司	
		String su_orgid = request.getParameter("su_orgid");
		if (StringUtils.isNotBlank(su_orgid)) {
			queryParams.put("su_orgid", su_orgid);
		}
		//有效开始日期	
		String su_startdate = request.getParameter("su_startdate");
		if (StringUtils.isNotBlank(su_startdate)) {
			queryParams.put("su_startdate", su_startdate);
		}
		//有效结束日期	
		String su_enddate = request.getParameter("su_enddate");
		if (StringUtils.isNotBlank(su_enddate)) {
			queryParams.put("su_enddate", su_enddate);
		}
		//用户类型  1车销  2跑单 4配送 5管理员	
		String su_usertype = request.getParameter("su_usertype");
		if (StringUtils.isNotBlank(su_usertype)) {
			queryParams.put("su_usertype", su_usertype);
		}
		//角色	
		String su_role = request.getParameter("su_role");
		if (StringUtils.isNotBlank(su_role)) {
			queryParams.put("su_role", su_role);
		}
		//用户状态	
		String su_state = request.getParameter("su_state");
		if (StringUtils.isNotBlank(su_state)) {
			queryParams.put("su_state", su_state);
		}
		//最后登陆日期	
		String su_lastlogin = request.getParameter("su_lastlogin");
		if (StringUtils.isNotBlank(su_lastlogin)) {
			queryParams.put("su_lastlogin", su_lastlogin);
		}
		//创建时间	
		String su_addtime = request.getParameter("su_addtime");
		if (StringUtils.isNotBlank(su_addtime)) {
			queryParams.put("su_addtime", su_addtime);
		}
		//	
		String su_updatetime = request.getParameter("su_updatetime");
		if (StringUtils.isNotBlank(su_updatetime)) {
			queryParams.put("su_updatetime", su_updatetime);
		}
		//删除标志位	
		String su_dr = request.getParameter("su_dr");
		if (StringUtils.isNotBlank(su_dr)) {
			queryParams.put("su_dr", su_dr);
		}
		//时间	
		String su_ts = request.getParameter("su_ts");
		if (StringUtils.isNotBlank(su_ts)) {
			queryParams.put("su_ts", su_ts);
		}
		//唯一哈希值	
		String su_hash = request.getParameter("su_hash");
		if (StringUtils.isNotBlank(su_hash)) {
			queryParams.put("su_hash", su_hash);
		}
		//unionid	
		String su_unionid = request.getParameter("su_unionid");
		if (StringUtils.isNotBlank(su_unionid)) {
			queryParams.put("su_unionid", su_unionid);
		}
		return queryParams;
	}
}