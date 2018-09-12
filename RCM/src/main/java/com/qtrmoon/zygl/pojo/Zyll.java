package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 资源浏览表实体类 */
public class Zyll extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String zyid;// 资源ID
	private String llrid;// 浏览人ID
	private Date llsj;// 浏览时间
	private String llsjBeg,llsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	private Zy zy;//资源
	//Constructors
	/** default constructor */
	public Zyll() {
	
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
	/** 获取资源ID */
	public String getZyid() {
		return this.zyid;
	}
	/** 设置资源ID */
	public void setZyid(String zyid) {
		this.zyid = zyid;
	}
	/** 获取浏览人ID */
	public String getLlrid() {
		return this.llrid;
	}
	/** 设置浏览人ID */
	public void setLlrid(String llrid) {
		this.llrid = llrid;
	}
	/** 获取浏览时间 */
	public Date getLlsj() {
		return this.llsj;
	}
	/** 设置浏览时间 */
	public void setLlsj(Date llsj) {
		this.llsj = llsj;
	}
	/** 设定[浏览时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setLlsjstr(String tm) {
		this.llsj=_getTime(tm);
	}
	/** 获取[浏览时间]时间起始条件 */
	public String getLlsjBeg() {
		return llsjBeg;
	}
	/** 获取[浏览时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getLlsjBegDate() {
		return _getBegDate(llsjBeg);
	}
	/** 设置[浏览时间]时间起始条件(表单提交时自动装载) */
	public void setLlsjBeg(String llsjBeg) {
		this.llsjBeg = llsjBeg;
	}
	
	/** 获取[浏览时间]时间结束条件 */
	public String getLlsjEnd() {
		return llsjEnd;
	}
	/** 获取[浏览时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getLlsjEndDate() {
		return _getEndDate(llsjEnd);
	}
	/** 设置[浏览时间]时间结束条件(表单提交时自动装载) */
	public void setLlsjEnd(String llsjEnd) {
		this.llsjEnd = llsjEnd;
	}
	/** 获取学校ID */
	public String getXxid() {
		return this.xxid;
	}
	/** 设置学校ID */
	public void setXxid(String xxid) {
		this.xxid = xxid;
	}
	/** 获取资源 */
	public Zy getZy() {
		return zy;
	}
	/** 设置资源*/
	public void setZy(Zy zy) {
		this.zy = zy;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zyid", zyid);
		obj.put("llrid", llrid);
		obj.put("llsj", DateTransfer.toString(llsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("llsjstr", DateTransfer.toString(llsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		if(zyid!=null&&!zyid.equals("")){
			obj.put("zyid", DictBuffer.getLabel("ZD_ZYMC", zyid.toString()));
		}
		obj.put("llrid", llrid);
		obj.put("llsj", DateTransfer.toString(llsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("llsjstr", DateTransfer.toString(llsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
}
