package com.demo.xianghuan.admin.sys.controller;


import com.demo.xianghuan.admin.sys.model.SysMenu;
import com.demo.xianghuan.admin.sys.model.SysUser;
import com.demo.xianghuan.admin.sys.service.ISysMenuService;
import com.demo.xianghuan.admin.sys.service.ISysUserService;
import com.demo.xianghuan.admin.sys.vo.SysUserVO;
import com.demo.xianghuan.utils.Result;
import com.demo.xianghuan.utils.BusinessException;
import com.sqhz.web.controller.BaseController;
import com.demo.xianghuan.utils.HttpCode;
import com.demo.xianghuan.utils.SessionInfo;
import com.sqhz.web.util.UserSessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feizhang
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/system/loginController")
public class LoginController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(SysLoginLogController.class);

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysMenuService sysMenuService;



    
    /**
     * 登录
     */
    /**
     * 用户登录
     * @return
     */
    @ResponseBody
    @RequestMapping("/doLogin")
    public Result doLogin(HttpServletRequest request, HttpServletResponse response, SysUser data) {

        Result result = new Result();
        String userType = request.getParameter("userType");
        String userName = request.getParameter("userName");
        String loginPwd = request.getParameter("loginPwd");
        String role = request.getParameter("role");
        String yzm = request.getParameter("yzm");
        String token = request.getParameter("token");
        String loginname = request.getParameter("loginname");
        String validatecode = request.getParameter("validatecode");
        try {
            //验证码验证
	/*		String sessionvalidatecode = (String) UserSessionUtil.getSession(SystemConstantsExt.SESSION_VALIDATECODE);
			if(!(StringUtils.isNotBlank(sessionvalidatecode) && StringUtils.isNotBlank(validatecode) && validatecode.equalsIgnoreCase(sessionvalidatecode))) {
				json.setMsg("请输入正确的验证码!");
				return json;
			}*/
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("loginname", loginname);
            map.put("loginPwd", loginPwd);
            map.put("userType", userType);
            SysUserVO suVO = sysUserService.login(map);
            if (suVO != null) {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.setId(suVO.getSu_id());
                sessionInfo.setLogincode(suVO.getSu_loginname());
                sessionInfo.setName(suVO.getSu_name());
                

                //取可以访问的菜单信息
                setMenuPrivValue(sessionInfo,suVO);

                UserSessionUtil.setSession(request, sessionInfo);
                result.setData(HttpCode.OK, null, "登录成功！");
            } else {
                result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, "登录失败！");
            }
        }catch(BusinessException e){

            log.error(e.getMessage(), e);
            result.setData(HttpCode.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
        return result;
    }



    private void setMenuPrivValue(SessionInfo sessionInfo,SysUserVO user) {
        // 取可以访问的菜单信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sur_userid", user.getSu_id());
        List<SysMenu> list = sysMenuService.select(map);
        List<String> menusList = new ArrayList();
        for(SysMenu t:list){
            menusList.add(t.getSm_url());
        }
        sessionInfo.setMenusList(menusList);
    }

    /**
     * 注销系统
     */
    @ResponseBody
    @RequestMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
        result.setData(HttpCode.OK, null, "退出成功！");
        return result;
    }










  

    @Override
    public Map<?, ?> getQueryCondition(HttpServletRequest request) {
        // TODO Auto-generated method stub
        return null;
    }


}