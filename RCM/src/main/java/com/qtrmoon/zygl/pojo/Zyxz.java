package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 资源下载表实体类 */
public class Zyxz extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String zyid;// 资源ID
	private String xzrid;// 下载人ID
	private Date xzsj;// 下载时间
	private String xzsjBeg,xzsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	private Zy zy;//资源
	//Constructors
	/** default constructor */
	public Zyxz() {
	
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
	/** 获取下载人ID */
	public String getXzrid() {
		return this.xzrid;
	}
	/** 设置下载人ID */
	public void setXzrid(String xzrid) {
		this.xzrid = xzrid;
	}
	/** 获取评论时间 */
	public Date getXzsj() {
		return this.xzsj;
	}
	/** 设置评论时间 */
	public void setXzsj(Date xzsj) {
		this.xzsj = xzsj;
	}
	/** 设定[评论时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setXzsjstr(String tm) {
		this.xzsj=_getTime(tm);
	}
	/** 获取[评论时间]时间起始条件 */
	public String getXzsjBeg() {
		return xzsjBeg;
	}
	/** 获取[评论时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getXzsjBegDate() {
		return _getBegDate(xzsjBeg);
	}
	/** 设置[评论时间]时间起始条件(表单提交时自动装载) */
	public void setXzsjBeg(String xzsjBeg) {
		this.xzsjBeg = xzsjBeg;
	}
	
	/** 获取[评论时间]时间结束条件 */
	public String getXzsjEnd() {
		return xzsjEnd;
	}
	/** 获取[评论时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getXzsjEndDate() {
		return _getEndDate(xzsjEnd);
	}
	/** 设置[评论时间]时间结束条件(表单提交时自动装载) */
	public void setXzsjEnd(String xzsjEnd) {
		this.xzsjEnd = xzsjEnd;
	}
	/** 获取学校ID */
	public String getXxid() {
		return this.xxid;
	}
	/** 设置学校ID */
	public void setXxid(String xxid) {
		this.xxid = xxid;
	}
	/** 获取资源*/
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
		obj.put("xzrid", xzrid);
		obj.put("xzsj", DateTransfer.toString(xzsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xzsjstr", DateTransfer.toString(xzsj,"yyyy-MM-dd HH:mm:ss"));
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
		obj.put("xzrid", xzrid);
		obj.put("xzsj", DateTransfer.toString(xzsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xzsjstr", DateTransfer.toString(xzsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		return obj;
	}
}
