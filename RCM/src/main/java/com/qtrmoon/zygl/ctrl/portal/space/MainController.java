package com.qtrmoon.zygl.ctrl.portal.space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Djxx;
import com.qtrmoon.zygl.pojo.Phsd;
import com.qtrmoon.zygl.pojo.Tzgg;
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.pojo.Yhkzxx;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.pojo.Zyll;
import com.qtrmoon.zygl.pojo.Zypl;
import com.qtrmoon.zygl.pojo.Zysc;
import com.qtrmoon.zygl.pojo.Zyxz;
import com.qtrmoon.zygl.serdao.IZyglService;
import com.qtrmoon.zygl.vo.ZyVo;


@Controller
@RequestMapping("portal/space/main")
public class MainController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	
	/**
	 * 查询个人中心的偏好、资源等方法，自带分页设置。
	 * @param zysc 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws Exception  
	 */
	@RequestMapping(value="/schPerCenter.action")
	public String schPerCenter(Phsd phsd,Zy zy,Zysc zysc,Zyll zyll,Zypl zypl,Tzgg tzgg,Zyxz zyxz,String option,HttpServletRequest request,HttpServletResponse response,Model model) throws  Exception{
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		if("1".equals(option)){    //我的偏好查询方法
			phsd.setYhid(user.getId());   //根据当前登录用户查询设置的偏好
			List<Phsd> list=zyglService.schPhsd(phsd);
			List<Xklb> xklbs=new ArrayList<Xklb>();
			if(list.size()>0){
				String[] phs=list.get(0).getZylxIds().split(",");
				if(phs.length>0){
					
					for(int i=0;i<phs.length;i++){
						xklbs.add(zyglService.schXklbById(Integer.parseInt(phs[i])));   //根据偏好id查询学科类别（偏好）并添加到用户设定为偏好的集合中
					}
				}
				Xklb xklb2=new Xklb();
				List<Xklb> xklb2s=zyglService.schXklbs(xklb2);   //查询所有偏好
				if(xklb2s.size()>phs.length){
					for (int i=xklb2s.size()-1;i>=0;i--) {
						for(int j=0;j<phs.length;j++){
							if(xklb2s.get(i).getId()==Integer.parseInt(phs[j])){     //如果所有学科类别（偏好）中的id和用户设置的学科类别（偏好）id相同，移除该学科类别（偏好）
								xklb2s.remove(i);
								break;
							}
						}
					}
					model.addAttribute("phs", xklb2s);    //未设置为偏好的集合
				}
			}
			model.addAttribute("option", option);
			model.addAttribute("myphs", xklbs);
		}else if("2".equals(option)){    //我的资源查询方法
			zy.setScrid(user.getId());
			zy.setPagesize(12);
			zy.addOrderDescCol("SCRQ");
			List<Zy> list=zyglService.schZy(zy);		//调用Service查询数据
			List<ZyVo> zyList2=new ArrayList<ZyVo>();
			if(list.size()>0){
				for (Zy zy2 : list) {
					ZyVo zyvo= new ZyVo();
					ConvertUtils.register(new DateConverter(null), java.util.Date.class); 
					BeanUtils.copyProperties(zyvo, zy2);
					if(zy2.getSsxkid()!=null){
						zyvo.setZyxk(DictBuffer.getLabel("ZD_XKLB", zy2.getSsxkid().toString()));  //替换字典值
					}
					if(zy2.getShzt()!=null){
						zyvo.setShjg(DictBuffer.getLabel("ZD_SHZT", zy2.getShzt().toString()));
					}
					zyList2.add(zyvo);
				}
			}
			model.addAttribute("option", option);
			model.addAttribute("myzys", zyList2);
			model.addAttribute("page", zy.getPage());
			model.addAttribute("totalPages", zy.getPageNum());
		}else if("3".equals(option)){    //我的收藏查询方法
			zysc.setScrid(user.getId());
			zysc.setPagesize(12);
			List<Zysc> zyscList=zyglService.schZyAndZysc(zysc);		//调用Service查询数据
			List<Zysc> zyscList2=new ArrayList<Zysc>();
			if(zyscList.size()>0){
				for (Zysc zysc2 : zyscList) {
					ZyVo zyvo= new ZyVo();
					ConvertUtils.register(new DateConverter(null), java.util.Date.class); 
					BeanUtils.copyProperties(zyvo, zysc2.getZy());
					if(zysc2.getZy().getSsxkid()!=null){
						zyvo.setZyxk(DictBuffer.getLabel("ZD_XKLB", zysc2.getZy().getSsxkid().toString()));//替换字典值
					}
					zysc2.setZy(zyvo);
					zyscList2.add(zysc2);
				}
			}
			model.addAttribute("option", option);
			model.addAttribute("myzysc", zyscList);
			model.addAttribute("page", zysc.getPage());
			model.addAttribute("totalPages", zysc.getPageNum());
		}else if("4".equals(option)){    //浏览记录查询方法
			zyll.setLlrid(user.getId().toString());
			zyll.setPagesize(12);
			List<Zyll> zyllList=zyglService.schZyAndZyll(zyll);		//调用Service查询数据
			List<Zyll> zyllList2=new ArrayList<Zyll>();
			if(zyllList.size()>0){
				for (Zyll zyll2 : zyllList) {
					ZyVo zyvo= new ZyVo();
					ConvertUtils.register(new DateConverter(null), java.util.Date.class); 
					BeanUtils.copyProperties(zyvo, zyll2.getZy());
					
					if(zyll2.getZy().getSsxkid()!=null){
						zyvo.setZyxk(DictBuffer.getLabel("ZD_XKLB", zyll2.getZy().getSsxkid().toString()));//替换字典值
					}
					zyll2.setZy(zyvo);
					zyllList2.add(zyll2);
				}
			}
			model.addAttribute("option", option);
			model.addAttribute("myzyll", zyllList2);
			model.addAttribute("page", zyll.getPage());
			model.addAttribute("totalPages", zyll.getPageNum());
		}else if("5".equals(option)){   //我的评论查询方法
			zypl.setPlrid(user.getId());
			List<Zypl> myzypl=zyglService.schZyAndZypl(zypl);		//调用Service查询数据
			model.addAttribute("option", option);
			model.addAttribute("myzypl", myzypl);
			model.addAttribute("page", zypl.getPage());
			model.addAttribute("totalPages", zypl.getPageNum());
		}else if("6".equals(option)){   //通知公告查询方法
			List<Tzgg> list=zyglService.schTzgg(tzgg);		//调用Service查询数据
			model.addAttribute("option", option);
			model.addAttribute("tzggs", list);
			model.addAttribute("page", tzgg.getPage());
			model.addAttribute("totalPages", tzgg.getPageNum());
		}else if("7".equals(option)){   //下载日志查询方法
			zyxz.setXzrid(user.getId().toString());
			List<Zyxz> mydowList=zyglService.schMyZyxz(zyxz);		//查询当前用户的下载日志
			model.addAttribute("option", option);
			model.addAttribute("page", zyxz.getPage());
			model.addAttribute("totalPages", zyxz.getPageNum());
			model.addAttribute("mydows", mydowList);
		}else if("8".equals(option)){
			Zyxz zyxz3=new Zyxz();
			Zy zy3=new Zy();
			zy3.setScrid(user.getId());
			zyxz3.setZy(zy3);
			List<Zyxz> dowsmyList=zyglService.schMyZyAndZyxz(zyxz3);
			model.addAttribute("option", option);
			model.addAttribute("page", zyxz3.getPage());
			model.addAttribute("totalPages", zyxz3.getPageNum());
			model.addAttribute("dowsmy", dowsmyList);
		}
		//获取我的积分
		Yhkzxx yhkzxx = new Yhkzxx();
		yhkzxx.setUserId(user.getId());
		List<Yhkzxx> yhkzxxList = zyglService.schYhkzxx(yhkzxx);
		int jf = (yhkzxxList==null || yhkzxxList.size()== 0)?0:yhkzxxList.get(0).getJf();
		model.addAttribute("jf",jf );
		
		//获取用户等级
		Djxx djxx = zyglService.schDjxxByJf(jf);
		model.addAttribute("djxx",djxx );
		
		//获取我的资源数量
		Zy z = new Zy();
		z.setScrid(user.getId());
		z.setCondition(" and shzt=2");
		List<Zy> zyList = zyglService.schZy(z);
		model.addAttribute("myZyList", zyList);
		return "portal/jsp/space/myCenter";
	}
	
	/**
	 * 删除方法
	 * @param ids 待删除数据的主键数组
	 * @param response 返回请求
	 */
	@RequestMapping(value="/delZysc.action")
	public void delZysc(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);													//Ajax方法设定无缓存
		zyglService.delZysc(ids);									//删除数据
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
	 * 未设置偏好的登录后要先设置偏好
	 * @param request
	 * @param pageSize
	 * @param zy
	 * @param model
	 */
	@RequestMapping(value="/phsd.action")
	public String phsd(HttpServletRequest request,HttpServletResponse response,@RequestParam(name="page",defaultValue="1") Integer page,Model model) throws IOException{
		Xklb xklb = new Xklb();
		xklb.setPagesize(12);
		xklb.setPage(page);
		
		List<Xklb> list=zyglService.schXklb(xklb);		//调用Service查询数据
		model.addAttribute("zylbList", list);
		return "portal/jsp/space/preference";
	
	
	}
	
	/**
	 * 设置偏好
	 * @param phsd 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/setPhsd.action")
	public void setPhsd(Phsd phsd,HttpServletResponse response,HttpServletRequest request,@RequestParam(name="xxid",defaultValue="1") String xxid) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		phsd.setYhid(user.getId());
		phsd.setXxid(xxid);
		if(phsd.getId()==null){									//检测主键为空则
			zyglService.addPhsd(phsd);						//添加数据
		}else{																//主键非空则
			zyglService.updPhsd(phsd);						//修改数据
		}
	}
	
	/**
	 * 用户id修改偏好的提交方法
	 * @param phsd 数据表单Bean
	 * @param response 返回请求
	 * @throws IOException
	 */
	@RequestMapping(value="/updPhsdByUser.action")
	public void updPhsdByUser(Phsd phsd,HttpServletResponse response,HttpServletRequest request) throws IOException{
		noCache(response);													//Ajax方法设定无缓存
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		phsd.setYhid(user.getId());
		zyglService.updPhsdByUser(phsd);
	}
	
	
	/**
	 * 查询单条通知公告内容。
	 * @param Tzgg 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping(value="/schTzggById.action")
	public String schTzggById(Tzgg tzgg,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		
		List<Tzgg> tzggNewList=zyglService.schNewTzgg();    //查询所有通知公告按照创建时间倒序
		if(tzggNewList.size()<7){                           //如果通知公告小于7条，添加所有
			model.addAttribute("tzggNewList", tzggNewList);
		}else{
			List<Tzgg> tzggs=new ArrayList<Tzgg>();       //如果大于7条，添加前六条
			int i=0;
			for (Tzgg tzgg2 : tzggNewList) {
				if(i<6){
					tzggs.add(tzgg2);
				}
				i++;
			}
			model.addAttribute("tzggNewList", tzggs);
		}
		Tzgg tzgg2=zyglService.schTzggById(tzgg.getId());     //根据id查询通知公告
		
		model.addAttribute("tzbt", tzgg2.getTzbt());
		model.addAttribute("cjsj", tzgg2.getCjsj());
		model.addAttribute("tznr", tzgg2.getTznr());
		return "portal/jsp/space/myNotice_details";
	}


	/**
	 * 资源类型
	 */
	@RequestMapping("/zylx.action")
	@ResponseBody
	@Override
	public JSONArray getZYLXList(HttpServletRequest request) {
		return super.getZYLXList(request);
	}
	
}
