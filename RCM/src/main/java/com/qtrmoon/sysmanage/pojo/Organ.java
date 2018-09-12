package com.qtrmoon.sysmanage.pojo;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;
	/** 机构Object类 */
	public class Organ extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private Integer pid;// 父
	private String pname;// 父机构名称，不存库
	private String name;// 机构名称
	private String ismaster;// 是否机构
	private String info;// 说明
	private Integer ord;// 排序
	private String treetrack;// 树结构路径
	private String code;// 机构编码
	private String type;// 机构类型
	private String modulename;// 模块类别
	private String funcunits;//
	private String roles;// 机构角色，机构内的用户会自动赋予的权限。
	//Constructors
	/** default constructor */
	public Organ() {
	
	}	
	//getter and setter
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return this.pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsmaster() {
		return this.ismaster;
	}
	public void setIsmaster(String ismaster) {
		this.ismaster = ismaster;
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
	public String getTreetrack() {
		return this.treetrack;
	}
	public void setTreetrack(String treetrack) {
		this.treetrack = treetrack;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModulename() {
		return this.modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getFuncunits() {
		return this.funcunits;
	}
	public void setFuncunits(String funcunits) {
		this.funcunits = funcunits;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("pid", this.getPid());
		obj.put("pname", this.getPname());
		obj.put("name", this.getName());
		obj.put("ismaster", this.getIsmaster());
		obj.put("info", this.getInfo());
		obj.put("ord", this.getOrd());
		obj.put("treetrack", this.getTreetrack());
		obj.put("code", this.getCode());
		obj.put("type", this.getType());
		obj.put("modulename", this.getModulename());
		obj.put("funcunits", this.getFuncunits());
		obj.put("roles", roles);
		return obj;
	}
	
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("pid", this.getPid());
		obj.put("pname", this.getPname());
		obj.put("name", this.getName());
		if(ismaster!=null&&!ismaster.equals("")){
			DictBean dict=DictBuffer.getDictById("SYS_ORGAN_NATURE", ismaster);
			if(dict!=null){
				obj.put("ismaster", dict.getLabel());
			}
		}
		obj.put("info", this.getInfo());
		obj.put("ord", this.getOrd());
		obj.put("treetrack", this.getTreetrack());
		obj.put("code", this.getCode());
		obj.put("type", this.getType());
		obj.put("modulename", this.getModulename());
		obj.put("funcunits", this.getFuncunits());
		if(roles!=null&&!roles.equals("")){
			obj.put("roles", DictBuffer.getLabel("SYS_ROLE", roles));
		}
		return obj;
	}
	
}
