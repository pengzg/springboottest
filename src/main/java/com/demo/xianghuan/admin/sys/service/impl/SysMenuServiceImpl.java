package com.demo.xianghuan.admin.sys.service.impl;

import com.demo.xianghuan.admin.base.service.impl.BaseIdServiceImpl;
import com.demo.xianghuan.admin.sys.dao.ISysMenuDao;
import com.demo.xianghuan.admin.sys.model.SysMenu;
import com.demo.xianghuan.admin.sys.service.ISysMenuService;
import com.demo.xianghuan.admin.sys.vo.MenusListVO;
import com.demo.xianghuan.admin.sys.vo.SysMenuVO;
import com.sqhz.common.base.GlobalConstants;
import com.sqhz.common.util.DateUtil;
import com.sqhz.jdbc.framework.exception.BusinessException;
import com.sqhz.web.model.DataGrid;
import com.sqhz.web.model.Query;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @Author pengzg
 * @Version 1.0
 * @date 2019-06-06 09:07
 */

@Transactional
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseIdServiceImpl implements ISysMenuService {
	private static final Logger log = LoggerFactory.getLogger(SysMenuServiceImpl.class);
	@Autowired
	private ISysMenuDao sysMenuDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return sysMenuDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<SysMenu> select(Map<String, Object> queryParams) {
		return sysMenuDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<SysMenuVO> dg = new DataGrid<SysMenuVO>();
		List<SysMenu> list = sysMenuDao.queryByCondition(query);
		SysMenuVO vo = null;
		for (SysMenu itemVO : list) {
			vo = new SysMenuVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(sysMenuDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(SysMenu vo) {
		return sysMenuDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(SysMenu[] vos) {
		 sysMenuDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysMenu find(String sm_id){
		return sysMenuDao.find(sm_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(SysMenu vo) {
		SysMenu temp = find(vo.getSm_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return sysMenuDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(SysMenu vo) {
		SysMenu temp = find(vo.getSm_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return sysMenuDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(SysMenu[] vos) {
		return sysMenuDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public SysMenuVO getDetail(String sm_id){
		SysMenu vo = sysMenuDao.find(sm_id);
		SysMenuVO newVO = new SysMenuVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}




	public List<MenusListVO> getMenuList(Map<String, Object> queryParams) {
		List<SysMenu> menus =  this.select(queryParams);
		List<MenusListVO> rootMenu = new ArrayList<>();
		List<MenusListVO> menuList = new ArrayList<>();
		for (SysMenu menusVO : menus) {
			//原始菜单rootMenu
			MenusListVO vo = new MenusListVO();
			BeanUtils.copyProperties(menusVO,vo);
			rootMenu.add(vo);
			//一级菜单
			if("0".equals(menusVO.getSm_level())){
				menuList.add(vo);
			}
		}
		for (MenusListVO menusListVO : menuList) {
			menusListVO.setChildMenus(getChild(menusListVO.getSm_id(), rootMenu));
		}
		return menuList;
	}


	public void updateOrInsert(SysMenu vo) {
		if (StringUtils.isNotBlank(vo.getSm_id())) {
			this.update(vo);
		} else {
			vo.setSm_state(GlobalConstants.STATUS_ON);
			vo.setSm_dr(GlobalConstants.SAVE);
			vo.setSm_adddate(DateUtil.getCurrentDateToString2());
			vo.setSm_id(super.createId(""));
			this.insert(vo);
		}
	}

	private List<MenusListVO> getChild(String id, List<MenusListVO> rootMenu) {
		// 子菜单
		List<MenusListVO> childList = new ArrayList<>();
		for (MenusListVO menu : rootMenu) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (StringUtils.isNotBlank(menu.getSm_pid())) {
				if (menu.getSm_pid().equals(id)) {
					childList.add(menu);
				}
			}
		}
		// 把子菜单的子菜单再循环一遍
		for (MenusListVO menu : childList) {// 没有url子菜单还有子菜单
			// 递归
			menu.setChildMenus(getChild(menu.getSm_id(), rootMenu));
		} // 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}
}
