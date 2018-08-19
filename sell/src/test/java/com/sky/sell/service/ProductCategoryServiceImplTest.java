/**
 * <p>Title: ProductCategoryServiceImplTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * @author 刘力
 * @date 2017年11月19日下午6:09:13
 * @version 1.0
 */
package com.sky.sell.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sky.sell.pojo.ProductCategory;

/**
 * @author	刘力
 * @date	2017年11月19日下午6:09:13
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

	@Autowired
	private ProductCategoryService productCategoryService;
	/**
	 * Test method for {@link com.sky.sell.service.impl.ProductCategoryServiceImpl#save(com.sky.sell.pojo.ProductCategory)}.
	 */
	@Test
	public void testSave() {
		ProductCategory productCategory = productCategoryService.save(new ProductCategory("男性专享", 3));
		Assert.assertNotNull(productCategory);
	}

	/**
	 * Test method for {@link com.sky.sell.service.impl.ProductCategoryServiceImpl#findOne(java.lang.Integer)}.
	 */
	@Test
	public void testFindOne() {
		ProductCategory productCategory = productCategoryService.findOne(1);
		Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
	}

	/**
	 * Test method for {@link com.sky.sell.service.impl.ProductCategoryServiceImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<ProductCategory> list = productCategoryService.findAll();
		Assert.assertNotEquals(0,list.size());
	}

	/**
	 * Test method for {@link com.sky.sell.service.impl.ProductCategoryServiceImpl#findByCategoryType(java.util.List)}.
	 */
	@Test
	public void testFindByCategoryType() {
		List<Integer> categoryTypeList = new ArrayList<Integer>();
		categoryTypeList.add(1);
		categoryTypeList.add(3);
		List<ProductCategory> productCategories  = productCategoryService.findByCategoryType(categoryTypeList);
		Assert.assertNotEquals(0,productCategories.size());
	}

}
