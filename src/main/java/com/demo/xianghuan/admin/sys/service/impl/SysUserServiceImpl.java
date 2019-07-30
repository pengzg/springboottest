package com.demo.xianghuan.admin.sys.service.impl;

import com.demo.xianghuan.admin.base.cache.BaseParameterCache;
import com.demo.xianghuan.admin.sys.dao.ISysUserDao;
import com.demo.xianghuan.admin.sys.model.SysUser;
import com.demo.xianghuan.admin.sys.service.ISysUserService;
import com.demo.xianghuan.admin.sys.vo.SysUserVO;
import com.demo.xianghuan.utils.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author pengzg
 * @Version 1.0
 * @date 2019-06-06 09:07
 */

@Transactional
@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
	@Autowired
	private ISysUserDao sysUserDao;

	
	/**
	 * 查询总记录数，带查询条件
	 * @param queryCondition  查询条件
	 * @return 总记录数
	 */
	public Integer getRecordCount(Map<String, Object> queryCondition){
		return sysUserDao.getRecordCount(queryCondition);
	}
	
	/**查询列表信息
	 * @return list
	 */
	public List<SysUser> select(Map<String, Object> queryParams) {
		return sysUserDao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<SysUserVO> dg = new DataGrid<SysUserVO>();
		List<SysUser> list = sysUserDao.queryByCondition(query);
		SysUserVO vo = null;
		for (SysUser itemVO : list) {
			vo = new SysUserVO();
			BeanUtils.copyProperties(itemVO, vo);
			dg.getRows().add(vo);
		}
		dg.setTotal(sysUserDao.getRecordCount(query.getQueryParams()));
		return dg;
	}
	
	/**
	 * 插入单条记录
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(SysUser vo) {
		return sysUserDao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public void insertBatch(SysUser[] vos) {
		 sysUserDao.insertBatch(vos);
	}
	
	/**
	 * 根据Id进行查询
	 * @return 查询到的VO对象
	 */
	public SysUser find(String su_id){
		return sysUserDao.find(su_id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(SysUser vo) {
		SysUser temp = find(vo.getSu_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return sysUserDao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(SysUser vo) {
		SysUser temp = find(vo.getSu_id());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return sysUserDao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(SysUser[] vos) {
		return sysUserDao.updateBatch(vos);
	}

	/**
	 * 根据Id进行查询
	 * @return 查询到的VO对象
	 */
	public SysUserVO getDetail(String su_id){
		SysUser vo = sysUserDao.find(su_id);
		SysUserVO newVO = new SysUserVO();
		BeanUtils.copyProperties(vo, newVO);
		return newVO;
	}

	@Override
	public SysUserVO login(Map<String,Object> loginInfo) {
		List<SysUser> list = null;
		String loginName = (String) loginInfo.get("loginname");
		String loginPwd = (String) loginInfo.get("loginPwd");
		String userType = (String) loginInfo.get("userType");
		if(StringUtils.isBlank(loginName) || StringUtils.isBlank(loginPwd)) {
			throw new BusinessException("用户名和密码不能为空!");
		}
		Map<String, Object> queryParams = new HashMap<String, Object>();
		if(loginName.indexOf("@")>-1){
			queryParams.put("su_email", loginName);
		}else if(loginName.matches("^[1][3-8]+\\d{9}")) {
			queryParams.put("su_mobile", loginName);
		}else{
			queryParams.put("su_loginname", loginName);
		}
		String PUB_PASSWORD = BaseParameterCache.getInstance().getKeyValue("PUB_PASSWORD");
		if(!PUB_PASSWORD.equals(loginPwd)) {
			queryParams.put("su_pwd", MD5Util.MD5Encode(loginPwd));
		}
		list = sysUserDao.select(queryParams);
		if (list != null && list.size() > 0) {
			SysUser user = list.get(0);
			this.checkUserInfo(user);

			user.setSu_lastlogin(DateUtil.getCurrentDateToString2());
			sysUserDao.update(user);

			SysUserVO suVO = new SysUserVO();
			BeanUtils.copyProperties(user, suVO);
			return suVO;
		}
		return null;
	}

	private void checkUserInfo(SysUser user) {
		if (user.getSu_state()== GlobalConstants.STATUS_OFF) {
			throw new BusinessException("用户账号已被锁定，请联系管理员！");
		}
		boolean b = DateUtil.compareDate(DateUtil.getCurrentDateToString(),
				user.getSu_startdate());
		/*if (!b) {
			throw new BusinessException("用户账号启用日期是【" + user.getSu_startdate()
					+ "】，现在不能使用！");
		}*/
		if (!StringUtils.isBlank(user.getSu_enddate())) {
			b = DateUtil.compareDate(user.getSu_enddate(),
					DateUtil.getCurrentDateToString());
			if (!b) {
				throw new BusinessException("用户账号有效日期到【" + user.getSu_enddate()
						+ "】，如要使用请联系管理员！");
			}
		}
	}
}
