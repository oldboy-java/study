package com.qtrmoon.zygl.ctrl.portal.space;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.pojo.Zypl;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 资源评论表控制器
 */
@Controller
@RequestMapping("/portal/space/zypl")
public class ZyplWebController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例

	
	
	/**
	 * 添加或修改的提交方法
	 * @param zypl 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updZypl.action")
	public void updZypl(Zypl zypl,HttpServletResponse response,HttpServletRequest request) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		if(zypl.getId()==null){									//检测主键为空则
			Zy zy=zyglService.schZyById(zypl.getZyid());
			zypl.setPlrid(user.getId());
			zypl.setPlrxm(user.getUsername());
			zypl.setZymc(zy.getZymc());
			Date date=new Date();
			zypl.setPlsj(date);
			zyglService.addZypl(zypl);						//添加数据
			zyglService.updPlcs(zypl.getZyid());     //修改资源评论次数
		}else{																//主键非空则
			zyglService.updZypl(zypl);						//修改数据
		}
	}
	
	/**
	 * 回复评论提交方法
	 * @param zypl 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/replyZypl.action")
	public void replyZypl(Zypl zypl,HttpServletResponse response,HttpServletRequest request) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		if(zypl.getId()==null){									//检测主键为空则
			Zy zy=zyglService.schZyById(zypl.getZyid());
			zypl.setPlrid(user.getId());
			zypl.setPlrxm(user.getUsername());
			zypl.setZymc(zy.getZymc());
			Date date=new Date();
			zypl.setPlsj(date);
			zypl.setLx(2);
			zyglService.addZyplhf(zypl);						//添加数据
			zyglService.updPlcs(zypl.getZyid());     //修改资源评论次数
		}else{																//主键非空则
			zyglService.updZypl(zypl);						//修改数据
		}
	}
	
	
}
