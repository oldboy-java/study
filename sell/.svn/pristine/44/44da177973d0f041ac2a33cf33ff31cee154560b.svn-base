package com.sky.sell.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sky.sell.pojo.ProductInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDAOTest {

	@Autowired
	private ProductInfoDAO productInfoDAO;
	
	@Test
	public void saveTest() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("123456");
		productInfo.setProductName("西瓜");
		productInfo.setProductPrice(new BigDecimal(2.3));
		productInfo.setProductStock(100);
		productInfo.setProductDescription("很好吃的西瓜");
		productInfo.setProductIcon("http://xx.jpg");
		productInfo.setProductStatus(0);
		productInfo.setCategoryType(2);
		
		ProductInfo result = productInfoDAO.save(productInfo);
		Assert.assertNotNull(result);
	}

	@Test
	public void findByProductStatusTest() {
		List<ProductInfo> productInfos = productInfoDAO.findByProductStatus(0);
		Assert.assertNotEquals(0, productInfos.size());
		
	}
}
