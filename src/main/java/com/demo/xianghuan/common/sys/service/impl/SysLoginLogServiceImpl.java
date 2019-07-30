package com.demo.xianghuan.common.sys.service.impl;

import com.demo.xianghuan.common.sys.dao.ISysLoginLogDao;
import com.demo.xianghuan.common.sys.model.SysLoginLog;
import com.demo.xianghuan.common.sys.service.ISysLoginLogService;
import com.demo.xianghuan.common.sys.vo.SysLoginLogVO;
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
@Service("sysLoginLogService")
public class SysLoginLogServiceImpl implements ISysLoginLogService {
	private static final Logger log = LoggerFactory.getLogger(SysLoginLogServiceImpl.class);
	@Autowired
	private ISysLoginLogDao sysLoginLogDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return sysLoginLogDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<SysLoginLog> select(Map<String, Object> queryParams) {
		return sysLoginLogDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<SysLoginLogVO> dg = new DataGrid<SysLoginLogVO>();
		List<SysLoginLog> list = sysLoginLogDao.queryByCondition(query);
		SysLoginLogVO vo = null;
		for (SysLoginLog itemVO : list) {
			vo = new SysLoginLogVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(sysLoginLogDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(SysLoginLog vo) {
		return sysLoginLogDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(SysLoginLog[] vos) {
		 sysLoginLogDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysLoginLog find(String sll_id){
		return sysLoginLogDao.find(sll_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(SysLoginLog vo) {
		SysLoginLog temp = find(vo.getSll_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return sysLoginLogDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(SysLoginLog vo) {
		SysLoginLog temp = find(vo.getSll_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return sysLoginLogDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(SysLoginLog[] vos) {
		return sysLoginLogDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysLoginLogVO getDetail(String sll_id){
		SysLoginLog vo = sysLoginLogDao.find(sll_id);
		SysLoginLogVO newVO = new SysLoginLogVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}
}
