package com.qtrmoon.sysmanage.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.sysmanage.pojo.Function;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.sysmanage.serdao.ISysmanageService;

@Controller
@RequestMapping("/sysmanage/user")
public class UserController extends BaseController{
	@Autowired
	private ISysmanageService sysmanageService;

	@RequestMapping(value="/schUser.action")
	public void schUser(User user,String organids,HttpServletResponse response) throws IOException{
		noCache(response);
		user.setCondition("");//防sql注入
		user.assLike("username");
		if(organids!=null&&organids.indexOf(",")>0){
			String sql="";
			String[] orgs=organids.split(",");
			for(String org:orgs){
				sql+="organid='"+org+"' or ";
			}
			sql=sql.substring(0,sql.length()-3);
			user.setOrganid(null);
			user.setCondition(" and("+sql+")");
		}else if(organids!=null&&!organids.equals("")){
			user.setOrganid(Integer.parseInt(organids));
		}
		List<User> list=null;
		list=sysmanageService.schUser(user);
		JSONArray datas=new JSONArray();
		JSONObject obj;
		for(User u:list){
			obj=u.getJsonInDict();
			obj.put("_oper",u.getId());
			datas.add(obj);
		}
		JSONObject res=new JSONObject();
		res.put("total",user.getDatasize());
		res.put("rows", datas);
		response.getWriter().print(res.toJSONString());
	}
	
	/**
	 * 预添加or预修改or查看方法
	 * @param user 预添加时可传入一些初始值；预修改和查看时用来承载主键值
	 * @param toL 挂字典的字段是否需要转为字典Label值。true则进行转换
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/vieUser.action")
	public void vieUser(User user,Boolean toL,HttpServletResponse response) throws IOException{
		noCache(response);
		if(toL!=null&&toL){//查看，转字典
			if(user.getId()!=null&&user.getId()!=0){
				user=sysmanageService.schUserById(user.getId());
				response.getWriter().print(user.getJsonInDict());
			}
		}else{
			if(user.getId()!=null&&user.getId()!=0){//预修改
				user=sysmanageService.schUserById(user.getId());
				response.getWriter().print(user.getJson());
			}else{//预添加
				User newUser=new User();
				newUser.setOrganid(user.getOrganid());
				response.getWriter().print(newUser.getJson());
			}
		}
	}
	
	@RequestMapping(value="/updUser.action")
	public void updUser(User user,String from,HttpServletResponse response) throws IOException{
		noCache(response);
		if(user.getId()==null){
			sysmanageService.addUser(user);
		}else{
			sysmanageService.updUser(user);
		}
	}
	
	@RequestMapping(value="/delUser.action")
	public void delUser(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);
		sysmanageService.delUser(ids);
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){
		if("index".equals(page)||"user_sch".equals(page)||"user_upd".equals(page)||"user_vie".equals(page)){
			return "/sysmanage/"+page;
		}else{
			return "/error";
		}
	}
}
