package com.sky.sell.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品（包含分类）
 * @author	刘力
 * @date	2017年12月2日下午7:34:58
 * @version 1.0
 */
@Data
public class ProductVO {

	/** 商品 名称 **/
	@JsonProperty("name")
	private String productName;
	
	/** 商品分类 **/
	@JsonProperty("type")
	private Integer categoryType;
	
	@JsonProperty("foods")
	private List<ProductInfoVO> productInfoVOList;
}
