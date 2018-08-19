package com.sky.sell.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sky.sell.pojo.ProductInfo;

public interface ProductInfoService {
	
	/** 保存 商品 **/
	public ProductInfo save(ProductInfo productInfo);
	
	/** 根据商品Id查询商品 **/
	public ProductInfo findOne(String productId);
	
	/** 分页+排序  查询所有商品 **/
	public Page<ProductInfo> findAll(Pageable pageable);
	
	/** 查询所有上架商品 **/
	public List<ProductInfo> findUpAll();
}
