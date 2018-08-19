package com.sky.sell.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.sell.dao.ProductCategoryDAO;
import com.sky.sell.pojo.ProductCategory;
import com.sky.sell.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@Override
	@Transactional
	public ProductCategory save(ProductCategory productCategory) {
		return productCategoryDAO.save(productCategory);
	}

	@Override
	public ProductCategory findOne(Integer categoryId) {
		return productCategoryDAO.findOne(categoryId);
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryDAO.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList) {
		return productCategoryDAO.findByCategoryTypeIn(categoryTypeList);
	}

}
