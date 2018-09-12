package com.qtrmoon.zygl.ctrl.portal;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.Result;
import com.qtrmoon.common.ResultUtils;
import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Phsd;
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 偏好设定控制器
 */
@Controller
@RequestMapping("/portal/zygl/phsd")
public class PhsdController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	
	/**
	 * 设置偏好
	 * @param phsd 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/setPhsd.action")
	public void setPhsd(Phsd phsd,HttpServletResponse response,HttpServletRequest request) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		phsd.setYhid(user.getId());
		if(phsd.getId()==null){									//检测主键为空则
			zyglService.addPhsd(phsd);						//添加数据
		}else{																//主键非空则
			zyglService.updPhsd(phsd);						//修改数据
		}
	}
	
	/**
	 * 添加或修改的提交方法
	 * @param phsd 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updPhsd.action")
	public void updPhsd(Phsd phsd,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		if(phsd.getId()==null){									//检测主键为空则
			zyglService.addPhsd(phsd);						//添加数据
		}else{																//主键非空则
			zyglService.updPhsd(phsd);						//修改数据
		}
	}
	
	/**
	 * 用户id修改偏好的提交方法
	 * @param phsd 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updPhsdByUser.action")
	public void updPhsdByUser(Phsd phsd,HttpServletResponse response,HttpServletRequest request) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		phsd.setYhid(user.getId());
		zyglService.updPhsdByUser(phsd);
	}
	
	
	/***
	 *   偏好设定-资源类型列表（ 换一换）
	 *   @return
	 */
	@RequestMapping("/getResourceTypeList.action")
	@ResponseBody
	public Result<?> getResourceTypeList(@RequestParam(name="xxid",defaultValue="1") String xxid,HttpServletResponse response,@RequestParam(name="page",defaultValue="1") Integer page)throws IOException{
		Xklb xklb = new Xklb();
		xklb.setXxid(xxid);
		xklb.setPagesize(12);
		xklb.setPage(page);
		
		List<Xklb> list=zyglService.schXklb(xklb);		//调用Service查询数据
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for(Xklb u:list){												//循环查询的数据集构造Json数据集
			obj=u.getJsonInDict();											//将Bean转换为Json对象
			datas.add(obj);													//添加Json对象到Json集合
		}
		
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",xklb.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		return ResultUtils.success(res);					//输出到页面
	}
}
