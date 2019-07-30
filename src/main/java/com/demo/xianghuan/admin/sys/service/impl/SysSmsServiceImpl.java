package com.demo.xianghuan.admin.sys.service.impl;

import com.demo.xianghuan.admin.sys.dao.ISysSmsDao;
import com.demo.xianghuan.admin.sys.model.SysSms;
import com.demo.xianghuan.admin.sys.service.ISysSmsService;
import com.demo.xianghuan.admin.sys.vo.SysSmsVO;
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
 * @date 2019-06-06 09:07
 */

@Transactional
@Service("sysSmsService")
public class SysSmsServiceImpl implements ISysSmsService {
	private static final Logger log = LoggerFactory.getLogger(SysSmsServiceImpl.class);
	@Autowired
	private ISysSmsDao sysSmsDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return sysSmsDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<SysSms> select(Map<String, Object> queryParams) {
		return sysSmsDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<SysSmsVO> dg = new DataGrid<SysSmsVO>();
		List<SysSms> list = sysSmsDao.queryByCondition(query);
		SysSmsVO vo = null;
		for (SysSms itemVO : list) {
			vo = new SysSmsVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(sysSmsDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(SysSms vo) {
		return sysSmsDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(SysSms[] vos) {
		 sysSmsDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysSms find(String ss_id){
		return sysSmsDao.find(ss_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(SysSms vo) {
		SysSms temp = find(vo.getSs_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return sysSmsDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(SysSms vo) {
		SysSms temp = find(vo.getSs_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return sysSmsDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(SysSms[] vos) {
		return sysSmsDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysSmsVO getDetail(String ss_id){
		SysSms vo = sysSmsDao.find(ss_id);
		SysSmsVO newVO = new SysSmsVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}
}
