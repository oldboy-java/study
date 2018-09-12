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
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.sysmanage.pojo.Role;
import com.qtrmoon.sysmanage.serdao.ISysmanageService;

@Controller
@RequestMapping("/sysmanage/role")
public class RoleController extends BaseController{
	@Autowired
	private ISysmanageService sysmanageService;

	@RequestMapping(value="/schRole.action")
	public void schRole(Role role,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		role.setCondition("");//防sql注入
		List<Role> list=null;
		list=sysmanageService.schRole(role);
		JSONArray datas=new JSONArray();
		JSONObject obj;
		for(Role u:list){
			obj=u.getJson();
			obj.put("_oper",u.getId());
			datas.add(obj);
		}
		JSONObject res=new JSONObject();
		res.put("total",role.getDatasize());
		res.put("rows", datas);
		response.getWriter().print(res.toJSONString());
	}
	@RequestMapping(value="/updRole.action")
	public void updRole(Role role,String from,HttpServletResponse response) throws IOException{
		noCache(response);
		if("submit".equals(from)){
			if(role.getId()==null){
				sysmanageService.addRole(role);
			}else{
				sysmanageService.updRole(role);
			}
			DictBuffer.updCache("SYS_ROLE");//刷新角色字典
		}else{
			if(role.getId()!=null&&role.getId()!=0){
				role=sysmanageService.schRoleById(role.getId());
				response.getWriter().print(role.getJson());
			}else{
				response.getWriter().print(new Role().getJson());
			}
		}
	}
	@RequestMapping(value="/delRole.action")
	public void delRole(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);
		sysmanageService.delRole(ids);
		DictBuffer.updCache("SYS_ROLE");//刷新角色字典
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){
		if("index".equals(page)||"role_sch".equals(page)||"role_upd".equals(page)||"role_vie".equals(page)){
			return "/sysmanage/"+page;
		}else{
			return "/error";
		}
	}
	
}
