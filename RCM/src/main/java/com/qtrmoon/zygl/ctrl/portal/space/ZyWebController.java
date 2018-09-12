package com.qtrmoon.zygl.ctrl.portal.space;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;


@Controller
@RequestMapping("portal/space/zy")
public class ZyWebController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	
	@Autowired  
    private ApplicationContext applicationContext; 
	
	
	/**
	 * 添加或修改的提交方法
	 * @param zy 数据表单Bean
	 * @param response 返回请求
	 * @throws Exception 
	 */
	@RequestMapping(value="/updZy.action")
	@ResponseBody
	public Result<?> updZy(Zy zy,HttpServletResponse response,HttpServletRequest request) throws Exception{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		//先判断id是是否为空，确定是增加还是修改操作；在进行判断路径是否存在，确定是否需要先上传
		zy.setScrid(user.getId());
		zy.setScr(user.getUsername());
		zy.setScrq(new Date());
		zy.setWjgs(zy.getHzm().substring(1).toUpperCase());
		zy.setZydx(getPrintSize(zy.getWjdx()));
		if(zy.getId()==null){
			//添加，不存在删除在xm中资质文件附件id删除的情况
			return ResultUtils.success(zyglService.addZy(zy));								
		}else{
			return ResultUtils.success(zyglService.updZy(zy));
		}
	}
	
	/**
	 * 设置文件大小
	 */
	private  String getPrintSize(String size) {  
        String value = size.substring(size.length()-2, size.length());  // 截取字符串后两位看文件大小是以什么单位结尾
        if ("GB".equals(value)) {  
            return String.valueOf(Double.parseDouble(size.substring(0, size.length()-2))*1024*1024);  
        } else  if("MB".equals(value)){  
        	return String.valueOf(Double.parseDouble(size.substring(0, size.length()-2))*1024);  
        } else if("KB".equals(value)){
        	return String.valueOf(Double.parseDouble(size.substring(0, size.length()-2)));
        }else{
        	return String.valueOf(Double.parseDouble(size.substring(0, size.length()-2))/1024);
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
	
	
	/***
	 * 打开资源添加页面
	 * @param request
	 * @param response
	 * @param model
	 * @param zyId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/addResourcePage.action")
	public String addResourcePage(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(name="zyId",defaultValue="0") int zyId) throws IOException{
		List<Xklb> list=zyglService.schXklbs(new Xklb());		//调用Service查询数据
		model.addAttribute("xklbs", list);
		
		Zy zy = zyglService.schZyById(zyId);
		model.addAttribute("zy", zy);
		return "portal/jsp/space/resource_add";
	}
}
