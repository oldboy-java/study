package com.imooc.girl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Girl {

	@Id
	@GeneratedValue
	private Integer id;
	private String cupSize;
	
	//給age属性添加验证：如果小于18,则提示错误message
	@Min(value=18,message="未成年少女禁止入内")
	private Integer age;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + "]";
	}
	
	
}
