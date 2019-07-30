package com.demo.xianghuan.admin.sys.service.impl;

import com.demo.xianghuan.admin.sys.dao.ISysRoleDao;
import com.demo.xianghuan.admin.sys.model.SysRole;
import com.demo.xianghuan.admin.sys.service.ISysRoleService;
import com.demo.xianghuan.admin.sys.vo.SysRoleVO;
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
@Service("sysRoleService")
public class SysRoleServiceImpl implements ISysRoleService {
	private static final Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);
	@Autowired
	private ISysRoleDao sysRoleDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return sysRoleDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<SysRole> select(Map<String, Object> queryParams) {
		return sysRoleDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<SysRoleVO> dg = new DataGrid<SysRoleVO>();
		List<SysRole> list = sysRoleDao.queryByCondition(query);
		SysRoleVO vo = null;
		for (SysRole itemVO : list) {
			vo = new SysRoleVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(sysRoleDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(SysRole vo) {
		return sysRoleDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(SysRole[] vos) {
		 sysRoleDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysRole find(String sr_id){
		return sysRoleDao.find(sr_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(SysRole vo) {
		SysRole temp = find(vo.getSr_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return sysRoleDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(SysRole vo) {
		SysRole temp = find(vo.getSr_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return sysRoleDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(SysRole[] vos) {
		return sysRoleDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysRoleVO getDetail(String sr_id){
		SysRole vo = sysRoleDao.find(sr_id);
		SysRoleVO newVO = new SysRoleVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}
}
