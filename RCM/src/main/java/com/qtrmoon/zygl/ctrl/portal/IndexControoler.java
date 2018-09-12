package com.qtrmoon.zygl.ctrl.portal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Phsd;
import com.qtrmoon.zygl.pojo.Wzsz;
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;


/***
 * 
 * 教学资源门户首页
 */
@Controller
public class IndexControoler {

	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	
	
	/***
	 * 资源门户首页
	 * @param request
	 * @param pageSize
	 * @param zy
	 * @param model
	 */
	@RequestMapping("/portal/index.action")
	public String index(HttpServletRequest request,Zy zy,Model model){
		zy.setCondition(" and shzt=2 and zyzt=3");    //设置资源查询条件，审核状态为通过，资源状态为共享
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());       //获取session
		if(user==null){                            //如果用户未登录
			zy.addOrderDescCol("LLCS");            //添加上传日期倒序查询条件
			
			zy.setPagesize(4);  //设置每页条数
			List<Zy> recommendZyList = zyglService.schZy(zy);           //推荐资源集合    
			model.addAttribute("recommendZyList", recommendZyList);          
		}else{                                        //如果用户登录
			Phsd phsd=new Phsd();               
			phsd.setYhid(user.getId());              //查询用户偏好，根据用户偏好查询推荐资源集合
			List<Phsd> list=zyglService.schPhsd(phsd);
			Phsd phsd2=list.get(0);
			String[] zylx=phsd2.getZylxIds().split(",");
			Zy zy2=new Zy();
			zy2.setPagesize(4);
			zy2.setCondition(" and shzt=2 and zyzt=3");
			List<Zy> zyList=zyglService.schphZy(zylx,zy2);

			if(zyList.size()>0&&zyList.size()>=4){
				model.addAttribute("recommendZyList", zyList);   //当按照用户偏好查询的集合长度大于等于4时，直接添加到model
			}else if(zyList.size()>0&&zyList.size()<4){      //当按照用户偏好查询的集合长度小于4时
                zy.addOrderDescCol("LLCS");                       //根据浏览次数查询推荐资源
				zy.setPagesize(4-zyList.size());             //设置查询的数量为4减去按照用户偏好查询的集合长度
				List<Zy> recommendZyList = zyglService.schZy(zy);  
				zyList.addAll(recommendZyList);              
				model.addAttribute("recommendZyList", zyList);
			}else{                                                //如果用户偏好没有资源
				zy.addOrderDescCol("LLCS");                       //根据浏览次数查询推荐资源
				
				zy.setPagesize(4);
				List<Zy> recommendZyList = zyglService.schZy(zy); 
				model.addAttribute("recommendZyList", recommendZyList);
			}
			
		}
		Zy rmzy=new Zy();
		rmzy.setCondition(" and shzt=2 and zyzt=3");    //设置资源查询条件，审核状态为通过，资源状态为共享
		rmzy.addOrderDescCol("XZCS");                  //根据资源下载次数查询热门资源
		
		rmzy.setPagesize(4);
		List<Zy> rmzyList = zyglService.schZy(rmzy); 
		model.addAttribute("rmzyList", rmzyList);
		
		
		Xklb xklb=new Xklb();                              //查询学科类别集合
		List<Xklb> xklbList=zyglService.schXklb(xklb);
		model.addAttribute("xklbSize", xklbList.size());
		if(xklbList.size()<=9){
			model.addAttribute("xklbList", xklbList);
		}else{
			List<Xklb> xklbList2=new ArrayList<Xklb>();
			List<Xklb> xklbMoreList=new ArrayList<Xklb>();
			int i=1;
			for (Xklb xklb2 : xklbList) {
				if(i<9){
					xklbList2.add(xklb2);
				}else{
					xklbMoreList.add(xklb2);
				}
				i++;
			}
			model.addAttribute("xklbList2", xklbList2);
			model.addAttribute("xklbMoreList", xklbMoreList);
		}
		
		Zy zxzy=new Zy();
		zxzy.setCondition(" and shzt=2 and zyzt=3");
		zxzy.addOrderDescCol("ID");
		List<Zy> zxZyList = zyglService.schZys(zxzy);      //根据最新资源集合,最多8条
		if(zxZyList.size()<8){
			model.addAttribute("zxZyList", zxZyList);
		}else{
			List<Zy> zxZys=new ArrayList<Zy>();
			for (Zy zxzy2 : zxZyList) {
				if(zxZys.size()<8){
					zxZys.add(zxzy2);
				}
			}
			model.addAttribute("zxZyList", zxZys);
		}
		
		List<Map<String, Object>> scphList = zyglService.schScph();   //调用查询方法查询上传排行集合,最多8条
		if(scphList.size()<8){
			model.addAttribute("scphList", scphList);
		}else{
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> map : scphList) {
				if(list.size()<8){
					list.add(map);
				}
			}
			model.addAttribute("scphList", list);
		}
		Wzsz wzsz=new Wzsz();
		List<Wzsz> wz=zyglService.schWzsz(wzsz);
		if(wz.get(0).getMb()==1){
			return "portal/jsp/index";
		}else if(wz.get(0).getMb()==2){
			return "portal/jsp/index_02";
		}
		return null;
	}
}
