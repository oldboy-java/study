package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 等级信息实体类 */
public class Djxx extends PageForm{
	//Fields
	
	private Integer id;// 
	private String djmc;// 等级名称
	private Integer zxjf;// 最小积分数
	private Integer zdjf;// 最大积分数
	//Constructors
	/** default constructor */
	public Djxx() {
	
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
	/** 获取等级名称 */
	public String getDjmc() {
		return this.djmc;
	}
	/** 设置等级名称 */
	public void setDjmc(String djmc) {
		this.djmc = djmc;
	}
	/** 获取最小积分数 */
	public Integer getZxjf() {
		return this.zxjf;
	}
	/** 设置最小积分数 */
	public void setZxjf(Integer zxjf) {
		this.zxjf = zxjf;
	}
	/** 获取最大积分数 */
	public Integer getZdjf() {
		return this.zdjf;
	}
	/** 设置最大积分数 */
	public void setZdjf(Integer zdjf) {
		this.zdjf = zdjf;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("djmc", djmc);
		obj.put("zxjf", zxjf);
		obj.put("zdjf", zdjf);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("djmc", djmc);
		obj.put("zxjf", zxjf);
		obj.put("zdjf", zdjf);
		return obj;
	}
}
