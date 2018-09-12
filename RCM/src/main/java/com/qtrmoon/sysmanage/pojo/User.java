package com.qtrmoon.sysmanage.pojo;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;
import com.qtrmoon.toolkit.DateTransfer;
	/** 用户表Object类 */
	public class User extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String loginname;// 登录名
	private String password;// 密码
	private String state;// 状态
	private String username;// 姓名
	private Date regtime;// 注册时间
	private Integer organid;// 组织机构ID
	private String organname;// 组织机构名称 字典SYS_ORGAN 不存库
	private String classify;// 类型
	private String modulename;// 模块类别
	private Date birthday;// 生日
	private String roles;// 角色
	
	//缓存属性，不入库
	private String loginIp;//登录用户的IP地址
	private Organ organ;//登录用户所属机构
	private List<Function> menu;//自己的权限表，任一节点已构造好树结构，便于从任意节点寻子。
	//Constructors
	/** default constructor */
	public User() {
	
	}	
	//getter and setter
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return this.loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getRegtime() {
		return this.regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public void setRegtimestr(String tm) {
		this.regtime=_getTime(tm);
	}
	public Integer getOrganid() {
		return this.organid;
	}
	public void setOrganid(Integer organid) {
		this.organid = organid;
	}
	
	public String getClassify() {
		return this.classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getModulename() {
		return this.modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setBirthdaystr(String tm) {
		this.birthday=_getTime(tm);
	}
	public String getRoles() {
		return this.roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getOrganname() {
		return organname;
	}
	public void setOrganname(String organname) {
		this.organname = organname;
	}
	
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Organ getOrgan() {
		return organ;
	}
	public void setOrgan(Organ organ) {
		this.organ = organ;
	}
	public List<Function> getMenu() {
		return menu;
	}
	public void setMenu(List<Function> menu) {
		this.menu = menu;
	}
	
	/**
	 * 在已有的角色集合上附加角色，并清洗重复ID。
	 * @param roles2
	 */
	public void addRoles(String r2) {
		if(r2==null||r2.equals("")){
			return;
		}
		if(roles==null||roles.equals("")){
			roles=r2;
		}else{
			//借助Map进行重复清洗。
			String rstr=roles+","+r2;
			String[] rarr=rstr.split(",");
			Map<String,String> tmp=new HashMap<String,String>();
			for(String r:rarr){
				tmp.put(r, r);
			}
			String str=Arrays.toString(tmp.keySet().toArray());
			roles=str.replace("[", "").replace("]", "").replaceAll(" ", "").trim();
		}
	}

	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("loginname", this.getLoginname());
		obj.put("password", this.getPassword());
		obj.put("state", this.getState());
		obj.put("username", this.getUsername());
		obj.put("regtime", DateTransfer.dateToString(this.getRegtime()));
		obj.put("organid", this.getOrganid());
		if(organid!=null&&!organid.equals("")){
			DictBean dict=DictBuffer.getDictById("SYS_ORGAN", organid.toString());
			if(dict!=null){
				obj.put("organname", dict.getLabel());
			}
		}

		obj.put("classify", this.getClassify());
		obj.put("modulename", this.getModulename());
		obj.put("birthday", DateTransfer.toString(this.getBirthday(),"yyyy/MM/dd"));
		obj.put("birthdaystr", DateTransfer.toString(this.getBirthday(),"yyyy/MM/dd"));
		obj.put("roles", this.getRoles());
		return obj;
	}
	
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", this.getId());
		obj.put("loginname", this.getLoginname());
		obj.put("password", this.getPassword());
		obj.put("state", this.getState());
		obj.put("username", this.getUsername());
		obj.put("regtime", DateTransfer.dateToString(this.getRegtime()));
		obj.put("organid", this.getOrganid());
		if(organid!=null&&!organid.equals("")){
			obj.put("organname", DictBuffer.getLabel("SYS_ORGAN", organid.toString()));
		}
		obj.put("classify", this.getClassify());
		obj.put("modulename", this.getModulename());
		obj.put("birthday", DateTransfer.toString(this.getBirthday(),"yyyy/MM/dd"));
		obj.put("birthdaystr", DateTransfer.toString(this.getBirthday(),"yyyy/MM/dd"));
		if(roles!=null&&!roles.equals("")){
			obj.put("roles", DictBuffer.getLabel("SYS_ROLE", roles));
		}
		return obj;
	}

}
