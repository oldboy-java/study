package com.qtrmoon.zygl.ctrl.portal;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Phsd;
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;


@Controller
public class SoftWareController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例

	/**
	 * 按资源类别查询资源评论方法，自带分页设置。
	 * @param zysc 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping("/portal/schSoftware.action")
	public String schSoftware(Zy zy,String name,String type,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		Xklb xklb=new Xklb();
		if(!StringUtils.isEmpty(name)){                           //如果职位名称不为空的话
			name = URLDecoder.decode(name, "UTF-8");      //设置编码格式为utf-8
		}
		if(!StringUtils.isEmpty(zy.getZymc())){
			zy.setZymc(URLDecoder.decode(zy.getZymc(), "UTF-8"));//设置编码格式为utf-8
		}
		
		List<Xklb> xklbList=zyglService.schXklb(xklb);   //查询学科类别列表
		zy.assLike("zymc");
		zy.setPagesize(12);    //设置资源列表每页条数
		zy.setCondition(" and shzt=2 and zyzt=3");   //添加查询条件资源审核条件为审核通过并且是共享资源
		if(type!=null&&!"".equals(type)&&"hot".equals(type)){  //判断如果查询的是最热课程
			zy.addOrderDescCol("LLCS");   //查询条件添加根据浏览次数倒序
			List<Zy> zyList=zyglService.schZy(zy);  //查询资源列表
			model.addAttribute("xklbList", xklbList);  //model添加学科类别list
			model.addAttribute("zyList", zyList);   //model添加资源list
			model.addAttribute("name", name);  //model添加name（学科类别名称）
			model.addAttribute("page", zy.getPage());   //资源页数
			model.addAttribute("totalPages", zy.getPageNum());  //资源每页个数
		}else if(type!=null&&!"".equals(type)&&"news".equals(type)){  //判断如果查询的是最新课程
			zy.addOrderDescCol("SCRQ");   //查询条件添加根据上传日期倒序
			List<Zy> zyList=zyglService.schZy(zy);  //查询资源列表
			model.addAttribute("xklbList", xklbList);  //model添加学科类别list
			model.addAttribute("zyList", zyList);  //model添加资源list
			model.addAttribute("name", name);  //model添加name（学科类别名称）
			model.addAttribute("page", zy.getPage());  //资源页数
			model.addAttribute("totalPages", zy.getPageNum());  //资源每页个数
		}else{                                              //没有按照学科类别最新或最热查询
			List<Zy> zyList=zyglService.schZy(zy);   //查询资源列表
			model.addAttribute("xklbList", xklbList);    //model添加学科类别list
			model.addAttribute("zyList", zyList);    //model添加资源list
			model.addAttribute("name", name);   //model添加name（学科类别名称）
			model.addAttribute("page", zy.getPage());  //资源页数
			model.addAttribute("totalPages", zy.getPageNum());   //资源每页个数
		}
		HttpSession session = request.getSession();    
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());  //获取当前登录用户session
		Zy zy3=new Zy();   
		if(user==null){   //如果是未登录状态
			zy3.addOrderDescCol("SCRQ");   //查询条件添加上传日期倒序
			
			zy3.setPagesize(3);   //设置推荐课程资源条数
			zy3.setCondition(" and shzt=2 and zyzt=3");   //添加查询条件资源审核条件为审核通过并且是共享资源
			List<Zy> recommendZyList = zyglService.schZy(zy3);   //查询推荐课程资源
			model.addAttribute("recommendZyList", recommendZyList);   //model添加list
		}else{                                                      //如果用户已登录
			Phsd phsd=new Phsd();
			phsd.setYhid(user.getId());                          //根据用户id查询用户设定的偏好
			List<Phsd> list=zyglService.schPhsd(phsd);
			Phsd phsd2=list.get(0);
			String[] zylx=phsd2.getZylxIds().split(",");         //获取资源类型数组
			Zy zy2=new Zy();
			zy2.setPagesize(3);      //设置推荐课程资源条数           
			zy2.setCondition(" and shzt=2 and zyzt=3");    //添加查询条件资源审核条件为审核通过并且是共享资源
			List<Zy> zyLists=zyglService.schphZy(zylx,zy2);   //根据后台方法查询推荐课程资源
			if(zyLists.size()>0){                              //如果查询的结果集合大于0
				model.addAttribute("recommendZyList", zyLists);    //model添加集合
			}else{                                             //否则
				zy.addOrderDescCol("LLCS");                    //资源添加浏览次数倒序查询条件
				
				zy.setPagesize(3);                             //设置推荐课程资源条数
				List<Zy> recommendZyList = zyglService.schZy(zy);    //查询资源集合
				model.addAttribute("recommendZyList", recommendZyList);  //model添加集合
			}
			
		}
		Zy zytj=new Zy();
		zytj.addOrderDescCol("XZCS");	
		zytj.setPagesize(3);
		List<Zy> recommendZyList = zyglService.schZy(zytj);  //查询热门排行集合
		model.addAttribute("zyphList", recommendZyList);
		
		List<DictBean>  gslist =DictBuffer.getDictById("ZD_ZYGS", DictBuffer.dummyRootId).getChildren("ZD_ZYGS");
		model.addAttribute("gslist", gslist);
		zy.unAssignLike("zymc");
		return "portal/jsp/software";
	}

}
