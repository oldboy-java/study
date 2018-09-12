package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 资源评论表实体类 */
public class Zypl extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private Integer zyid;// 资源ID
	private String plnr;// 评论内容
	private Integer plrid;// 评论人ID
	private String plrlx;// 评论人类型
	private String plrxm;// 评论人姓名
	private Date plsj;// 评论时间
	private String plsjBeg,plsjEnd;//时间条件的跨度查询属性
	private String xxid;// 学校ID
	private Integer lx;//类型1为默认，2为回复
	private String pls;//评论的是谁
	private Zy zy;//资源
	private String zymc;//资源名称
	//Constructors
	/** default constructor */
	public Zypl() {
	
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
	/** 获取评论内容 */
	public String getPlnr() {
		return this.plnr;
	}
	/** 设置评论内容 */
	public void setPlnr(String plnr) {
		this.plnr = plnr;
	}
	/** 获取评论人ID */
	public Integer getPlrid() {
		return this.plrid;
	}
	/** 设置评论人ID */
	public void setPlrid(Integer plrid) {
		this.plrid = plrid;
	}
	/** 获取评论人类型 */
	public String getPlrlx() {
		return this.plrlx;
	}
	/** 设置评论人类型 */
	public void setPlrlx(String plrlx) {
		this.plrlx = plrlx;
	}
	/** 获取评论人姓名 */
	public String getPlrxm() {
		return this.plrxm;
	}
	/** 设置评论人姓名 */
	public void setPlrxm(String plrxm) {
		this.plrxm = plrxm;
	}
	/** 获取评论时间 */
	public Date getPlsj() {
		return this.plsj;
	}
	/** 设置评论时间 */
	public void setPlsj(Date plsj) {
		this.plsj = plsj;
	}
	/** 设定[评论时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setPlsjstr(String tm) {
		this.plsj=_getTime(tm);
	}
	/** 获取[评论时间]时间起始条件 */
	public String getPlsjBeg() {
		return plsjBeg;
	}
	/** 获取[评论时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getPlsjBegDate() {
		return _getBegDate(plsjBeg);
	}
	/** 设置[评论时间]时间起始条件(表单提交时自动装载) */
	public void setPlsjBeg(String plsjBeg) {
		this.plsjBeg = plsjBeg;
	}
	
	/** 获取[评论时间]时间结束条件 */
	public String getPlsjEnd() {
		return plsjEnd;
	}
	/** 获取[评论时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getPlsjEndDate() {
		return _getEndDate(plsjEnd);
	}
	/** 设置[评论时间]时间结束条件(表单提交时自动装载) */
	public void setPlsjEnd(String plsjEnd) {
		this.plsjEnd = plsjEnd;
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
	/** 获取类型 */
	public Integer getLx() {
		return lx;
	}
	/** 设置类型 */
	public void setLx(Integer lx) {
		this.lx = lx;
	}
	/** 获取评论谁 */
	public String getPls() {
		return pls;
	}
	/** 设置评论谁 */
	public void setPls(String pls) {
		this.pls = pls;
	}
	/** 获取资源名称 */
	public String getZymc() {
		return zymc;
	}
	/** 设置资源名称 */
	public void setZymc(String zymc) {
		this.zymc = zymc;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zyid", zyid);
		obj.put("plnr", plnr);
		obj.put("plrid", plrid);
		obj.put("plrlx", plrlx);
		obj.put("plrxm", plrxm);
		obj.put("plsj", DateTransfer.toString(plsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("plsjstr", DateTransfer.toString(plsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		obj.put("lx", lx);
		obj.put("pls", pls);
		obj.put("zymc", zymc);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zyid", zyid);
		obj.put("plnr", plnr);
		obj.put("plrid", plrid);
		obj.put("plrlx", plrlx);
		obj.put("plrxm", plrxm);
		obj.put("plsj", DateTransfer.toString(plsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("plsjstr", DateTransfer.toString(plsj,"yyyy-MM-dd HH:mm:ss"));
		obj.put("xxid", xxid);
		if(lx!=null&&!lx.equals("")){
			obj.put("lx", DictBuffer.getLabel("ZD_PLLX", lx.toString()));
		}
		obj.put("pls", pls);
		obj.put("zymc", zymc);
		return obj;
	}
}
