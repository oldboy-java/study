package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 资源收藏表实体类 */
public class Zysc extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private Integer zyid;// 资源ID
	private Integer scrid;// 收藏人ID
	private Date scsj;// 收藏时间
	private String scsjBeg,scsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	private Zy zy;//资源
	//Constructors
	/** default constructor */
	public Zysc() {
	
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
	public Integer getZyid() {
		return this.zyid;
	}
	/** 设置资源ID */
	public void setZyid(Integer zyid) {
		this.zyid = zyid;
	}
	/** 获取收藏人ID */
	public Integer getScrid() {
		return this.scrid;
	}
	/** 设置收藏人ID */
	public void setScrid(Integer scrid) {
		this.scrid = scrid;
	}
	/** 获取收藏时间 */
	public Date getScsj() {
		return this.scsj;
	}
	/** 设置收藏时间 */
	public void setScsj(Date scsj) {
		this.scsj = scsj;
	}
	/** 设定[收藏时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setScsjstr(String tm) {
		this.scsj=_getTime(tm);
	}
	/** 获取[收藏时间]时间起始条件 */
	public String getScsjBeg() {
		return scsjBeg;
	}
	/** 获取[收藏时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getScsjBegDate() {
		return _getBegDate(scsjBeg);
	}
	/** 设置[收藏时间]时间起始条件(表单提交时自动装载) */
	public void setScsjBeg(String scsjBeg) {
		this.scsjBeg = scsjBeg;
	}
	
	/** 获取[收藏时间]时间结束条件 */
	public String getScsjEnd() {
		return scsjEnd;
	}
	/** 获取[收藏时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getScsjEndDate() {
		return _getEndDate(scsjEnd);
	}
	/** 设置[收藏时间]时间结束条件(表单提交时自动装载) */
	public void setScsjEnd(String scsjEnd) {
		this.scsjEnd = scsjEnd;
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
	/** 设置资源 */
	public void setZy(Zy zy) {
		this.zy = zy;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zyid", zyid);
		obj.put("scrid", scrid);
		obj.put("scsj", DateTransfer.toString(scsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("scsjstr", DateTransfer.toString(scsj,"yyyy-MM-dd HH:mm:ss"));
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
		if(scrid!=null&&!scrid.equals("")){
			obj.put("scrid", DictBuffer.getLabel("ZD_USERNAME", scrid.toString()));
		}
		obj.put("scsj", DateTransfer.toString(scsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("scsjstr", DateTransfer.toString(scsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
}
