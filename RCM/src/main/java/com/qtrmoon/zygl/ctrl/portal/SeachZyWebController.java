package com.qtrmoon.zygl.ctrl.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qtrmoon.common.BaseController;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;
import com.qtrmoon.zygl.vo.ZyVo;


@Controller
public class SeachZyWebController extends BaseController{
	@Autowired
	private IZyglService zyglService;								//声明模块Service实例

	/**
	 * 查询资源方法，自带分页设置。
	 * @param zysc 承载查询条件的Bean
	 * @param request 可用来获取非Bean内的参数
	 * @param response 返回请求,输出Json
	 * @throws IOException
	 */
	@RequestMapping("/portal/schZyWeb.action")
	public String schZyWeb(Zy zy,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		zy.assLike("zymc");
		zy.setPagesize(12);
		zy.setCondition(" and shzt=2 and zyzt=3");
		List<Zy> list=zyglService.schZy(zy);		//调用Service查询数据
		List<Zy> zyList2=new ArrayList<Zy>();
		if(list.size()>0){
			for (Zy zy2 : list) {
				ZyVo zyvo= new ZyVo();
				ConvertUtils.register(new DateConverter(null), java.util.Date.class); 
				BeanUtils.copyProperties(zyvo, zy2);
				if(zy2.getSsxkid()!=null){
					zyvo.setZyxk(DictBuffer.getLabel("ZD_XKLB", zy2.getSsxkid().toString())); //替换字典值
				}
				if(zy2.getShzt()!=null){
					zyvo.setShjg(DictBuffer.getLabel("ZD_SHZT", zy2.getShzt().toString()));
				}
				if(zy2.getZydz()!=null){
			
				}
				zyList2.add(zyvo);
			}
		}
		zy.unAssignLike("zymc");
		model.addAttribute("myzys", zyList2);
		model.addAttribute("zywjgs", zy.getWjgs());
		model.addAttribute("page", zy.getPage());
		model.addAttribute("totalPages", zy.getPageNum());
		return "portal/jsp/software_list";
	}

	/**
	 * 取格式
	 */
	@RequestMapping("/portal/zygs.action")
	@ResponseBody
	@Override
	public JSONArray getZYGSList(HttpServletRequest request) {
		return super.getZYGSList(request);
	}
}
