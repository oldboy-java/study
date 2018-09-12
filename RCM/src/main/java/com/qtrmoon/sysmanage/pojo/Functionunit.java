package com.qtrmoon.sysmanage.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
	/** 功能单元Object类 */
	public class Functionunit extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String name;// 功能单元名称
	private String info;// 功能单元说明
	private Integer ord;// 排序
	private String picico;// 功能单元图标
	private String modulename;// 模块类别
	private String funcs;// 
	//Constructors
	/** default constructor */
	public Functionunit() {
	
	}	
	//getter and setter
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return this.info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getOrd() {
		return this.ord;
	}
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
	public String getPicico() {
		return this.picico;
	}
	public void setPicico(String picico) {
		this.picico = picico;
	}
	public String getModulename() {
		return this.modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getFuncs() {
		return this.funcs;
	}
	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("name", this.getName());
		obj.put("info", this.getInfo());
		obj.put("ord", this.getOrd());
		obj.put("picico", this.getPicico());
		obj.put("modulename", this.getModulename());
		obj.put("funcs", this.getFuncs());
		return obj;
	}
}
