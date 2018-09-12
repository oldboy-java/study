package com.qtrmoon.zygl.ctrl;

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
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 学科类别表控制器
 */
@Controller
@RequestMapping("/zygl/xklb")
public class XklbController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例

	/**
	 * 查询方法，自带分页设置。
	 * @param xklb 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/schXklb.action")
	public void schXklb(Xklb xklb,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		xklb.setCondition("");											//防sql注入
		xklb.assLike("xkmc","xxid");

		List<Xklb> list=zyglService.schXklb(xklb);		//调用Service查询数据
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for(Xklb u:list){												//循环查询的数据集构造Json数据集
			obj=u.getJsonInDict();											//将Bean转换为Json对象
			obj.put("_oper",u.getId());								//为"操作列"设定主键值
			datas.add(obj);													//添加Json对象到Json集合
		}
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",xklb.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面
	}
	
	/**
	 * 预添加or预修改or查看方法
	 * @param xklb 预添加时可传入一些初始值；预修改和查看时用来承载主键值
	 * @param toL 挂字典的字段是否需要转为字典Label值。true则进行转换
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/vieXklb.action")
	public void vieXklb(Xklb xklb,Boolean toL,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		if(toL!=null&&toL){													//查看页面加载数据时调用，返回的对象已进行字典转换
			if(xklb.getId()!=null&&xklb.getId()!=0){					//检测主键非空
				xklb=zyglService.schXklbById(xklb.getId());			//按主键查询数据
				response.getWriter().print(xklb.getJsonInDict());						//输出经过字典转换Json对象到查看页(vie_)
			}
		}else{																//修改页面加载数据时调用
			if(xklb.getId()!=null&&xklb.getId()!=0){	//检查主键非空
				xklb=zyglService.schXklbById(xklb.getId());		//按主键查询数据
				response.getWriter().print(xklb.getJson());			//输出Json对象到修改页(upd_)
			}else{															//添加页面加载数据时调用，可设置添加页面中一些属性的预设值。
				response.getWriter().print(new Xklb().getJson());		//输出Json对象到添加页(upd_)
			}
		}
	}
	
	/**
	 * 添加或修改的提交方法
	 * @param xklb 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updXklb.action")
	public void updXklb(Xklb xklb,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		Xklb xklb2=new Xklb();
		List<Xklb> xklbs=zyglService.schXklbs(xklb2);
		if(xklb.getId()==null){									//检测主键为空则
			if(xklbs.size()>0){
		        boolean b=false;
				for (Xklb xklb3 : xklbs) {
					if(xklb.getXkmc().equals(xklb3.getXkmc())){
						b=true;
					}
				}
				if(b==true){
					response.getWriter().print("该资源类型已存在！");
				}else{
					zyglService.addXklb(xklb);						//添加数据
				}
			}else{
				zyglService.addXklb(xklb);						//添加数据
			}
		}else{																//主键非空则
			Xklb xk=zyglService.schXklbById(xklb.getId());
			if(xklb.getXkmc().equals(xk.getXkmc())){
				zyglService.updXklb(xklb);						//修改数据
			}else{
				if(xklbs.size()>0){
					boolean b=false;
					for (Xklb xklb3 : xklbs) {
						if(xklb.getXkmc().equals(xklb3.getXkmc())){
							b=true;
						}
					}
					if(b==true){
						response.getWriter().print("该资源类型已存在！");
					}else{
						zyglService.updXklb(xklb);						//修改数据
					}
				}
			}
			
		}
		DictBuffer.updCache("ZD_XKLB");
	}
	
	/**
	 * 删除方法
	 * @param ids 待删除数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/delXklb.action")
	public void delXklb(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);													//Ajax方法设定无缓存
		zyglService.delXklb(ids);									//删除数据
		DictBuffer.updCache("ZD_XKLB");
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){										//放过本Ctrl的页面，不合法的跳转到error页。
		if("index".equals(page)||"xklb_sch".equals(page)||"xklb_vie".equals(page)||"xklb_upd".equals(page)){
			return "/zygl/"+page;
		}else{
			return "/error";
		}
	}
}
