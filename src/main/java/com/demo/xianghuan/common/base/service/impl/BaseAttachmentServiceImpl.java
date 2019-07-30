package com.demo.xianghuan.common.base.service.impl;

import com.demo.xianghuan.common.base.dao.IBaseAttachmentDao;
import com.demo.xianghuan.common.base.model.BaseAttachment;
import com.demo.xianghuan.common.base.service.IBaseAttachmentService;
import com.demo.xianghuan.common.base.vo.BaseAttachmentVO;
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
@Service("baseAttachmentService")
public class BaseAttachmentServiceImpl implements IBaseAttachmentService {
	private static final Logger log = LoggerFactory.getLogger(BaseAttachmentServiceImpl.class);
	@Autowired
	private IBaseAttachmentDao baseAttachmentDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return baseAttachmentDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<BaseAttachment> select(Map<String, Object> queryParams) {
		return baseAttachmentDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<BaseAttachmentVO> dg = new DataGrid<BaseAttachmentVO>();
		List<BaseAttachment> list = baseAttachmentDao.queryByCondition(query);
		BaseAttachmentVO vo = null;
		for (BaseAttachment itemVO : list) {
			vo = new BaseAttachmentVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(baseAttachmentDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(BaseAttachment vo) {
		return baseAttachmentDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(BaseAttachment[] vos) {
		 baseAttachmentDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAttachment find(String ba_id){
		return baseAttachmentDao.find(ba_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(BaseAttachment vo) {
		BaseAttachment temp = find(vo.getBa_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return baseAttachmentDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(BaseAttachment vo) {
		BaseAttachment temp = find(vo.getBa_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return baseAttachmentDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(BaseAttachment[] vos) {
		return baseAttachmentDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public BaseAttachmentVO getDetail(String ba_id){
		BaseAttachment vo = baseAttachmentDao.find(ba_id);
		BaseAttachmentVO newVO = new BaseAttachmentVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}
}
