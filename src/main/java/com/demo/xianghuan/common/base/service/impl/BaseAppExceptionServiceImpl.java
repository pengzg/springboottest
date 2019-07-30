package com.demo.xianghuan.common.base.service.impl;

import com.demo.xianghuan.common.base.dao.IBaseAppExceptionDao;
import com.demo.xianghuan.common.base.model.BaseAppException;
import com.demo.xianghuan.common.base.service.IBaseAppExceptionService;
import com.demo.xianghuan.common.base.vo.BaseAppExceptionVO;
import com.demo.xianghuan.utils.BusinessException;
import com.demo.xianghuan.utils.DataGrid;
import com.demo.xianghuan.utils.Query;
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
@Service("baseAppExceptionService")
public class BaseAppExceptionServiceImpl implements IBaseAppExceptionService {
	private static final Logger log = LoggerFactory.getLogger(BaseAppExceptionServiceImpl.class);
	@Autowired
	private IBaseAppExceptionDao baseAppExceptionDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return baseAppExceptionDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<BaseAppException> select(Map<String, Object> queryParams) {
		return baseAppExceptionDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<BaseAppExceptionVO> dg = new DataGrid<BaseAppExceptionVO>();
		List<BaseAppException> list = baseAppExceptionDao.queryByCondition(query);
		BaseAppExceptionVO vo = null;
		for (BaseAppException itemVO : list) {
			vo = new BaseAppExceptionVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(baseAppExceptionDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseAppException vo) {
		return baseAppExceptionDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseAppException[] vos) {
		 baseAppExceptionDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAppException find(String bae_id){
		return baseAppExceptionDao.find(bae_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseAppException vo) {
		BaseAppException temp = find(vo.getBae_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return baseAppExceptionDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseAppException vo) {
		BaseAppException temp = find(vo.getBae_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return baseAppExceptionDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseAppException[] vos) {
		return baseAppExceptionDao.updateBatch(vos);
	}
	
}
