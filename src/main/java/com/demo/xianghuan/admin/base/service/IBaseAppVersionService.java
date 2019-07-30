package com.demo.xianghuan.admin.base.service;

import com.demo.xianghuan.admin.base.model.BaseAppVersion;
import com.demo.xianghuan.utils.DataGrid;
import com.demo.xianghuan.utils.Query;

import java.util.List;
import java.util.Map;

/*
 * @Author pengzg
 * @Version 1.0
 * @date Wed May  8 10:32:14 CST 2019
 */


public interface IBaseAppVersionService {
	
	
	/**查询列表信息
	 * @param queryParams
	 * @return list
	 */
	public List<BaseAppVersion> select(Map<String, Object> queryParams);
	
	
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
	public String insert(BaseAppVersion vo);

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseAppVersion[] vos);

	

	/**
	 * 根据主键进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAppVersion find(String bv_id);

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseAppVersion vo);
	
	
	/**
	 * 更新多条选中的记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseAppVersion vo);
	
	

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseAppVersion[] vos);

}
