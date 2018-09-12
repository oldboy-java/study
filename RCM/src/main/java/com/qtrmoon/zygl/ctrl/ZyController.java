package com.qtrmoon.zygl.ctrl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.upload.XFileUtils;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.Result;
import com.qtrmoon.common.ResultUtils;
import com.qtrmoon.common.event.PointEvent;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.service.FileConvertService;
import com.qtrmoon.service.VideoConvertService;
import com.qtrmoon.sysmanage.SysConstant;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Yhkzxx;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 资源表控制器
 */
@Controller
@RequestMapping("/zygl/zy")
public class ZyController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	@Autowired 
	private FileConvertService fileConvertService;
	@Autowired 
	private VideoConvertService videoConvertService;
	@Autowired
	private ApplicationContext ctx;
	
	@Value("${pointPerUpload}")
	private Integer pointPerUpload;
	
	/**
	 * 查询方法，自带分页设置。
	 * @param zy 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/schZy.action")
	public void schZy(Zy zy,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		zy.setCondition("");											//防sql注入
		zy.assLike("zymc","ssxkid","wjgs","scr","scrid","zyzt","zydz","zyly","zz","scrq","llcs","xzcs","sccs","plcs","xxid");

		List<Zy> list=zyglService.schZy(zy);		//调用Service查询数据	
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for(Zy u:list){												//循环查询的数据集构造Json数据集
			obj=u.getJsonInDict();											//将Bean转换为Json对象
			obj.put("_oper",u.getId());								//为"操作列"设定主键值
			datas.add(obj);													//添加Json对象到Json集合
		}
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",zy.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面
	}
	
	/**
	 * 查询方法，自带分页设置。
	 * @param zy 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/schZys.action")
	public void schZys(Zy zy,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		zy.setCondition("");											//防sql注入
		zy.assLike("zymc","ssxkid","wjgs","scr","scrid","zyzt","zydz","zyly","zz","scrq","llcs","xzcs","sccs","plcs","xxid");

		zy.addOrderDescCol("SCRQ");
		List<Zy> list=zyglService.schZy(zy);		//调用Service查询数据
		
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for(Zy u:list){												//循环查询的数据集构造Json数据集
			obj=u.getJsonInDict();											//将Bean转换为Json对象
			obj.put("_oper",u.getId());								//为"操作列"设定主键值
			datas.add(obj);													//添加Json对象到Json集合
		}
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",zy.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面
	}
	
	
	/**
	 * 未转换成功查询方法，自带分页设置。
	 * @param zy 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/schZyWjs.action")
	public void schZyWjs(Zy zy,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);										//防sql注入
		zy.assLike("zymc","ssxkid","wjgs","scr","scrid","zyzt","zydz","zyly","zz","scrq","llcs","xzcs","sccs","plcs","xxid");
		zy.setZhcg(0);
		zy.setCondition(" and wjgs!='MP4'");
		List<Zy> list=zyglService.schZy(zy);		//调用Service查询数据
		
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for(Zy u:list){												//循环查询的数据集构造Json数据集
			obj=u.getJsonInDict();											//将Bean转换为Json对象
			obj.put("_oper",u.getId());								//为"操作列"设定主键值
			datas.add(obj);													//添加Json对象到Json集合
		}
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",zy.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面
	}
	
	/**
	 * 统计资源审核
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/schZysh.action")
	public void schZysh(HttpServletRequest request,Zy zy,HttpServletResponse response,HttpSession session) throws IOException{
		noCache(response);
		List<Map<String, Object>> zyshList=zyglService.schZysh(zy);
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for (Map<String, Object> zyshs : zyshList) {                       //循环查询的数据集构造Json数据集
			obj=new JSONObject();                                              //将Bean转换为Json对象
			obj.put("ssxkid", DictBuffer.getLabel("ZD_XKLB", String.valueOf(zyshs.get("ssxkid")).toString()));
			obj.put("shzt", DictBuffer.getLabel("ZD_SHZT", String.valueOf(zyshs.get("shzt")).toString()));
			obj.put("amount", zyshs.get("amount"));
			datas.add(obj);                                                    //添加Json对象到Json集合
		}
		
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",zy.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面		
	}
	
	/**
	 * 按类型统计资源大小数量
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/schZydxsl.action")
	public void schZydxsl(HttpServletRequest request,Zy zy,HttpServletResponse response,HttpSession session) throws IOException{
		noCache(response);
		List<Map<String, Object>> zydxslList=zyglService.schZydxsl(zy);
		DecimalFormat df = new DecimalFormat("#,###");
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for (Map<String, Object> zydxsls : zydxslList) {                       //循环查询的数据集构造Json数据集
			obj=new JSONObject();                                              //将Bean转换为Json对象
			obj.put("ssxkid", DictBuffer.getLabel("ZD_XKLB", String.valueOf(zydxsls.get("ssxkid")).toString()));
			obj.put("amount", zydxsls.get("amount"));
			String s=df.format(Double.parseDouble(zydxsls.get("scale").toString()));
			obj.put("scale", s+"KB");
			datas.add(obj);                                                    //添加Json对象到Json集合
		}
		
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",zy.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面		
	}
	
	/**
	 * 按上传人统计资源大小数量
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/schScrZydxsl.action")
	public void schScrZydxsl(HttpServletRequest request,Zy zy,HttpServletResponse response,HttpSession session) throws IOException{
		noCache(response);
		zy.assLike("scr");
		List<Map<String, Object>> zydxslList=zyglService.schScrZydxsl(zy);
		DecimalFormat df = new DecimalFormat("#,###");
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for (Map<String, Object> scrzydxsls : zydxslList) {                       //循环查询的数据集构造Json数据集
			obj=new JSONObject();                                              //将Bean转换为Json对象
			obj.put("scr", scrzydxsls.get("scr"));
			obj.put("amount", scrzydxsls.get("amount"));
			String s=df.format(Double.parseDouble(scrzydxsls.get("scale").toString()));
			obj.put("scale", s+"KB");
			datas.add(obj);                                                    //添加Json对象到Json集合
		}
		
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",zy.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面		
	}
	
	/**
	 * 预添加or预修改or查看方法
	 * @param zy 预添加时可传入一些初始值；预修改和查看时用来承载主键值
	 * @param toL 挂字典的字段是否需要转为字典Label值。true则进行转换
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/vieZy.action")
	public void vieZy(Zy zy,Boolean toL,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		if(toL!=null&&toL){													//查看页面加载数据时调用，返回的对象已进行字典转换
			if(zy.getId()!=null&&zy.getId()!=0){					//检测主键非空
				zy=zyglService.schZyById(zy.getId());			//按主键查询数据
				response.getWriter().print(zy.getJsonInDict());						//输出经过字典转换Json对象到查看页(vie_)
			}
		}else{																//修改页面加载数据时调用
			if(zy.getId()!=null&&zy.getId()!=0){	//检查主键非空
				zy=zyglService.schZyById(zy.getId());		//按主键查询数据
				response.getWriter().print(zy.getJson());			//输出Json对象到修改页(upd_)
			}else{															//添加页面加载数据时调用，可设置添加页面中一些属性的预设值。
				response.getWriter().print(new Zy().getJson());		//输出Json对象到添加页(upd_)
			}
		}
	}
	
	/**
	 * 添加或修改的提交方法
	 * @param zy 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updZy.action")
	public void updZy(Zy zy,HttpServletResponse response,HttpServletRequest request) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		User user = (User)request.getSession(true).getAttribute(SysConstant.CURRENT_USER);
		zy.setScrid(user.getId());
		if(zy.getId()==null){									//检测主键为空则
			zyglService.addZy(zy);						//添加数据
		}else{																//主键非空则
			zyglService.updZy(zy);						//修改数据
		}
	}
	
	/**
	 * 删除方法
	 * @param ids 待删除数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/delZy.action")
	public void delZy(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);													//Ajax方法设定无缓存
		zyglService.delZy(ids);									//删除数据
	}
	
	/**
	 * 批量审核通过方法
	 * @param ids 待审核数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/shZysTg.action")
	public void shZysTg(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response,HttpServletRequest request){
		noCache(response);													//Ajax方法设定无缓存
		zyglService.shZysTg(ids);;		
		if(ids!=null && ids.length >0){
			for(int i = 0;i < ids.length;i++){
				Zy zy = zyglService.schZyById(ids[i]);
				Yhkzxx yhkzxx = new Yhkzxx();
				yhkzxx.setUserId(zy.getScrid());
				yhkzxx.setJf(pointPerUpload);
				ctx.publishEvent(new PointEvent(yhkzxx));
			}
		}
	}
	
	/**
	 * 批量审核不通过方法
	 * @param ids 待审核数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/shZysBtg.action")
	public void shZysBtg(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);													//Ajax方法设定无缓存
		zyglService.shZysBtg(ids);;									
	}
	
	/**
	 * 资源下载
	 * @param response 返回请求
	 * @throws IOException 
	 */
    @RequestMapping(value="/download.action")
	public void download(Zy zy,HttpServletResponse response,HttpServletRequest request)throws IOException {
    	zy =zyglService.schZyById(zy.getId());
    	zyglService.updXzcs(zy.getId());
    	XFileUtils.download(response, request, zy.getZydz(), zy.getWjmc(), "application/octet-stream");
	}
    
    
    /**
	 * 在线预览格式转换方法
	 * @param ids 待审核数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/previewzy.action")
	public String previewzy(Zy zy,HttpServletResponse response,Model model,HttpSession session,HttpServletRequest request) throws Exception{
		zy = zyglService.schZyById(zy.getId());
		model.addAttribute("zy", zy);
		return "/zygl/zy_detail";
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){										//放过本Ctrl的页面，不合法的跳转到error页。
		if("index".equals(page)||"zywj_sch".equals(page)||"zy_sch".equals(page)||"zy_vie".equals(page)||"zy_upd".equals(page)||"zy_tj_sch".equals(page)||"zy_shtj_sch".equals(page)||"zy_dxsltj_sch".equals(page)||"zy_scrdxsltj_sch".equals(page)){
			return "/zygl/"+page;
		}else{
			return "/error";
		}
	}
	
	/***
	 * 更新资源下载权限
	 * @param zyIds 资源ID数组
	 * @param auth 权限
	 * @param response
	 * @param jf 下载积分
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/updateZyDownloadAuth.action")
	public Result<?> updateZyDownloadAuth(@RequestParam("zyIds[]") Integer[] zyIds,@RequestParam("auth") Integer auth,@RequestParam("jf") Integer jf,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
	    zyglService.updateZyDownloadAuth(zyIds,auth,jf);		//调用服务
		return ResultUtils.success();//返回结果
	}
	
	
	/**
	 * 手动文件转换方法
	 * @param response 返回请求
	 */
	@ResponseBody
	@RequestMapping(value="/wjzhByManual.action")
	public boolean wjzhByManual(String zydz,HttpServletResponse response){
		return fileConvertService.convertResourceByManual(zydz);
	}
	
	/**
	 * 手动视频转换方法
	 * @param response 返回请求
	 */
	@ResponseBody
	@RequestMapping(value="/videoWjzhByManual.action")
	public boolean videoWjzhByManual(String zydz,HttpServletResponse response){
		return videoConvertService.convertVideoResourceByManual(zydz);
	}
}
