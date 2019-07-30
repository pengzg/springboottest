package com.demo.xianghuan.admin.sys.service.impl;

import com.demo.xianghuan.admin.sys.dao.ISysUserRoleDao;
import com.demo.xianghuan.admin.sys.model.SysUserRole;
import com.demo.xianghuan.admin.sys.service.ISysUserRoleService;
import com.demo.xianghuan.admin.sys.vo.SysUserRoleVO;
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
 * @date 2019-06-06 09:07
 */

@Transactional
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements ISysUserRoleService {
	private static final Logger log = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);
	@Autowired
	private ISysUserRoleDao sysUserRoleDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return sysUserRoleDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<SysUserRole> select(Map<String, Object> queryParams) {
		return sysUserRoleDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<SysUserRoleVO> dg = new DataGrid<SysUserRoleVO>();
		List<SysUserRole> list = sysUserRoleDao.queryByCondition(query);
		SysUserRoleVO vo = null;
		for (SysUserRole itemVO : list) {
			vo = new SysUserRoleVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(sysUserRoleDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(SysUserRole vo) {
		return sysUserRoleDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(SysUserRole[] vos) {
		 sysUserRoleDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysUserRole find(String sur_id){
		return sysUserRoleDao.find(sur_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(SysUserRole vo) {
		SysUserRole temp = find(vo.getSur_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return sysUserRoleDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(SysUserRole vo) {
		SysUserRole temp = find(vo.getSur_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return sysUserRoleDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(SysUserRole[] vos) {
		return sysUserRoleDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysUserRoleVO getDetail(String sur_id){
		SysUserRole vo = sysUserRoleDao.find(sur_id);
		SysUserRoleVO newVO = new SysUserRoleVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}
}
