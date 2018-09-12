package com.qtrmoon.zygl.pojo;
import java.util.Date;

import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.toolkit.DateTransfer;

/** 资源表实体类 */
public class Zy extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String zymc;// 资源名称
	private Integer ssxkid;// 所属学科ID
	private String wjgs;// 文件格式
	private Integer scrid;// 上传人ID
	private Integer zyzt;// 资源状态
	private String zydz;// 资源地址
	private String zyly;// 资源来源
	private String zz;// 作者
	private Date scrq;// 上传日期
	private String scrqBeg,scrqEnd;//时间条件的跨度查询属性
	private Integer llcs;// 浏览次数
	private Integer xzcs;// 下载次数
	private Integer sccs;// 收藏次数
	private Integer plcs;// 评论次数
	private String xxid;// 学校ID
	private String wjdx;//文件大小
	private Integer shzt;//审核状态（ 1待审核 2审核通过 3未通过）
	private String fmlj;//封面路径
	private String hzm;//后缀名
	private String wjmc;//文件名称
	private Integer zhcg; //转换成功
	private String scr;//上传人
	private Integer dzcs;//点赞次数
	private String zydx;//资源大小（统计用默认单位KB）
	private Integer xzqx; //下载权限  0自由下载    1有权限下载
	private Integer xzjf; //下载积分
	private String tag; //标签
	
	//Constructors
	/** default constructor */
	public Zy() {
	
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
	/** 获取资源名称 */
	public String getZymc() {
		return this.zymc;
	}
	/** 设置资源名称 */
	public void setZymc(String zymc) {
		this.zymc = zymc;
	}
	/** 获取所属学科ID */
	public Integer getSsxkid() {
		return this.ssxkid;
	}
	/** 设置所属学科ID */
	public void setSsxkid(Integer ssxkid) {
		this.ssxkid = ssxkid;
	}
	/** 获取文件格式 */
	public String getWjgs() {
		return this.wjgs;
	}
	/** 设置文件格式 */
	public void setWjgs(String wjgs) {
		this.wjgs = wjgs;
	}
	/** 获取上传人ID */
	public Integer getScrid() {
		return this.scrid;
	}
	/** 设置上传人ID */
	public void setScrid(Integer scrid) {
		this.scrid = scrid;
	}
	/** 获取资源状态 */
	public Integer getZyzt() {
		return this.zyzt;
	}
	/** 设置资源状态 */
	public void setZyzt(Integer zyzt) {
		this.zyzt = zyzt;
	}
	/** 获取资源地址 */
	public String getZydz() {
		return this.zydz;
	}
	/** 设置资源地址 */
	public void setZydz(String zydz) {
		this.zydz = zydz;
	}
	/** 获取资源来源 */
	public String getZyly() {
		return this.zyly;
	}
	/** 设置资源来源 */
	public void setZyly(String zyly) {
		this.zyly = zyly;
	}
	/** 获取作者 */
	public String getZz() {
		return this.zz;
	}
	/** 设置作者 */
	public void setZz(String zz) {
		this.zz = zz;
	}
	/** 获取上传日期 */
	public Date getScrq() {
		return this.scrq;
	}
	/** 设置上传日期 */
	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}
	/** 设定[上传日期]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setScrqstr(String tm) {
		this.scrq=_getTime(tm);
	}
	/** 获取[上传日期]时间起始条件 */
	public String getScrqBeg() {
		return scrqBeg;
	}
	/** 获取[上传日期]时间起始条件(Dao/Mapper查询时调用) */
	public Date getScrqBegDate() {
		return _getBegDate(scrqBeg);
	}
	/** 设置[上传日期]时间起始条件(表单提交时自动装载) */
	public void setScrqBeg(String scrqBeg) {
		this.scrqBeg = scrqBeg;
	}
	
	/** 获取[上传日期]时间结束条件 */
	public String getScrqEnd() {
		return scrqEnd;
	}
	/** 获取[上传日期]时间结束条件(Dao/Mapper查询时调用) */
	public Date getScrqEndDate() {
		return _getEndDate(scrqEnd);
	}
	/** 设置[上传日期]时间结束条件(表单提交时自动装载) */
	public void setScrqEnd(String scrqEnd) {
		this.scrqEnd = scrqEnd;
	}
	/** 获取浏览次数 */
	public Integer getLlcs() {
		return this.llcs;
	}
	/** 设置浏览次数 */
	public void setLlcs(Integer llcs) {
		this.llcs = llcs;
	}
	/** 获取下载次数 */
	public Integer getXzcs() {
		return this.xzcs;
	}
	/** 设置下载次数 */
	public void setXzcs(Integer xzcs) {
		this.xzcs = xzcs;
	}
	/** 获取收藏次数 */
	public Integer getSccs() {
		return this.sccs;
	}
	/** 设置收藏次数 */
	public void setSccs(Integer sccs) {
		this.sccs = sccs;
	}
	/** 获取评论次数 */
	public Integer getPlcs() {
		return this.plcs;
	}
	/** 设置评论次数 */
	public void setPlcs(Integer plcs) {
		this.plcs = plcs;
	}
	/** 获取学校ID */
	public String getXxid() {
		return this.xxid;
	}
	/** 设置学校ID */
	public void setXxid(String xxid) {
		this.xxid = xxid;
	}
	/** 获取文件大小 */
	public String getWjdx() {
		return wjdx;
	}
	/** 设置文件大小 */
	public void setWjdx(String wjdx) {
		this.wjdx = wjdx;
	}
	/** 获取审核状态 */
	public Integer getShzt() {
		return shzt;
	}
	/** 设置审核状态 */
	public void setShzt(Integer shzt) {
		this.shzt = shzt;
	}

	/** 获取封面路径 */
	public String getFmlj() {
		return fmlj;
	}
	/** 设置封面路径 */
	public void setFmlj(String fmlj) {
		this.fmlj = fmlj;
	}
	/** 获取后缀名 */
	public String getHzm() {
		return hzm;
	}
	/** 设置后缀名 */
	public void setHzm(String hzm) {
		this.hzm = hzm;
	}
	/** 获取文件名称 */
	public String getWjmc() {
		return wjmc;
	}
	/** 设置文件名称 */
	public void setWjmc(String wjmc) {
		this.wjmc = wjmc;
	}
	
	/** 获取转换成功 */
	public Integer getZhcg() {
		return zhcg;
	}
	/** 设置转换成功 */
	public void setZhcg(Integer zhcg) {
		this.zhcg = zhcg;
	}
	/** 获取上传人 */
	public String getScr() {
		return scr;
	}
	/** 设置上传人 */
	public void setScr(String scr) {
		this.scr = scr;
	}
	/** 获取点赞次数 */
	public Integer getDzcs() {
		return dzcs;
	}
	/** 设置点赞次数 */
	public void setDzcs(Integer dzcs) {
		this.dzcs = dzcs;
	}
	/** 获取资源大小 */
	public String getZydx() {
		return zydx;
	}
	/** 设置资源大小 */
	public void setZydx(String zydx) {
		this.zydx = zydx;
	}
	
	/** 获取下载权限 */
	public Integer getXzqx() {
		return xzqx;
	}
	
	/** 设置下载权限 */
	public void setXzqx(Integer xzqx) {
		this.xzqx = xzqx;
	}
	
	/** 获取下载积分 */
	public Integer getXzjf() {
		return xzjf;
	}
	/** 设置下载积分 */
	public void setXzjf(Integer xzjf) {
		this.xzjf = xzjf;
	}
	
	/** 获取标签 */
	public String getTag() {
		return tag;
	}
	
	/** 设置标签 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zymc", zymc);
		obj.put("ssxkid", ssxkid);
		obj.put("wjgs", wjgs);
		obj.put("scrid", scrid);
		obj.put("zyzt", zyzt);
		obj.put("zydz", zydz);
		obj.put("zyly", zyly);
		obj.put("zz", zz);
		obj.put("scrq", DateTransfer.toString(scrq,"yyyy/MM/dd"));
		obj.put("scrqstr", DateTransfer.toString(scrq,"yyyy/MM/dd"));
		obj.put("llcs", llcs);
		obj.put("xzcs", xzcs);
		obj.put("sccs", sccs);
		obj.put("plcs", plcs);
		obj.put("xxid", xxid);
		obj.put("wjdx", wjdx);
		obj.put("shzt", shzt);
		obj.put("fmlj", fmlj);
		obj.put("hzm", hzm);
		obj.put("wjmc", wjmc);
		obj.put("zhcg", zhcg);
		obj.put("scr", scr);
		obj.put("dzcs", dzcs);
		obj.put("zydx", zydx);
		obj.put("xzqx", xzqx);
		obj.put("xzjf", xzjf);
		obj.put("tag", tag);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zymc", zymc);
		if(ssxkid!=null&&!ssxkid.equals("")){
			obj.put("ssxkid", DictBuffer.getLabel("ZD_XKLB", ssxkid.toString()));
		}
		obj.put("wjgs", wjgs);	
		if(scrid!=null&&!scrid.equals("")){
			obj.put("scrid", DictBuffer.getLabel("ZD_USERNAME", scrid.toString()));
		}
		if(zyzt!=null&&!zyzt.equals("")){
			obj.put("zyzt", DictBuffer.getLabel("ZD_ZYZT", zyzt.toString()));
		}
		obj.put("zydz", zydz);
		obj.put("zyly", zyly);
		obj.put("zz", zz);
		obj.put("scrq", DateTransfer.toString(scrq,"yyyy/MM/dd"));
		obj.put("scrqstr", DateTransfer.toString(scrq,"yyyy/MM/dd"));
		obj.put("llcs", llcs);
		obj.put("xzcs", xzcs);
		obj.put("sccs", sccs);
		obj.put("plcs", plcs);
		obj.put("xxid", xxid);
		obj.put("wjdx", wjdx);
		if(shzt!=null&&!shzt.equals("")){
			obj.put("shzt", DictBuffer.getLabel("ZD_SHZT", shzt.toString()));
		}
		obj.put("fmlj", fmlj);
		obj.put("hzm", hzm);
		obj.put("wjmc", wjmc);
		obj.put("zhcg", zhcg);
		obj.put("scr", scr);
		obj.put("dzcs", dzcs);
		obj.put("zydx", zydx);
		obj.put("xzqx", xzqx);
		obj.put("xzjf", xzjf);
		obj.put("tag", tag);
		return obj;
	}
}
