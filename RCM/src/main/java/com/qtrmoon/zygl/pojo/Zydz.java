package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 资源点赞表实体类 */
public class Zydz extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private Integer zyid;// 资源ID
	private Integer dzrid;// 点赞人ID
	private Date dzsj;// 点赞时间
	private String dzsjBeg,dzsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	//Constructors
	/** default constructor */
	public Zydz() {
	
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
	/** 获取点赞人ID */
	public Integer getDzrid() {
		return this.dzrid;
	}
	/** 设置点赞人ID */
	public void setDzrid(Integer dzrid) {
		this.dzrid = dzrid;
	}
	/** 获取点赞时间 */
	public Date getDzsj() {
		return this.dzsj;
	}
	/** 设置点赞时间 */
	public void setDzsj(Date dzsj) {
		this.dzsj = dzsj;
	}
	/** 设定[点赞时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setDzsjstr(String tm) {
		this.dzsj=_getTime(tm);
	}
	/** 获取[点赞时间]时间起始条件 */
	public String getDzsjBeg() {
		return dzsjBeg;
	}
	/** 获取[点赞时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getDzsjBegDate() {
		return _getBegDate(dzsjBeg);
	}
	/** 设置[点赞时间]时间起始条件(表单提交时自动装载) */
	public void setDzsjBeg(String dzsjBeg) {
		this.dzsjBeg = dzsjBeg;
	}
	
	/** 获取[点赞时间]时间结束条件 */
	public String getDzsjEnd() {
		return dzsjEnd;
	}
	/** 获取[点赞时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getDzsjEndDate() {
		return _getEndDate(dzsjEnd);
	}
	/** 设置[点赞时间]时间结束条件(表单提交时自动装载) */
	public void setDzsjEnd(String dzsjEnd) {
		this.dzsjEnd = dzsjEnd;
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
		obj.put("zyid", zyid);
		obj.put("dzrid", dzrid);
		//时间字段处理。dzsj查询列表页使用，dzsjstr修改页使用
		obj.put("dzsj", DateTransfer.toString(dzsj,"yyyy/MM/dd"));
		obj.put("dzsjstr", DateTransfer.toString(dzsj,"yyyy/MM/dd"));
		obj.put("xxid", xxid);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zyid", zyid);
		obj.put("dzrid", dzrid);
		//时间字段处理。dzsj查询列表页使用，dzsjstr修改页使用
		obj.put("dzsj", DateTransfer.toString(dzsj,"yyyy/MM/dd"));
		obj.put("dzsjstr", DateTransfer.toString(dzsj,"yyyy/MM/dd"));
		obj.put("xxid", xxid);
		return obj;
	}
}
