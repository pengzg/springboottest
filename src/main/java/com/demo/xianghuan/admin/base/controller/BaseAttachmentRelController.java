
package com.demo.xianghuan.admin.base.controller;

import com.demo.xianghuan.admin.base.model.BaseAttachmentRel;
import com.demo.xianghuan.admin.base.service.IBaseAttachmentRelService;
import com.demo.xianghuan.admin.base.vo.BaseAttachmentRelVO;
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
@RequestMapping("/admin/base/baseAttachmentRelControl")
public class BaseAttachmentRelController{
	private static final Logger log = LoggerFactory.getLogger(BaseAttachmentRelController.class);
	@Autowired
	private IBaseAttachmentRelService baseAttachmentRelService;

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
		result.setData(HttpCode.OK, baseAttachmentRelService.dataGrid(query),null);
		return result;
	}

	

	/**
	 * 查询明细
	 * @param request
	 * @param bar_id
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public Result getDetail(HttpServletRequest request, String  bar_id) {
		Result result = new Result();
		try{
			BaseAttachmentRelVO vo = baseAttachmentRelService.getDetail(bar_id);
			result.setData(HttpCode.OK,vo ,null);
		}catch (Exception e) {
			log.error("获取详情异常!【"+e.getMessage()+"】",e);
			result.setError("失败");
		}
		return result;
	}

	/**
	 * 增加一条记录
	 * @param BaseAttachmentRel vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Result insert(BaseAttachmentRel vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			baseAttachmentRelService.insert(vo);
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
	public Result update(HttpServletRequest request,BaseAttachmentRel vo) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			if (vo.getBar_id()!=null){
				baseAttachmentRelService.update(vo);
			}else{
				baseAttachmentRelService.insert(vo);
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
	 * @param bar_id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,String  bar_id) {
		Result result = new Result();
		try {
//			SessionInfo sessionInfo = (SessionInfo) request.getSession()
//			.getAttribute(BaseController.RM_LOGIN_USER);
			BaseAttachmentRel vo = baseAttachmentRelService.find(bar_id);
			//设置删除标志位
			baseAttachmentRelService.update(vo);
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
		String bar_id = request.getParameter("bar_id");
		if (StringUtils.isNotBlank(bar_id)) {
			queryParams.put("bar_id", bar_id);
		}
		//图片来源1商品，2 签到 3.订水库存	
		String bar_source = request.getParameter("bar_source");
		if (StringUtils.isNotBlank(bar_source)) {
			queryParams.put("bar_source", bar_source);
		}
		//商品描述id	
		String bar_source_id = request.getParameter("bar_source_id");
		if (StringUtils.isNotBlank(bar_source_id)) {
			queryParams.put("bar_source_id", bar_source_id);
		}
		//图片id	
		String bar_attament_id = request.getParameter("bar_attament_id");
		if (StringUtils.isNotBlank(bar_attament_id)) {
			queryParams.put("bar_attament_id", bar_attament_id);
		}
		//状态	
		String bar_state = request.getParameter("bar_state");
		if (StringUtils.isNotBlank(bar_state)) {
			queryParams.put("bar_state", bar_state);
		}
		//wtr_dr	
		String bar_dr = request.getParameter("bar_dr");
		if (StringUtils.isNotBlank(bar_dr)) {
			queryParams.put("bar_dr", bar_dr);
		}
		//添加时间	
		String bar_add_time = request.getParameter("bar_add_time");
		if (StringUtils.isNotBlank(bar_add_time)) {
			queryParams.put("bar_add_time", bar_add_time);
		}
		//操作人	
		String bar_add_userid = request.getParameter("bar_add_userid");
		if (StringUtils.isNotBlank(bar_add_userid)) {
			queryParams.put("bar_add_userid", bar_add_userid);
		}
		//排序	
		String bar_order = request.getParameter("bar_order");
		if (StringUtils.isNotBlank(bar_order)) {
			queryParams.put("bar_order", bar_order);
		}
		return queryParams;
	}
}