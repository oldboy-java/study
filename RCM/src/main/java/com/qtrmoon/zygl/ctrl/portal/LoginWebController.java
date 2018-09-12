package com.qtrmoon.zygl.ctrl.portal;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.Constant;
import com.qtrmoon.common.Result;
import com.qtrmoon.common.ResultEnum;
import com.qtrmoon.common.ResultUtils;
import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.sysmanage.SysConstant;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.sysmanage.serdao.ISysmanageService;
import com.qtrmoon.toolkit.MD5;
import com.qtrmoon.zygl.pojo.Phsd;
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.pojo.Yhkzxx;
import com.qtrmoon.zygl.serdao.IZyglService;


@Controller
@RequestMapping("portal/zygl/login")
public class LoginWebController extends BaseController{
	
	@Autowired
	private ISysmanageService sysmanageService;
	@Autowired
	private IZyglService zyglService;								
	
	/***
	 * 资源门户首页登录
	 * @param request
	 * @param pageSize
	 * @param zy
	 * @param model
	 */
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	@ResponseBody
	public Object login(User user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		user.setCondition("");//防sql注入
		User sqlForm = new User();
		sqlForm.setLoginname(user.getLoginname());
		List<User> userList = sysmanageService.schUser(sqlForm);   //根据表单的用户名查询用户是否存在
		if (userList.size() > 0) {      //集合长度大于0时说明存在用户
			User loginUser = userList.get(0);
			String psw = user.getPassword();   //获取表单密码
			if (Constant.getBooleanConstant("pswmd5")) {    //判断密码是否加密
				psw = MD5.getInstance().getMD5to32(psw);
			}
			if (loginUser.getPassword().equals(psw)) {        //如果密码相等，添加session
				HttpSession session=request.getSession();
				SessionUtil.addPortalSessionUser(session, loginUser,SessionUtil.getPortalSessionUser());   
				
				boolean b=false;
				Phsd phsd=new Phsd();
                List<Phsd> phsdList=zyglService.schPhsds(phsd);  //查询偏好设定集合
                for (Phsd phsd2 : phsdList) {
					if(phsd2.getYhid()==loginUser.getId()){       //如果用户设定过偏好b为true
						b=true;
					}
				}
                if(b==true){
                	return ResultUtils.success();    //返回结果
                }else{
                	return ResultUtils.success(2);   
                }				
			}else{
				return ResultUtils.error(ResultEnum.LOGIN_ERROR.getCode(), ResultEnum.LOGIN_ERROR.getMessage());
			}
		}
		return ResultUtils.error(ResultEnum.LOGIN_ERROR.getCode(), ResultEnum.LOGIN_ERROR.getMessage());
	
	}
	
	/**
	 * 退出系统方法
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout.action")
	public void logout(HttpServletRequest request,HttpServletResponse response){
		noCache(response);
		HttpSession session=request.getSession();
		SessionUtil.removeSessionUser(session, SessionUtil.getPortalSessionUser());  //移除session
	}
	
	/**
	 * 修改密码方法
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updPass.action")
	public void updPass(HttpServletRequest request,User user,HttpServletResponse response){
		noCache(response);
		HttpSession session=request.getSession();
		User user2 = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());   //获取session，根据用户id修改密码
		user.setId(user2.getId());
		sysmanageService.updPassword(user);
		
	}
	
	/***
	 * 检查登录
	 * @param request
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/checkLogin.action",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> checkLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		HttpSession session=request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
				
		if(user == null){
			return ResultUtils.success(0);
		}else {
			Yhkzxx yhkzxx = new Yhkzxx();
			yhkzxx.setUserId(user.getId());
			List<Yhkzxx> yhkzxxList = zyglService.schYhkzxx(yhkzxx);
			return ResultUtils.success((yhkzxxList==null || yhkzxxList.size() == 0)?yhkzxx.getJson():yhkzxxList.get(0).getJson());
		}
	}

	/**
	 * 弹出修改密码页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toUpdPass.action")
	public String toLogin(HttpServletRequest request,User user,HttpServletResponse response){
		return "portal/jsp/info";
	}

}
