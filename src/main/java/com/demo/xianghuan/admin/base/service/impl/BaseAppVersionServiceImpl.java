package com.demo.xianghuan.admin.base.service.impl;

import com.demo.xianghuan.admin.base.dao.IBaseAppVersionDao;
import com.demo.xianghuan.admin.base.model.BaseAppVersion;
import com.demo.xianghuan.admin.base.service.IBaseAppVersionService;
import com.demo.xianghuan.admin.base.vo.BaseAppVersionVO;
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
@Service("baseAppVersionService")
public class BaseAppVersionServiceImpl implements IBaseAppVersionService {
	private static final Logger log = LoggerFactory.getLogger(BaseAppVersionServiceImpl.class);
	@Autowired
	private IBaseAppVersionDao baseAppVersionDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return baseAppVersionDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<BaseAppVersion> select(Map<String, Object> queryParams) {
		return baseAppVersionDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<BaseAppVersionVO> dg = new DataGrid<BaseAppVersionVO>();
		List<BaseAppVersion> list = baseAppVersionDao.queryByCondition(query);
		BaseAppVersionVO vo = null;
		for (BaseAppVersion itemVO : list) {
			vo = new BaseAppVersionVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(baseAppVersionDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseAppVersion vo) {
		return baseAppVersionDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseAppVersion[] vos) {
		 baseAppVersionDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAppVersion find(String bv_id){
		return baseAppVersionDao.find(bv_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseAppVersion vo) {
		BaseAppVersion temp = find(vo.getBv_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return baseAppVersionDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseAppVersion vo) {
		BaseAppVersion temp = find(vo.getBv_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return baseAppVersionDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseAppVersion[] vos) {
		return baseAppVersionDao.updateBatch(vos);
	}
	
}
