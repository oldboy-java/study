package com.sky.sell.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 商品
 * @author	刘力
 * @date	2017年12月2日上午10:02:26
 * @version 1.0
 */
@Entity
@Data
public class ProductInfo {

	/** 商品Id **/
	@Id
	private String productId;
	
	 /**商品名称 **/
	private String productName;
	
	/** 商品价格 **/
	private BigDecimal productPrice;
	
	/** 库存 **/
	private Integer productStock;
	
	/** 描述 **/
	private String productDescription;
	
	/** 小图 **/
	private String productIcon;
	
	/** 商品状态, 0 正常  1 下架**/
	private Integer productStatus;
	
	/** 商品类目编号 **/
	private Integer categoryType;
	
	/** 添加时间 **/
	private Date createTime;
}
