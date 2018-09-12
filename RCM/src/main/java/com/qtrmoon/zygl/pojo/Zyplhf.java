package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 资源评论回复表实体类 */
public class Zyplhf extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private Integer plid;// 评论ID
	private String hfnr;// 回复内容
	private Integer hfrid;// 回复人ID
	private String hfrlx;// 回复人类型
	private String hfrxm;// 回复人姓名
	private Date hfsj;// 回复时间
	private String hfsjBeg,hfsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	//Constructors
	/** default constructor */
	public Zyplhf() {
	
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
	/** 获取评论ID */
	public Integer getPlid() {
		return this.plid;
	}
	/** 设置评论ID */
	public void setPlid(Integer plid) {
		this.plid = plid;
	}
	/** 获取回复内容 */
	public String getHfnr() {
		return this.hfnr;
	}
	/** 设置回复内容 */
	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}
	/** 获取回复人ID */
	public Integer getHfrid() {
		return this.hfrid;
	}
	/** 设置回复人ID */
	public void setHfrid(Integer hfrid) {
		this.hfrid = hfrid;
	}
	/** 获取回复人类型 */
	public String getHfrlx() {
		return this.hfrlx;
	}
	/** 设置回复人类型 */
	public void setHfrlx(String hfrlx) {
		this.hfrlx = hfrlx;
	}
	/** 获取回复人姓名 */
	public String getHfrxm() {
		return this.hfrxm;
	}
	/** 设置回复人姓名 */
	public void setHfrxm(String hfrxm) {
		this.hfrxm = hfrxm;
	}
	/** 获取回复时间 */
	public Date getHfsj() {
		return this.hfsj;
	}
	/** 设置回复时间 */
	public void setHfsj(Date hfsj) {
		this.hfsj = hfsj;
	}
	/** 设定[回复时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setHfsjstr(String tm) {
		this.hfsj=_getTime(tm);
	}
	/** 获取[回复时间]时间起始条件 */
	public String getHfsjBeg() {
		return hfsjBeg;
	}
	/** 获取[回复时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getHfsjBegDate() {
		return _getBegDate(hfsjBeg);
	}
	/** 设置[回复时间]时间起始条件(表单提交时自动装载) */
	public void setHfsjBeg(String hfsjBeg) {
		this.hfsjBeg = hfsjBeg;
	}
	
	/** 获取[回复时间]时间结束条件 */
	public String getHfsjEnd() {
		return hfsjEnd;
	}
	/** 获取[回复时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getHfsjEndDate() {
		return _getEndDate(hfsjEnd);
	}
	/** 设置[回复时间]时间结束条件(表单提交时自动装载) */
	public void setHfsjEnd(String hfsjEnd) {
		this.hfsjEnd = hfsjEnd;
	}
	/** 获取学校ID */
	public String getXxid() {
		return this.xxid;
	}
	/** 设置学校ID */
	public void setXxid(String xxid) {
		this.xxid = xxid;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("plid", plid);
		obj.put("hfnr", hfnr);
		obj.put("hfrid", hfrid);
		obj.put("hfrlx", hfrlx);
		obj.put("hfrxm", hfrxm);
		obj.put("hfsj", DateTransfer.toString(hfsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("hfsjstr", DateTransfer.toString(hfsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("plid", plid);
		obj.put("hfnr", hfnr);
		obj.put("hfrid", hfrid);
		obj.put("hfrlx", hfrlx);
		obj.put("hfrxm", hfrxm);
		obj.put("hfsj", DateTransfer.toString(hfsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("hfsjstr", DateTransfer.toString(hfsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
}
