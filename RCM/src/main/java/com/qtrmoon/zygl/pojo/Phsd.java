package com.qtrmoon.zygl.pojo;
import org.json.simple.JSONObject;

import com.qtrmoon.common.PageForm;

/** 偏好设定实体类 */
public class Phsd extends PageForm{
	//Fields
	
	private Integer id;// 
	private String zylxIds;// 资源类型ID串，用逗号隔开
	private Integer yhid;// 用户ID
	private String xxid;// 学校ＩＤ
	//Constructors
	/** default constructor */
	public Phsd() {
	
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
	/** 获取资源类型ID串，用逗号隔开 */
	public String getZylxIds() {
		return this.zylxIds;
	}
	/** 设置资源类型ID串，用逗号隔开 */
	public void setZylxIds(String zylxIds) {
		this.zylxIds = zylxIds;
	}
	/** 获取用户ID */
	public Integer getYhid() {
		return this.yhid;
	}
	/** 设置用户ID */
	public void setYhid(Integer yhid) {
		this.yhid = yhid;
	}
	/** 获取学校ＩＤ */
	public String getXxid() {
		return this.xxid;
	}
	/** 设置学校ＩＤ */
	public void setXxid(String xxid) {
		this.xxid = xxid;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zylxIds", zylxIds);
		obj.put("yhid", yhid);
		obj.put("xxid", xxid);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("zylxIds", zylxIds);
		obj.put("yhid", yhid);
		obj.put("xxid", xxid);
		return obj;
	}
}
