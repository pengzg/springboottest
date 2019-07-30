package com.demo.xianghuan.admin.user.service.impl;

import java.util.List;
import java.util.Map;

import com.demo.xianghuan.admin.user.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.xianghuan.admin.user.dao.IUserGradeDao;
import com.demo.xianghuan.admin.user.model.UserGrade;
import com.demo.xianghuan.admin.user.service.IUserGradeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @company 社区盒子
 * @author feizhang
 * @version 1.0
 * @date 
 */
@Transactional
@Service("userGradeService")
public class UserGradeServiceImpl implements IUserGradeService {
	private static final Logger log = LoggerFactory.getLogger(UserGradeServiceImpl.class);
	@Autowired
	private IUserGradeDao userGradeDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map queryCondition){
		return userGradeDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<UserGrade> select(Map queryParams) {
		return userGradeDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	/*public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<UserGrade> dg = new DataGrid<UserGrade>();
		dg.setTotal(userGradeDao.getRecordCount(query.getQueryParams()));
		dg.setRows(userGradeDao.queryByCondition(query));
		return dg;
	}*/
	
	/**
	 * 插入单条记录，用id作主键，把null全替换为""
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(UserGrade vo) {
		return userGradeDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录，用id作主键，把null全替换为""
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public String[] insertBatch(UserGrade[] vos) {
		return userGradeDao.insertBatch(vos);
	}
	
	
	/**
	 * 删除单条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int remove(Map params) {
		// TODO Auto-generated method stub
		return userGradeDao.remove(params);
	}

	/**
	 * 删除多条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int removeBatch(Map params) {
		// TODO Auto-generated method stub
		return userGradeDao.removeBatch(params);
	}

	/**
	 * 删除单条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return userGradeDao.delete(id);
	}

	/**
	 * 删除多条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		return userGradeDao.deleteBatch(ids);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public UserGrade find(Integer id){
		return userGradeDao.find(id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(UserGrade vo) {
		UserGrade temp = find(vo.getUg_id());
		
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return userGradeDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(UserGrade vo) {
		UserGrade temp = find(vo.getUg_id());
	
		//todo增加版本号 
		return userGradeDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(UserGrade[] vos) {
		return userGradeDao.updateBatch(vos);
	}
	
}
