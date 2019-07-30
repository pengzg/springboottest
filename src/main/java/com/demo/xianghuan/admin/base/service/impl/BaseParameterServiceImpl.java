package com.demo.xianghuan.admin.base.service.impl;

import com.demo.xianghuan.admin.base.dao.IBaseParameterDao;
import com.demo.xianghuan.admin.base.model.BaseParameter;
import com.demo.xianghuan.admin.base.service.IBaseParameterService;
import com.demo.xianghuan.admin.base.vo.BaseParameterVO;



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
@Service("baseParameterService")
public class BaseParameterServiceImpl implements IBaseParameterService {
	private static final Logger log = LoggerFactory.getLogger(BaseParameterServiceImpl.class);
	@Autowired
	private IBaseParameterDao baseParameterDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return baseParameterDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<BaseParameter> select(Map<String, Object> queryParams) {
		return baseParameterDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<BaseParameterVO> dg = new DataGrid<BaseParameterVO>();
		List<BaseParameter> list = baseParameterDao.queryByCondition(query);
		BaseParameterVO vo = null;
		for (BaseParameter itemVO : list) {
			vo = new BaseParameterVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(baseParameterDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseParameter vo) {
		return baseParameterDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseParameter[] vos) {
		 baseParameterDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseParameter find(String bp_id){
		return baseParameterDao.find(bp_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseParameter vo) {
		BaseParameter temp = find(vo.getBp_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return baseParameterDao.update(temp);
	}


	public BaseParameterServiceImpl() {
		super();
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseParameter vo) {
		BaseParameter temp = find(vo.getBp_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return baseParameterDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseParameter[] vos) {
		return baseParameterDao.updateBatch(vos);
	}

	@Override
	public BaseParameter findByKeyCode(String key) {
		return baseParameterDao.findByKeyCode(key);
	}
}
