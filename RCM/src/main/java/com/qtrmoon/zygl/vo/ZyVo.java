package com.qtrmoon.zygl.vo;

import org.json.simple.JSONObject;

import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.zygl.pojo.Zy;

public class ZyVo extends Zy {
    private String zyxk;
    private String shjg;
	public String getZyxk() {
		return zyxk;
	}
	public void setZyxk(String zyxk) {
		this.zyxk = zyxk;
	}
	public String getShjg() {
		return shjg;
	}
	public void setShjg(String shjg) {
		this.shjg = shjg;
	}
    
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", getId());
		obj.put("zymc", getZymc());
		obj.put("ssxkid", getSsxkid());
		obj.put("wjgs", getWjgs());
		obj.put("scrid", getScrid());
		obj.put("zyzt", getZyzt());
		obj.put("zydz", getZydz());
		obj.put("zyly", getZyly());
		obj.put("zz", getZz());
		obj.put("scrq", DateTransfer.toString(getScrq(),"yyyy/MM/dd"));
		obj.put("scrqstr", DateTransfer.toString(getScrq(),"yyyy/MM/dd"));
		obj.put("llcs", getLlcs());
		obj.put("xzcs", getXzcs());
		obj.put("sccs", getSccs());
		obj.put("plcs", getPlcs());
		obj.put("xxid", getXxid());
		obj.put("wjdx", getWjdx());
		obj.put("shzt", getShzt());
		obj.put("fmlj", getFmlj());
		obj.put("hzm", getHzm());
		obj.put("wjmc", getWjmc());
		obj.put("zhcg", getZhcg());
		obj.put("scr", getScr());
		obj.put("dzcs", getDzcs());
		obj.put("zyxk", zyxk);
		obj.put("shjg", shjg);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", getId());
		obj.put("zymc", getZymc());
		if(getSsxkid()!=null&&!getSsxkid().equals("")){
			obj.put("zyxk", DictBuffer.getLabel("ZD_XKLB", getSsxkid().toString()));
		}
		obj.put("wjgs", getWjgs());
		obj.put("scrid", getScrid());
		obj.put("zyzt", getZyzt());
		obj.put("zydz", getZydz());
		obj.put("zyly", getZyly());
		obj.put("zz", getZz());
		obj.put("scrq", DateTransfer.toString(getScrq(),"yyyy/MM/dd"));
		obj.put("scrqstr", DateTransfer.toString(getScrq(),"yyyy/MM/dd"));
		obj.put("llcs", getLlcs());
		obj.put("xzcs", getXzcs());
		obj.put("sccs", getSccs());
		obj.put("plcs", getPlcs());
		obj.put("xxid", getXxid());
		obj.put("wjdx", getWjdx());
		if(getShzt()!=null&&!getShzt().equals("")){
			obj.put("shjg", DictBuffer.getLabel("ZD_SHZT", getShzt().toString()));
		}
		obj.put("fmlj", getFmlj());
		obj.put("hzm", getHzm());
		obj.put("wjmc", getWjmc());
		obj.put("zhcg", getZhcg());
		obj.put("scr", getScr());
		obj.put("dzcs", getDzcs());
		return obj;
	} 
}
