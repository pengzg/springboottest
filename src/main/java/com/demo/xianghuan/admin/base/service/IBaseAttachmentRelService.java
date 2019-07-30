package com.demo.xianghuan.admin.base.service;

import com.demo.xianghuan.admin.base.model.BaseAttachmentRel;
import com.demo.xianghuan.admin.base.vo.BaseAttachmentRelVO;
import com.sqhz.web.model.DataGrid;
import com.sqhz.web.model.Query;

import java.util.List;
import java.util.Map;

/*
 * @Author pengzg
 * @Version 1.0
 * @date 2019-06-08
 */

public interface IBaseAttachmentRelService {
	
	
	/**查询列表信息
	 * @param queryParams
	 * @return list
	 */
	public List<BaseAttachmentRel> select(Map<String, Object> queryParams);
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query);

	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseAttachmentRel vo);

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseAttachmentRel[] vos);

	

	/**
	 * 根据主键进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAttachmentRel find(String bar_id);

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseAttachmentRel vo);
	
	
	/**
	 * 更新多条选中的记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseAttachmentRel vo);
	
	

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseAttachmentRel[] vos);

	/**
	 * 根据主键进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAttachmentRelVO getDetail(String bar_id);


		}
