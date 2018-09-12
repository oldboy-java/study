package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 用户扩展信息实体类 */
public class Yhkzxx extends PageForm{
	//Fields
	
	private Integer id;// 
	private Integer userId;// 用户ID
	private Integer jf;// 积分数
	//Constructors
	/** default constructor */
	public Yhkzxx() {
	
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
	/** 获取用户ID */
	public Integer getUserId() {
		return this.userId;
	}
	/** 设置用户ID */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/** 获取积分数 */
	public Integer getJf() {
		return this.jf;
	}
	/** 设置积分数 */
	public void setJf(Integer jf) {
		this.jf = jf;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("userId", userId);
		obj.put("jf", jf);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("userId", userId);
		obj.put("jf", jf);
		return obj;
	}
}
