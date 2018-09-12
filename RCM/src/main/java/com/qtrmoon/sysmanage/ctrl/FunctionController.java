package com.qtrmoon.sysmanage.ctrl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.sysmanage.pojo.Function;
import com.qtrmoon.sysmanage.serdao.ISysmanageService;
import com.qtrmoon.toolkit.DateTransfer;

@Controller
@RequestMapping("/sysmanage/function")
public class FunctionController extends BaseController{
	@Autowired
	private ISysmanageService sysmanageService;

	/**
	 * 查询方法，自带分页设置。
	 * @param function 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/schFunction.action")
	public void schFunction(Function function,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		function.setCondition("");//防sql注入
		List<Function> list=null;
		list=sysmanageService.schFunction(function);
		JSONArray datas=new JSONArray();
		JSONObject obj;
		for(Function u:list){
			obj=u.getJson();
			obj.put("_oper",u.getId());
			datas.add(obj);
		}
		JSONObject res=new JSONObject();
		res.put("total",function.getDatasize());
		res.put("rows", datas);
		response.getWriter().print(res.toJSONString());
	}
	
	/**
	 * 预添加or预修改or查看方法
	 * @param function 预添加时可传入一些初始值；预修改和查看时用来承载主键值
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/vieFunction.action")
	public void vieFunction(Function function,HttpServletResponse response) throws IOException{
		noCache(response);
		if(function.getId()!=null&&function.getId()!=0){//预修改
			function=sysmanageService.schFunctionById(function.getId());
			response.getWriter().print(function.getJson());
		}else{//预添加
			Function fun=new Function();
			fun.setPid(function.getPid());
			response.getWriter().print(fun.getJson());
		}
	}
	
	/**
	 * 添加或修改的提交方法
	 * @param function 数据表单Bean
	 * @param file
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/updFunction.action")
	public void updFunction(Function function,@RequestParam(value = "file", required = false) MultipartFile file,HttpServletResponse response) throws IOException{
		noCache(response);
		if(file!=null){
			String fname=DateTransfer.timeToId()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
			InputStream in=file.getInputStream();
			OutputStream out=new FileOutputStream("d:\\aa.jpg");
			IOUtils.copy(in, out, 1024);
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		if(function.getId()==null){
			sysmanageService.addFunction(function);
		}else{
			sysmanageService.updFunction(function);
		}
		DictBuffer.updCache("SYS_FUNCS_ALL");
		DictBuffer.updCache("SYS_FUNCS_MENU");
	}
	
	/**
	 * 删除方法
	 * @param ids 待删除数据的主键数组
	 * @param response
	 */
	@RequestMapping(value="/delFunction.action")
	public void delFunction(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);
		sysmanageService.delFunction(ids);
		DictBuffer.updCache("SYS_FUNCS_ALL");
		DictBuffer.updCache("SYS_FUNCS_MENU");
	}
	
	@RequestMapping(value="/dropFunction.action")
	public void dropFunction(String source,//源ID
											String target,//目标ID
											String point,//位置['append'、'top' 或 'bottom']
											HttpServletResponse response){
		noCache(response);
		if("append".equals(point)){
			Function sf=sysmanageService.schFunctionById(Integer.parseInt(source));
			sf.setPid(Integer.parseInt(target));
			sysmanageService.updFunction(sf);
		}else{
			Function sf=sysmanageService.schFunctionById(Integer.parseInt(source));
			Function tf=sysmanageService.schFunctionById(Integer.parseInt(target));
			sf.setPid(tf.getPid());
			if("top".equals(point)){
				sf.setOrd(tf.getOrd()-1);
			}else if("bottom".equals(point)){
				sf.setOrd(tf.getOrd()+1);
			}	
			sysmanageService.updFunction(sf);
		}
		DictBuffer.updCache("SYS_FUNCS_ALL");
		DictBuffer.updCache("SYS_FUNCS_MENU");
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){
		if("index".equals(page)||"function_sch".equals(page)||"function_upd".equals(page)){
			return "/sysmanage/"+page;
		}else{
			return "/error";
		}
	}
}
