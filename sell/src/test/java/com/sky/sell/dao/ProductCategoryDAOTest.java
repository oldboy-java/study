package com.sky.sell.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sky.sell.pojo.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDAOTest {
	
	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@Test
	public void findOneTest() {
		ProductCategory productCategory = productCategoryDAO.findOne(1);
		Assert.assertNotNull(productCategory);
	}
	
	@Test
	public void saveTest() {
		ProductCategory productCategory =  productCategoryDAO.save(new ProductCategory("女性用品",2));
		Assert.assertNotNull(productCategory);
	}
	
	@Test
	public void findByCategoryTypeInTest() {
		List<Integer> categoryTypeList = new ArrayList<Integer>();
		categoryTypeList.add(1);
		List<ProductCategory> productCategories = productCategoryDAO.findByCategoryTypeIn(categoryTypeList);
		for(ProductCategory productCategory :productCategories) {
			System.err.println(productCategory.getCategoryName());
		}
	}
	
	@Test
	public void updateTest() {
		ProductCategory productCategory =  productCategoryDAO.findOne(1);
		productCategory.setCategoryName("服装");
		productCategory.setUpdateTime(new Date());
		productCategory = productCategoryDAO.save(productCategory);
		Assert.assertNotNull(productCategory);
	}
	
}
