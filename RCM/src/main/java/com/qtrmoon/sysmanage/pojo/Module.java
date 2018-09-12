package com.qtrmoon.sysmanage.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;
	/** 功能模块Object类 */
	public class Module extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String name;// 标题
	private String keyword;// 关键词
	private String funcs;// 功能根集合
	private String link;// 外链
	private String info;// 说明
	private Integer ord;// 排序
	private String icon;// 图标
	private String funcIndex;//检索辅助索引
	//Constructors
	/** default constructor */
	public Module() {
	
	}	
	//getter and setter
	/** 获取主键 */
	public Integer getId() {
		return this.id;
	}
	/** 设置主键 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 获取标题 */
	public String getName() {
		return this.name;
	}
	/** 设置标题 */
	public void setName(String name) {
		this.name = name;
	}
	/** 获取关键词 */
	public String getKeyword() {
		return this.keyword;
	}
	/** 设置关键词 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/** 获取功能根集合 */
	public String getFuncs() {
		return this.funcs;
	}
	/** 设置功能根集合 */
	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}
	/** 获取外链 */
	public String getLink() {
		return this.link;
	}
	/** 设置外链 */
	public void setLink(String link) {
		this.link = link;
	}
	/** 获取说明 */
	public String getInfo() {
		return this.info;
	}
	/** 设置说明 */
	public void setInfo(String info) {
		this.info = info;
	}
	/** 获取排序 */
	public Integer getOrd() {
		return this.ord;
	}
	/** 设置排序 */
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
	/** 获取图标 */
	public String getIcon() {
		return this.icon;
	}
	/** 设置图标 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getFuncIndex() {
		return funcIndex;
	}
	public void setFuncIndex(String funcIndex) {
		this.funcIndex = funcIndex;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("name", name);
		obj.put("keyword", keyword);
		obj.put("funcs", funcs);
		obj.put("link", link);
		obj.put("info", info);
		obj.put("ord", ord);
		obj.put("icon", icon);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("name", name);
		obj.put("keyword", keyword);
		obj.put("funcs", funcs);
		obj.put("link", link);
		obj.put("info", info);
		obj.put("ord", ord);
		obj.put("icon", icon);
		return obj;
	}
}
