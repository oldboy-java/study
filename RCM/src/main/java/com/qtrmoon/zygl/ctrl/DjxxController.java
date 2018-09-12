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
import org.springframework.web.bind.annotation.ResponseBody;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.Result;
import com.qtrmoon.common.ResultUtils;
import com.qtrmoon.zygl.pojo.Djxx;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 等级信息控制器
 */
@Controller
@RequestMapping("/zygl/djxx")
public class DjxxController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例

	/**
	 * 查询方法，自带分页设置。
	 * @param djxx 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/schDjxx.action")
	public void schDjxx(Djxx djxx,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		djxx.setCondition("");											//防sql注入
		djxx.assLike("djmc");

		List<Djxx> list=zyglService.schDjxx(djxx);		//调用Service查询数据
		/*将数据Bean的集合转换为Json集合*/
		JSONArray datas=new JSONArray();									//构造业务数据的JSON集合
		JSONObject obj;														//声明用于构造Bean的Json对象
		for(Djxx u:list){												//循环查询的数据集构造Json数据集
			obj=u.getJsonInDict();											//将Bean转换为Json对象
			obj.put("_oper",u.getId());								//为"操作列"设定主键值
			datas.add(obj);													//添加Json对象到Json集合
		}
		/*构造分页数据的JSON对象，并包装到返回页面的Json中*/
		JSONObject res=new JSONObject();									//声明页面返回Json
		res.put("total",djxx.getDatasize());							//设置数据总记录数
		res.put("rows", datas);												//设置数据集
		response.getWriter().print(res.toJSONString());						//输出到页面
	}
	
	/**
	 * 预添加or预修改or查看方法
	 * @param djxx 预添加时可传入一些初始值；预修改和查看时用来承载主键值
	 * @param toL 挂字典的字段是否需要转为字典Label值。true则进行转换
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/vieDjxx.action")
	public void vieDjxx(Djxx djxx,Boolean toL,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		if(toL!=null&&toL){													//查看页面加载数据时调用，返回的对象已进行字典转换
			if(djxx.getId()!=null&&djxx.getId()!=0){					//检测主键非空
				djxx=zyglService.schDjxxById(djxx.getId());			//按主键查询数据
				response.getWriter().print(djxx.getJsonInDict());						//输出经过字典转换Json对象到查看页(vie_)
			}
		}else{																//修改页面加载数据时调用
			if(djxx.getId()!=null&&djxx.getId()!=0){	//检查主键非空
				djxx=zyglService.schDjxxById(djxx.getId());		//按主键查询数据
				response.getWriter().print(djxx.getJson());			//输出Json对象到修改页(upd_)
			}else{															//添加页面加载数据时调用，可设置添加页面中一些属性的预设值。
				response.getWriter().print(new Djxx().getJson());		//输出Json对象到添加页(upd_)
			}
		}
	}
	
	/**
	 * 添加或修改的提交方法
	 * @param djxx 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updDjxx.action")
	public void updDjxx(Djxx djxx,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		if(djxx.getId()==null){									//检测主键为空则
			zyglService.addDjxx(djxx);						//添加数据
		}else{																//主键非空则
			zyglService.updDjxx(djxx);						//修改数据
		}
	}
	
	/**
	 * 删除方法
	 * @param ids 待删除数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/delDjxx.action")
	public void delDjxx(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);													//Ajax方法设定无缓存
		zyglService.delDjxx(ids);									//删除数据
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){										//放过本Ctrl的页面，不合法的跳转到error页。
		if("index".equals(page)||"djxx_sch".equals(page)||"djxx_vie".equals(page)||"djxx_upd".equals(page)){
			return "/zygl/"+page;
		}else{
			return "/error";
		}
	}
	
	
	/**
	 * 检测等级名称是否存在
	 * @param djmc 等级名称
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/checkDjmcExists.action")
	@ResponseBody
	public Result<?> checkDjmcExists(HttpServletResponse response,@RequestParam("djmc") String djmc,@RequestParam("id") Integer id) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		boolean exists = zyglService.isDjmcExists(djmc,id);
		return ResultUtils.success(exists);
	}
}
