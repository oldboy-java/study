package com.sky.sell.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sky.sell.pojo.ProductCategory;

/***
 * 定义ProductCategoryDAO
 * @author	刘力
 * @date	2017年11月19日下午4:44:06
 * @version 1.0
 */
public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Integer> {

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
