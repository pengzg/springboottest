
package com.demo.xianghuan.admin.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.demo.xianghuan.utils.Result;
import com.demo.xianghuan.utils.HttpCode;
import com.demo.xianghuan.utils.Pager;
import com.demo.xianghuan.utils.Query;

import com.demo.xianghuan.admin.base.service.IBaseAttachmentService;
import com.demo.xianghuan.admin.base.model.BaseAttachment;
import com.demo.xianghuan.admin.base.vo.BaseAttachmentVO;

@Controller
@RequestMapping("/admin/base/baseAttachmentControl")
public class BaseAttachmentController{
	private static final Logger log = LoggerFactory.getLogger(BaseAttachmentController.class);
	@Autowired
	private IBaseAttachmentService baseAttachmentService;

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
		result.setData(HttpCode.OK, baseAttachmentService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param ba_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  ba_id) {
		Result result = new Result();
		try{
			BaseAttachmentVO vo = baseAttachmentService.getDetail(ba_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseAttachment vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseAttachment vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseAttachmentService.insert(vo);
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
	public Result update(HttpServletRequest request,BaseAttachment vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBa_id()!=null){
				baseAttachmentService.update(vo);
			}else{
				baseAttachmentService.insert(vo);
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
	 * @param ba_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  ba_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseAttachment vo = baseAttachmentService.find(ba_id);
			//设置删除标志位
			baseAttachmentService.update(vo);
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
		//自增id	
		String ba_id = request.getParameter("ba_id");
		if (StringUtils.isNotBlank(ba_id)) {
			queryParams.put("ba_id", ba_id);
		}
		//所属公司	
		String ba_orgid = request.getParameter("ba_orgid");
		if (StringUtils.isNotBlank(ba_orgid)) {
			queryParams.put("ba_orgid", ba_orgid);
		}
		//商品图片标题	
		String ba_tittle = request.getParameter("ba_tittle");
		if (StringUtils.isNotBlank(ba_tittle)) {
			queryParams.put("ba_tittle", ba_tittle);
		}
		//路径	
		String ba_path = request.getParameter("ba_path");
		if (StringUtils.isNotBlank(ba_path)) {
			queryParams.put("ba_path", ba_path);
		}
		//类型（0-其他；1-图片；2-视频）	
		String ba_type = request.getParameter("ba_type");
		if (StringUtils.isNotBlank(ba_type)) {
			queryParams.put("ba_type", ba_type);
		}
		//附件尺寸	
		String ba_size = request.getParameter("ba_size");
		if (StringUtils.isNotBlank(ba_size)) {
			queryParams.put("ba_size", ba_size);
		}
		//原始文件名称	
		String ba_file_name = request.getParameter("ba_file_name");
		if (StringUtils.isNotBlank(ba_file_name)) {
			queryParams.put("ba_file_name", ba_file_name);
		}
		//附件描述	
		String ba_description = request.getParameter("ba_description");
		if (StringUtils.isNotBlank(ba_description)) {
			queryParams.put("ba_description", ba_description);
		}
		//状态	
		String ba_status = request.getParameter("ba_status");
		if (StringUtils.isNotBlank(ba_status)) {
			queryParams.put("ba_status", ba_status);
		}
		//添加时间	
		String ba_add_time = request.getParameter("ba_add_time");
		if (StringUtils.isNotBlank(ba_add_time)) {
			queryParams.put("ba_add_time", ba_add_time);
		}
		//上传用户id	
		String ba_adduserid = request.getParameter("ba_adduserid");
		if (StringUtils.isNotBlank(ba_adduserid)) {
			queryParams.put("ba_adduserid", ba_adduserid);
		}
		//	
		String ba_dr = request.getParameter("ba_dr");
		if (StringUtils.isNotBlank(ba_dr)) {
			queryParams.put("ba_dr", ba_dr);
		}
		return queryParams;
	}
}