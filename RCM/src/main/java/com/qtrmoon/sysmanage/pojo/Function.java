package com.qtrmoon.sysmanage.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.toolkit.tree.TreeNode;
	/** 功能Object类 */
	public class Function extends TreeNode{
	//Fields
	
	private Integer id;// 主键
	private String name;// 姓名
	private Integer pid;// 父
	private String link;// 链接
	private String isshow;// 显示 [菜单1 权限2 隐藏权限0]
	private String info;// 说明
	private String picico;// 图标
	private String picimg;// 图片
	private Integer ord;// 排序
	private String treetrack;// 树序
	private String modulename;// 模块
	//Constructors
	/** default constructor */
	public Function() {
	
	}	
	//getter and setter
	
	/** 获取主键 */
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
	public Integer getPid() {
		return this.pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getLink() {
		return this.link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIsshow() {
		return this.isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getInfo() {
		return this.info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPicico() {
		return this.picico;
	}
	public void setPicico(String picico) {
		this.picico = picico;
	}
	public String getPicimg() {
		return this.picimg;
	}
	public void setPicimg(String picimg) {
		this.picimg = picimg;
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
	public String getModulename() {
		return this.modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("name", this.getName());
		obj.put("pid", this.getPid());
		obj.put("link", this.getLink());
		obj.put("isshow", this.getIsshow());
		obj.put("info", this.getInfo());
		obj.put("picico", this.getPicico());
		obj.put("picimg", this.getPicimg());
		obj.put("ord", this.getOrd());
		obj.put("treetrack", this.getTreetrack());
		obj.put("modulename", this.getModulename());
		return obj;
	}
	
	private JSONObject getJsonSimple() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("name", this.getName());
		obj.put("pid", this.getPid());
		obj.put("link", this.getLink());
		obj.put("isshow", this.getIsshow());
		obj.put("picico", this.getPicico());
		obj.put("ord", this.getOrd());
		return obj;
	}

	public JSONArray getMenuJson() {
		JSONArray funcs=new JSONArray();
		for(int i=0;i<this.getCnodeList().size();i++){
			Function fun=(Function)this.getCnodeList().get(i);
			JSONObject funjson=fun.getJsonSimple();
			funjson.put("children", fun.getMenuJson());
			funcs.add(funjson);
		}
		return funcs;
	}
	
	@Override
	public String getTreeId() {
		return id.toString();
	}
	@Override
	public String getTreePId() {
		if(pid==null)return "-1";
		return pid.toString();
	}

	public Function clone() {
		Function fun=new Function();
		fun.setId(id);
		fun.setName(name);
		fun.setPid(pid);
		fun.setLink(link);
		fun.setIsshow(isshow);
		fun.setPicico(picico);
		fun.setOrd(ord);
		return fun;
	}
}
