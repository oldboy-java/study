package com.qtrmoon.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;


public class BaseController {
	
	protected PageForm setPage(HttpServletRequest request,Class<?> cla) {
		PageForm form=null;
		try {
			HttpSession session=request.getSession();
			Object o=session.getAttribute(cla.getName());
			if(o==null){
				form=(PageForm)cla.newInstance();
				session.setAttribute(cla.getName(),form);
			}else{
				form=(PageForm)o;
			}
			String currentPage=request.getParameter("page");
			if (currentPage != null && !currentPage.equals("")) {
				form.setPage(Integer.parseInt(currentPage));
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return form;
	}
	
	public void noCache(HttpServletResponse response){
		response.setHeader("Cache-Control", "no-cache,must-revalidate");
	}
	
	/***
	 * 返回资源类型列表
	 * @param request
	 * @return
	 */
	public  JSONArray getZYLXList(HttpServletRequest request){
		 List<DictBean>  list =DictBuffer.getDictById("ZD_XKLB", DictBuffer.dummyRootId).getChildren("ZD_XKLB"); 
		 JSONArray xls=new JSONArray();								//构造业务数据的JSON集合
			for(DictBean u:list){											//循环查询的数据集构造Json数据集
				JSONObject obj = new JSONObject();
				obj.put("id", u.getId());						             //将Bean转换为Json对象
				obj.put("pid", u.getPid());
				obj.put("label", u.getLabel());
				xls.add(obj);												//添加Json对象到Json集合
			}
		return xls;
	}
	
	/***
	 * 返回资源格式列表
	 * @param request
	 * @return
	 */
	public  JSONArray getZYGSList(HttpServletRequest request){
		 List<DictBean>  list =DictBuffer.getDictById("ZD_ZYGS", DictBuffer.dummyRootId).getChildren("ZD_ZYGS"); 
		 JSONArray xls=new JSONArray();								//构造业务数据的JSON集合
			for(DictBean u:list){											//循环查询的数据集构造Json数据集
				JSONObject obj = new JSONObject();
				obj.put("id", u.getId());						             //将Bean转换为Json对象
				obj.put("pid", u.getPid());
				obj.put("label", u.getLabel());
				xls.add(obj);												//添加Json对象到Json集合
			}
		return xls;
	}
}
