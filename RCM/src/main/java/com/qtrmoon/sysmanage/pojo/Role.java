package com.qtrmoon.sysmanage.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
	/** 角色Object类 */
	public class Role extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String name;// 角色名称
	private String islocal;// 是否全局角色
	private String info;// 说明
	private Integer ord;// 排序
	private String classify;// 类别
	private String organid;// 组织机构ID
	private String modulename;// 模块类别
	private String funcs;// 功能集
	//Constructors
	/** default constructor */
	public Role() {
	
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
	public String getIslocal() {
		return this.islocal;
	}
	public void setIslocal(String islocal) {
		this.islocal = islocal;
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
	public String getClassify() {
		return this.classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getOrganid() {
		return this.organid;
	}
	public void setOrganid(String organid) {
		this.organid = organid;
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
		obj.put("islocal", this.getIslocal());
		obj.put("info", this.getInfo());
		obj.put("ord", this.getOrd());
		obj.put("classify", this.getClassify());
		obj.put("organid", this.getOrganid());
		obj.put("modulename", this.getModulename());
		obj.put("funcs", this.getFuncs());
		return obj;
	}
}
