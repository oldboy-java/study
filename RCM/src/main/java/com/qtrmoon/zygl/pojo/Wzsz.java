package com.qtrmoon.zygl.pojo;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.json.simple.JSONObject;
import com.qtrmoon.common.PageForm;
import com.qtrmoon.toolkit.DateTransfer;
import com.qtrmoon.dictionary.DictBuffer;
import com.qtrmoon.dictionary.bsd.DictBean;

/** 网站设置实体类 */
public class Wzsz extends PageForm{
	//Fields
	
	private Integer id;// 
	private Integer mb;// 模板
	//Constructors
	/** default constructor */
	public Wzsz() {
	
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
	/** 获取模板 */
	public Integer getMb() {
		return this.mb;
	}
	/** 设置模板 */
	public void setMb(Integer mb) {
		this.mb = mb;
	}
	/** 获取原始数据的Json对象(未替换字典，修改用) */
	public JSONObject getJson() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("mb", mb);
		return obj;
	}
	
	/** 获取数据的Json对象(已替换字典，列表查询用) */
	public JSONObject getJsonInDict() {
		JSONObject obj=new JSONObject();
		obj.put("id", id);
		obj.put("mb", mb);
		return obj;
	}
}
