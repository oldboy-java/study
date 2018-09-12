package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 学科类别表实体类 */
public class Xklb extends PageForm{
	//Fields
	
	private Integer id;// 主键
	private String xkmc;//  学科名称
	private String xxid;// 学校ID
	//Constructors
	/** default constructor */
	public Xklb() {
	
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
	/** 获取 学科名称 */
	public String getXkmc() {
		return this.xkmc;
	}
	/** 设置 学科名称 */
	public void setXkmc(String xkmc) {
		this.xkmc = xkmc;
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
		obj.put("xkmc", xkmc);
		obj.put("xxid", xxid);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("xkmc", xkmc);
		obj.put("xxid", xxid);
		return obj;
	}
}
