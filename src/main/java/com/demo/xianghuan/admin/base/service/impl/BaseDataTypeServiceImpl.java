package com.demo.xianghuan.admin.base.service.impl;

import com.demo.xianghuan.admin.base.dao.IBaseDataTypeDao;
import com.demo.xianghuan.admin.base.model.BaseDataType;
import com.demo.xianghuan.admin.base.service.IBaseDataTypeService;
import com.demo.xianghuan.admin.base.vo.BaseDataTypeVO;
import com.sqhz.jdbc.framework.exception.BusinessException;
import com.sqhz.web.model.DataGrid;
import com.sqhz.web.model.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 * @Author pengzg
 * @Version 1.0
 * @date Wed May  8 10:32:14 CST 2019
 */

@Transactional
@Service("baseDataTypeService")
public class BaseDataTypeServiceImpl implements IBaseDataTypeService {
	private static final Logger log = LoggerFactory.getLogger(BaseDataTypeServiceImpl.class);
	@Autowired
	private IBaseDataTypeDao baseDataTypeDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return baseDataTypeDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<BaseDataType> select(Map<String, Object> queryParams) {
		return baseDataTypeDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<BaseDataTypeVO> dg = new DataGrid<BaseDataTypeVO>();
		List<BaseDataType> list = baseDataTypeDao.queryByCondition(query);
		BaseDataTypeVO vo = null;
		for (BaseDataType itemVO : list) {
			vo = new BaseDataTypeVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(baseDataTypeDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseDataType vo) {
		return baseDataTypeDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseDataType[] vos) {
		 baseDataTypeDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseDataType find(String bdt_id){
		return baseDataTypeDao.find(bdt_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseDataType vo) {
		BaseDataType temp = find(vo.getBdt_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return baseDataTypeDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseDataType vo) {
		BaseDataType temp = find(vo.getBdt_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return baseDataTypeDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseDataType[] vos) {
		return baseDataTypeDao.updateBatch(vos);
	}
	
}
