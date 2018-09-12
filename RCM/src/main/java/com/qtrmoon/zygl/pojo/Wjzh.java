package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 文件转换表实体类 */
public class Wjzh extends PageForm{
	//Fields
	
	private Integer id;// 
	private String wjid;// 文件Id
	private String wjmc;// 文件名称
	private Integer zhjg;// 转换结果
	private Date zhsj;// 转换时间
	private String zhsjBeg,zhsjEnd;//时间条件的跨度查询属性
	private Integer sftb; //是否同步
	//Constructors
	/** default constructor */
	public Wjzh() {
	
	}	
	//getter and setter
	/** 获取 */
	public Integer getId() {
		return this.id;
	}
	/** 设置 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 获取文件Id */
	public String getWjid() {
		return this.wjid;
	}
	/** 设置文件Id */
	public void setWjid(String wjid) {
		this.wjid = wjid;
	}
	/** 获取文件名称 */
	public String getWjmc() {
		return this.wjmc;
	}
	/** 设置文件名称 */
	public void setWjmc(String wjmc) {
		this.wjmc = wjmc;
	}
	/** 获取转换结果 */
	public Integer getZhjg() {
		return this.zhjg;
	}
	/** 设置转换结果 */
	public void setZhjg(Integer zhjg) {
		this.zhjg = zhjg;
	}
	/** 获取转换时间 */
	public Date getZhsj() {
		return this.zhsj;
	}
	/** 设置转换时间 */
	public void setZhsj(Date zhsj) {
		this.zhsj = zhsj;
	}
	/** 设定[转换时间]时间转载字段值，页面提交时由springmvc自动装载 */
	public void setZhsjstr(String tm) {
		this.zhsj=_getTime(tm);
	}
	/** 获取[转换时间]时间起始条件 */
	public String getZhsjBeg() {
		return zhsjBeg;
	}
	/** 获取[转换时间]时间起始条件(Dao/Mapper查询时调用) */
	public Date getZhsjBegDate() {
		return _getBegDate(zhsjBeg);
	}
	/** 设置[转换时间]时间起始条件(表单提交时自动装载) */
	public void setZhsjBeg(String zhsjBeg) {
		this.zhsjBeg = zhsjBeg;
	}
	
	/** 获取[转换时间]时间结束条件 */
	public String getZhsjEnd() {
		return zhsjEnd;
	}
	/** 获取[转换时间]时间结束条件(Dao/Mapper查询时调用) */
	public Date getZhsjEndDate() {
		return _getEndDate(zhsjEnd);
	}
	/** 设置[转换时间]时间结束条件(表单提交时自动装载) */
	public void setZhsjEnd(String zhsjEnd) {
		this.zhsjEnd = zhsjEnd;
	}
	
	/** 获取是否同步 */
	public Integer getSftb() {
		return sftb;
	}
	/** 设置是否同步 */
	public void setSftb(Integer sftb) {
		this.sftb = sftb;
	}
	
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("wjid", wjid);
		obj.put("wjmc", wjmc);
		obj.put("zhjg", zhjg);
		//时间字段处理。zhsj查询列表页使用，zhsjstr修改页使用
		obj.put("zhsj", DateTransfer.toString(zhsj,"yyyy/MM/dd"));
		obj.put("zhsjstr", DateTransfer.toString(zhsj,"yyyy/MM/dd"));
		obj.put("sftb", sftb);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("wjid", wjid);
		obj.put("wjmc", wjmc);
		obj.put("zhjg", zhjg);
		//时间字段处理。zhsj查询列表页使用，zhsjstr修改页使用
		obj.put("zhsj", DateTransfer.toString(zhsj,"yyyy/MM/dd"));
		obj.put("zhsjstr", DateTransfer.toString(zhsj,"yyyy/MM/dd"));
		obj.put("sftb", sftb);
		return obj;
	}
}
