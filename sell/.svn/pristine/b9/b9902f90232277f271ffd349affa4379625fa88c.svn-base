package com.sky.sell.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="product_category")
@Entity
@Data //生成getter｜setter|toString()
public class ProductCategory {

	public ProductCategory() {
		super();
	}

	public ProductCategory(String categoryName, Integer categoryType) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}
	
	@Id //主键
	@GeneratedValue //自增
	/***类目Id**/
	private Integer categoryId;
	
	/****类目名称***/
	private String categoryName;
	
	/****类目类型****/
	private Integer categoryType;
	
	/***更新时间***/
	private Date updateTime;
	
	/***创建时间***/
	private Date createTime;
	
	
	
	
}
