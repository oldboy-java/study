package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 通知公告表实体类 */
public class Tzgg extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String tzbt;// 通知标题
	private String tznr;// 通知内容
	private Date cjsj;// 创建时间
	private String cjsjBeg,cjsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	//Constructors
	/** default constructor */
	public Tzgg() {
	
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
	/** 获取通知标题 */
	public String getTzbt() {
		return this.tzbt;
	}
	/** 设置通知标题 */
	public void setTzbt(String tzbt) {
		this.tzbt = tzbt;
	}
	/** 获取通知内容 */
	public String getTznr() {
		return this.tznr;
	}
	/** 设置通知内容 */
	public void setTznr(String tznr) {
		this.tznr = tznr;
	}
	/** 获取创建时间 */
	public Date getCjsj() {
		return this.cjsj;
	}
	/** 设置创建时间 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}
	/** 设定[创建时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setCjsjstr(String tm) {
		this.cjsj=_getTime(tm);
	}
	/** 获取[创建时间]时间起始条件 */
	public String getCjsjBeg() {
		return cjsjBeg;
	}
	/** 获取[创建时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getCjsjBegDate() {
		return _getBegDate(cjsjBeg);
	}
	/** 设置[创建时间]时间起始条件(表单提交时自动装载) */
	public void setCjsjBeg(String cjsjBeg) {
		this.cjsjBeg = cjsjBeg;
	}
	
	/** 获取[创建时间]时间结束条件 */
	public String getCjsjEnd() {
		return cjsjEnd;
	}
	/** 获取[创建时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getCjsjEndDate() {
		return _getEndDate(cjsjEnd);
	}
	/** 设置[创建时间]时间结束条件(表单提交时自动装载) */
	public void setCjsjEnd(String cjsjEnd) {
		this.cjsjEnd = cjsjEnd;
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
		obj.put("tzbt", tzbt);
		obj.put("tznr", tznr);
		obj.put("cjsj", DateTransfer.toString(cjsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("cjsjstr", DateTransfer.toString(cjsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("tzbt", tzbt);
		obj.put("tznr", tznr);
		obj.put("cjsj", DateTransfer.toString(cjsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("cjsjstr", DateTransfer.toString(cjsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
}
