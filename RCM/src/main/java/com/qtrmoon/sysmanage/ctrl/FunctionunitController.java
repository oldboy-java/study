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
import com.qtrmoon.sysmanage.pojo.Functionunit;
import com.qtrmoon.sysmanage.serdao.ISysmanageService;

@Controller
@RequestMapping("/sysmanage/functionunit")
public class FunctionunitController extends BaseController{
	@Autowired
	private ISysmanageService sysmanageService;

	@RequestMapping(value="/schFunctionunit.action")
	public void schFunctionunit(Functionunit functionunit,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		functionunit.setCondition("");//防sql注入
		List<Functionunit> list=null;
		list=sysmanageService.schFunctionunit(functionunit);
		JSONArray datas=new JSONArray();
		JSONObject obj;
		for(Functionunit u:list){
			obj=u.getJson();
			obj.put("_oper",u.getId());
			datas.add(obj);
		}
		JSONObject res=new JSONObject();
		res.put("total",functionunit.getDatasize());
		res.put("rows", datas);
		response.getWriter().print(res.toJSONString());
	}
	@RequestMapping(value="/updFunctionunit.action")
	public void updFunctionunit(Functionunit functionunit,String from,HttpServletResponse response) throws IOException{
		noCache(response);
		if("submit".equals(from)){
			if(functionunit.getId()==null){
				sysmanageService.addFunctionunit(functionunit);
			}else{
				sysmanageService.updFunctionunit(functionunit);
			}
		}else{
			if(functionunit.getId()!=null&&functionunit.getId()!=0){
				functionunit=sysmanageService.schFunctionunitById(functionunit.getId());
				response.getWriter().print(functionunit.getJson());
			}else{
				response.getWriter().print(new Functionunit().getJson());
			}
		}
	}
	@RequestMapping(value="/delFunctionunit.action")
	public void delFunctionunit(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);
		sysmanageService.delFunctionunit(ids);
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){
		if("index".equals(page)||"functionunit_sch".equals(page)||"functionunit_upd".equals(page)||"functionunit_vie".equals(page)){
			return "/sysmanage/"+page;
		}else{
			return "/error";
		}
	}
}
