package com.sky.sell.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sky.sell.pojo.ProductInfo;

public interface ProductInfoDAO extends JpaRepository<ProductInfo, String> {
	
	 public List<ProductInfo> findByProductStatus(Integer productStatus);
}
