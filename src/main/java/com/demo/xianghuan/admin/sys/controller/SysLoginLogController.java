
package com.demo.xianghuan.admin.sys.controller;

import com.demo.xianghuan.admin.sys.model.SysLoginLog;
import com.demo.xianghuan.admin.sys.service.ISysLoginLogService;
import com.demo.xianghuan.admin.sys.vo.SysLoginLogVO;
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
@RequestMapping("/admin/base/sysLoginLogControl")
public class SysLoginLogController{
	private static final Logger log = LoggerFactory.getLogger(SysLoginLogController.class);
	@Autowired
	private ISysLoginLogService sysLoginLogService;

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
		result.setData(HttpCode.OK, sysLoginLogService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param sll_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  sll_id) {
		Result result = new Result();
		try{
			SysLoginLogVO vo = sysLoginLogService.getDetail(sll_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param SysLoginLog vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(SysLoginLog vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			sysLoginLogService.insert(vo);
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
	public Result update(HttpServletRequest request,SysLoginLog vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getSll_id()!=null){
				sysLoginLogService.update(vo);
			}else{
				sysLoginLogService.insert(vo);
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
	 * @param sll_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  sll_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			SysLoginLog vo = sysLoginLogService.find(sll_id);
			//设置删除标志位
			sysLoginLogService.update(vo);
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
		String sll_id = request.getParameter("sll_id");
		if (StringUtils.isNotBlank(sll_id)) {
			queryParams.put("sll_id", sll_id);
		}
		//机构编码	
		String sll_orgid = request.getParameter("sll_orgid");
		if (StringUtils.isNotBlank(sll_orgid)) {
			queryParams.put("sll_orgid", sll_orgid);
		}
		//登陆账号	
		String sll_logincode = request.getParameter("sll_logincode");
		if (StringUtils.isNotBlank(sll_logincode)) {
			queryParams.put("sll_logincode", sll_logincode);
		}
		//登陆名称	
		String sll_loginname = request.getParameter("sll_loginname");
		if (StringUtils.isNotBlank(sll_loginname)) {
			queryParams.put("sll_loginname", sll_loginname);
		}
		//登陆时间	
		String sll_logintime = request.getParameter("sll_logintime");
		if (StringUtils.isNotBlank(sll_logintime)) {
			queryParams.put("sll_logintime", sll_logintime);
		}
		//登陆IP	
		String sll_ip = request.getParameter("sll_ip");
		if (StringUtils.isNotBlank(sll_ip)) {
			queryParams.put("sll_ip", sll_ip);
		}
		//登陆地址	
		String sll_netaddress = request.getParameter("sll_netaddress");
		if (StringUtils.isNotBlank(sll_netaddress)) {
			queryParams.put("sll_netaddress", sll_netaddress);
		}
		//纬度	
		String sll_longitude = request.getParameter("sll_longitude");
		if (StringUtils.isNotBlank(sll_longitude)) {
			queryParams.put("sll_longitude", sll_longitude);
		}
		//纬度	
		String sll_latitude = request.getParameter("sll_latitude");
		if (StringUtils.isNotBlank(sll_latitude)) {
			queryParams.put("sll_latitude", sll_latitude);
		}
		//设备号	
		String sll_equipment = request.getParameter("sll_equipment");
		if (StringUtils.isNotBlank(sll_equipment)) {
			queryParams.put("sll_equipment", sll_equipment);
		}
		//来源 1 web 2 手机	
		String sll_source = request.getParameter("sll_source");
		if (StringUtils.isNotBlank(sll_source)) {
			queryParams.put("sll_source", sll_source);
		}
		//登陆状态	
		String sll_state = request.getParameter("sll_state");
		if (StringUtils.isNotBlank(sll_state)) {
			queryParams.put("sll_state", sll_state);
		}
		//标志位	
		String sll_dr = request.getParameter("sll_dr");
		if (StringUtils.isNotBlank(sll_dr)) {
			queryParams.put("sll_dr", sll_dr);
		}
		//登陆信息	
		String sll_msg = request.getParameter("sll_msg");
		if (StringUtils.isNotBlank(sll_msg)) {
			queryParams.put("sll_msg", sll_msg);
		}
		//版本号	
		String sll_version = request.getParameter("sll_version");
		if (StringUtils.isNotBlank(sll_version)) {
			queryParams.put("sll_version", sll_version);
		}
		//时间	
		String sll_ts = request.getParameter("sll_ts");
		if (StringUtils.isNotBlank(sll_ts)) {
			queryParams.put("sll_ts", sll_ts);
		}
		return queryParams;
	}
}