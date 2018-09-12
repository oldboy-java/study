package com.qtrmoon.sysmanage.ctrl;

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
import com.qtrmoon.dictionary.bsd.DictBean;
import com.qtrmoon.sysmanage.pojo.Organ;
import com.qtrmoon.sysmanage.serdao.ISysmanageService;

@Controller
@RequestMapping("/sysmanage/organ")
public class OrganController extends BaseController{
	@Autowired
	private ISysmanageService sysmanageService;

	@RequestMapping(value="/schOrgan.action")
	public void schOrgan(Organ organ,HttpServletRequest request,HttpServletResponse response) throws IOException{
		noCache(response);
		System.out.println(33);
		organ.setCondition("");//防sql注入
		organ.assLike("name");
		List<Organ> list=null;
		if(organ.getId()!=null){
			boolean child=Boolean.parseBoolean(request.getParameter("child"));
			if(child){
				String treetrack=sysmanageService.schOrganById(organ.getId()).getTreetrack();
				organ.setTreetrack(treetrack+'%');
			}else{
				organ.setPid(organ.getId());
			}
			list=sysmanageService.schOrgan(organ);
			JSONArray datas=new JSONArray();
			JSONObject obj;
			for(Organ u:list){
				obj=u.getJsonInDict();
				obj.put("_oper",u.getId());
				datas.add(obj);
			}
			JSONObject res=new JSONObject();
			res.put("total",organ.getDatasize());
			res.put("rows", datas);
			response.getWriter().print(res.toJSONString());
		}
	}
	@RequestMapping(value="/updOrgan.action")
	public void updOrgan(Organ organ,String from,HttpServletResponse response) throws IOException{
		noCache(response);
		if("submit".equals(from)){
			if(organ.getId()==null){
				sysmanageService.addOrgan(organ);
				if(organ.getPid()!=null){//设置节点的树路径
					Organ pOrgan=sysmanageService.schOrganById(organ.getPid());
					organ.setTreetrack(pOrgan.getTreetrack()+"-"+organ.getId());
					sysmanageService.updOrgan(organ);
				}
			}else{
				sysmanageService.updOrgan(organ);
			}
			DictBuffer.updCache("SYS_ORGAN");
		}else{
			if(organ.getId()!=null&&organ.getId()!=0){
				organ=sysmanageService.schOrganById(organ.getId());
				if(organ.getPid()!=null){
					DictBean pOrg=DictBuffer.getDictById("SYS_ORGAN",organ.getPid()+"");
					if(pOrg!=null)organ.setPname(pOrg.getLabel());
				}else{
					organ.setPname("无");
				}
				response.getWriter().print(organ.getJson());
			}else{
				Organ newOrgan=new Organ();
				newOrgan.setPid(organ.getPid());
				newOrgan.setPname(DictBuffer.getDictById("SYS_ORGAN", organ.getPid()+"").getLabel());
				response.getWriter().print(newOrgan.getJson());
			}
		}
	}
	@RequestMapping(value="/delOrgan.action")
	public void delOrgan(@RequestParam(value = "ids[]") Integer[] ids,HttpServletResponse response){
		noCache(response);
		sysmanageService.delOrgan(ids);
		DictBuffer.updCache("SYS_ORGAN");
	}
	
	/**
	 * JSP页面跳转
	 * @param page jsp页面文件名，无模块前缀和.jsp后缀
	 * @return 返回跳转的页面
	 */
	@RequestMapping(value="/page.action")
	public String goPage(String page){
		if("index".equals(page)||"organ_sch".equals(page)||"organ_upd".equals(page)||"organ_vie".equals(page)){
			return "/sysmanage/"+page;
		}else{
			return "/error";
		}
	}
}
