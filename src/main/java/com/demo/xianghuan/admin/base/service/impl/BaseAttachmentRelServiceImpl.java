package com.demo.xianghuan.admin.base.service.impl;

import com.demo.xianghuan.admin.base.dao.IBaseAttachmentRelDao;
import com.demo.xianghuan.admin.base.model.BaseAttachmentRel;
import com.demo.xianghuan.admin.base.service.IBaseAttachmentRelService;
import com.demo.xianghuan.admin.base.vo.BaseAttachmentRelVO;
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
 * @date 2019-06-08
 */

@Transactional
@Service("baseAttachmentRelService")
public class BaseAttachmentRelServiceImpl implements IBaseAttachmentRelService {
	private static final Logger log = LoggerFactory.getLogger(BaseAttachmentRelServiceImpl.class);
	@Autowired
	private IBaseAttachmentRelDao baseAttachmentRelDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return baseAttachmentRelDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<BaseAttachmentRel> select(Map<String, Object> queryParams) {
		return baseAttachmentRelDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<BaseAttachmentRelVO> dg = new DataGrid<BaseAttachmentRelVO>();
		List<BaseAttachmentRel> list = baseAttachmentRelDao.queryByCondition(query);
		BaseAttachmentRelVO vo = null;
		for (BaseAttachmentRel itemVO : list) {
			vo = new BaseAttachmentRelVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(baseAttachmentRelDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseAttachmentRel vo) {
		return baseAttachmentRelDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseAttachmentRel[] vos) {
		 baseAttachmentRelDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAttachmentRel find(String bar_id){
		return baseAttachmentRelDao.find(bar_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseAttachmentRel vo) {
		BaseAttachmentRel temp = find(vo.getBar_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return baseAttachmentRelDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseAttachmentRel vo) {
		BaseAttachmentRel temp = find(vo.getBar_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return baseAttachmentRelDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseAttachmentRel[] vos) {
		return baseAttachmentRelDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAttachmentRelVO getDetail(String bar_id){
		BaseAttachmentRel vo = baseAttachmentRelDao.find(bar_id);
		BaseAttachmentRelVO newVO = new BaseAttachmentRelVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}
}
