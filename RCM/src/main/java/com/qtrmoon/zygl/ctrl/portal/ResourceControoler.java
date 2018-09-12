package com.qtrmoon.zygl.ctrl.portal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tk.upload.XFileUtils;

import com.qtrmoon.common.PageSizeEnum;
import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.common.event.DownloadHistoryEvent;
import com.qtrmoon.common.event.PointEvent;
import com.qtrmoon.common.event.ViewHistoryEvent;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.zygl.pojo.Yhkzxx;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.pojo.Zydz;
import com.qtrmoon.zygl.pojo.Zyll;
import com.qtrmoon.zygl.pojo.Zypl;
import com.qtrmoon.zygl.pojo.Zysc;
import com.qtrmoon.zygl.pojo.Zyxz;
import com.qtrmoon.zygl.serdao.IZyglService;
import com.qtrmoon.zygl.vo.ZyVo;


/***
 * 
 * 资源控制器
 */
@Controller
@RequestMapping("/portal/zygl/resource")
public class ResourceControoler {

	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	
	@Autowired  
    private ApplicationContext applicationContext; 
	
	@Value("${rrs_host}")
	private String rrsHost; //#resource read server host
	
	@Value("${zyPath}")
	private String zyPath; //资源二级路径
	
	
	@Value("${basicPath}")
	private String basicPath;//资源基路径
	/***
	 * 资源搜索
	 * @param request
	 * @param pageSize
	 * @param zy
	 * @param model
	 * @param q 检索类型  0 分类检索  1 关键词检索
	 *//*
	@RequestMapping("/search.action")
	public void search(HttpServletRequest request,Zy zy,Model model,@RequestParam(name="q",defaultValue="0") Integer q){
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		
		//资源检索
		zy.setPagesize(PageSizeEnum.SEARCH_PAGESIZE.getCount());
		List<Zy> zyList = zyglService.schZy(zy); 
		model.addAttribute("zyList", zyList);
		
		//推荐资源
		Zy recommendZy = new Zy();
		recommendZy.setPagesize(PageSizeEnum.RECOMMEND_PAGESIZE.getCount());
		recommendZy.addOrderDescCol("LLCS");
		List<Zy> recommendZyList = zyglService.schZy(recommendZy); 
		model.addAttribute("recommendZyList", recommendZyList);
		
		
		//猜喜欢的资源
		Zy likeZy = new Zy();
		likeZy.setPagesize(PageSizeEnum.RECOMMEND_PAGESIZE.getCount());
		
		//TODO
		user =new User();
		user.setId(1);
		if(user!=null){
			Phsd phsd = zyglService.schPhsdByUserId(user.getId());
			likeZy.setCondition(" AND SSXKID in ( "+phsd.getZylxIds()+")");
		}
		List<Zy> likeZyList = zyglService.schZy(likeZy); 
		model.addAttribute("likeZyList", likeZyList);
		
		if(q == 0){
			// 跳转按分类检索页面
		}else{
			//跳转按关键词检索页面
		}
	}*/
	
	
	
	
	/***
	 * 资源详情
	 * @param request
	 * @param model
	 * @param zyId 资源ID
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("/detail.action")
	public String detail(HttpServletRequest request,Model model,@RequestParam(name="zyId",defaultValue="0") Integer zyId) throws  Exception{
		//更新浏览次数
		zyglService.updLlcs(zyId);
		Zypl zypl=new Zypl();
		zypl.setZyid(zyId);
		
		Zy zy = zyglService.schZyById(zyId);
		ZyVo zyvo= new ZyVo();
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);  
		BeanUtils.copyProperties(zyvo, zy);
		
		//资源类型选项
		zyvo.setZyxk(DictBuffer.getLabel("ZD_XKLB", zy.getSsxkid().toString()));
		model.addAttribute("zy", zyvo);
		
		//评论
		List<Zypl> zyplList=zyglService.schZypls(zypl);	
		List<Zypl> moreList=new ArrayList<Zypl>();
		List<Zypl> plList=new ArrayList<Zypl>();
		if(zyplList.size()<6){
			model.addAttribute("zyplList", zyplList);
			model.addAttribute("moreList", moreList);
		}else{
			for(int i=0;i<zyplList.size();i++){
				if(i<6){
					plList.add(zyplList.get(i));
					continue;
				}
				moreList.add(zyplList.get(i));
			}
			model.addAttribute("zyplList", plList);
			model.addAttribute("moreList", moreList);
		}
		
		//大家关注的资源
		Zy followZy = new Zy();
		followZy.setPagesize(PageSizeEnum.FOLLOWED_PAGESIZE.getCount());
		followZy.addOrderDescCol("sccs");
		followZy.setCondition(" and zyzt=3 and shzt=2 ");
		List<Zy> followZyList = zyglService.schZy(followZy); 
		model.addAttribute("followZyList", followZyList);
			
		//相关资源
		List<Zy> relatedZyList = zyglService.getRelatedZy(zy.getSsxkid());
		model.addAttribute("relatedZyList", relatedZyList);
		
		//收藏状态
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		Zysc zysc = new Zysc();
		zysc.setScrid(user==null?0:user.getId());
		zysc.setZyid(zy.getId());
		List<Zysc> favList = zyglService.schZysc(zysc); 
		model.addAttribute("isFav", user==null?false:favList==null?false:favList.size() >0 ? true:false) ;
		
		//点赞状态
		Zydz zydz = new Zydz();
		zydz.setDzrid(user==null?0:user.getId());
		zydz.setZyid(zy.getId());
		List<Zydz> likeList = zyglService.schZydz(zydz); 
		model.addAttribute("isLike", user==null?false:likeList==null?false:likeList.size() >0 ? true:false) ;
		
		//发布资源浏览事件
		if(user!=null){
			Zyll zyll = new Zyll();
			zyll.setZyid(zy.getId()+"");
			zyll.setLlrid(user.getId()+"");
			zyll.setLlsj(new Date());
			applicationContext.publishEvent(new ViewHistoryEvent(zyll));
		}
		//设置资源观看服务器host
		model.addAttribute("rrsHost", rrsHost);
		return "portal/jsp/zy_detail";
	}
	
	/**
	 * 获取Pdf
	 * @param filename
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getPdf.action")
	public void getPdf(String filename,HttpServletRequest request,HttpServletResponse response){
		filename = filename.substring(0, filename.lastIndexOf(".")).concat(".pdf");
		if(filename != null){
			try{
				File file = new File(filename);
				if(file.exists()){
					IOUtils.copy(new FileInputStream(filename), response.getOutputStream());
				}else{
					System.out.println("文件不存在！不产生数据流输出到前台页面。缺失文件及路径为："+filename);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取Pdf
	 * @param filename
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getPdfStream/{filename}.action")
	public void getPdfStream(@PathVariable("filename")String filename,HttpServletRequest request,HttpServletResponse response){
		filename= basicPath.concat(zyPath).concat(filename);
		if(filename != null){
			try{
				File file = new File(filename);
				if(file.exists()){
					IOUtils.copy(new FileInputStream(filename), response.getOutputStream());
				}else{
					System.out.println("文件不存在！不产生数据流输出到前台页面。缺失文件及路径为："+filename);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 资源收藏
	 * @param zy
	 * @param fav  1收藏  0取消收藏
	 * @param response 返回请求
	 */
	@RequestMapping(value="/collectzy.action")
	public void collectzy(Zy zy,HttpServletResponse response,HttpServletRequest request,@RequestParam(name="fav",defaultValue="1")Integer fav){	
		HttpSession session = request.getSession();
		//获取用户
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		//更新资源收藏次数
		zyglService.updSccs(zy.getId(),fav==1?1:-1);
		//如果是收藏操作
		if(fav==1){
			//构造收藏对象
			Zysc zysc=new Zysc();
			zysc.setZyid(zy.getId());
			zysc.setScrid(user.getId());
			Date date=new Date();
			zysc.setScsj(date);
			zyglService.addZysc(zysc); //增加收藏记录
		}else{//如果是取消收藏操作执行收藏取消
			zyglService.delZyscByUserIdZyId(user.getId(),zy.getId());
		}
	}
	
		
	/**
	 * 资源点赞
	 * @param zy
	 * @param fav  1 点赞  0取消点赞
	 * @param response 返回请求
	 */
	@RequestMapping(value="/likezy.action")
	public void likezy(Zy zy,HttpServletResponse response,HttpServletRequest request,@RequestParam(name="like",defaultValue="1")Integer like){	
		HttpSession session = request.getSession();
		User user = SessionUtil.getSessionUser(session, SessionUtil.getPortalSessionUser());
		zyglService.updDzcs(zy.getId(),like==1?1:-1);
		//如果是点赞操作
		if(like==1){
			//构造点赞对象
			Zydz zydz=new Zydz();
			zydz.setZyid(zy.getId());
			zydz.setDzrid(user.getId());
			Date date=new Date();
			zydz.setDzsj(date);
			zyglService.addZydz(zydz);//增加点赞记录
		}else{ //取消点赞操作
			zyglService.delZydzByUserIdZyId(user.getId(),zy.getId());
		}
	}
	
	/**
	 * 资源下载
	 * @param response 返回请求
	 * @throws IOException 
	 */
    @RequestMapping(value="/download.action")
	public void download(Zy zy,HttpServletResponse response,HttpServletRequest request)throws IOException {
    	//查询资源
    	zy =zyglService.schZyById(zy.getId());
    	
    	//更新下载次数
    	zyglService.updXzcs(zy.getId());
    	
    	//执行下载
    	XFileUtils.download(response, request, zy.getZydz(), zy.getWjmc(), "application/octet-stream");
    	
    	//增加资源下载日志
    	Zyxz zyxz = new Zyxz();
    	zyxz.setZyid(zy.getId()+"");
    	User user = SessionUtil.getSessionUser(request.getSession(), SessionUtil.getPortalSessionUser());
    	zyxz.setXzrid(user.getId()+"");
    	List<Zyxz> zyxzList = zyglService.schZyxz(zyxz);
    	if(!(zyxzList!=null && zyxzList.size() > 0)) {
    		zyxz.setXzsj(new Date());
    		//发布下载资源事件
    		applicationContext.publishEvent(new DownloadHistoryEvent(zyxz));
    	}
    	
    	//下载资源减积分对象构造
    	Yhkzxx yhkzxx = new Yhkzxx();
    	yhkzxx.setUserId(user.getId());
    	yhkzxx.setJf(-+zy.getXzjf());
    	//发布减积分事件
    	applicationContext.publishEvent(new PointEvent(yhkzxx));
	}
    
    
    
}
