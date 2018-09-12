package com.qtrmoon.zygl.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.zygl.pojo.Wzsz;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 网站设置控制器
 */
@Controller
@RequestMapping("/zygl/wzsz")
public class WzszController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例

	/**
	 * 预添加or预修改or查看方法
	 * @param wzsz 预添加时可传入一些初始值；预修改和查看时用来承载主键值
	 * @param toL 挂字典的字段是否需要转为字典Label值。true则进行转换
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/getWzsz.action")
	public void getWzsz(HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		List<Wzsz> wzszList = zyglService.schWzsz(new Wzsz());
		if(wzszList!=null && wzszList.size() > 0) {
			response.getWriter().print(wzszList.get(0).getJson());		//输出Json对象到添加页(upd_)
		}else{
			response.getWriter().print(new Wzsz().getJson());		//输出Json对象到添加页(upd_)
		}
	}
	
	/**
	 * 添加或修改的提交方法
	 * @param wzsz 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updWzsz.action")
	public void updWzsz(Wzsz wzsz,HttpServletResponse response) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		if(wzsz.getId()==null){									//检测主键为空则
			zyglService.addWzsz(wzsz);						//添加数据
		}else{																//主键非空则
			zyglService.updWzsz(wzsz);						//修改数据
		}
	}
	
		
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){										//放过本Ctrl的页面，不合法的跳转到error页。
		if("index".equals(page)||"wzsz_sch".equals(page)||"wzsz_vie".equals(page)||"wzsz_upd".equals(page)){
			return "/zygl/"+page;
		}else{
			return "/error";
		}
	}
}
