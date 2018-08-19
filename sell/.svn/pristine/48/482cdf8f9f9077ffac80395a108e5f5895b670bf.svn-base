package com.sky.sell.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.sky.sell.common.enums.ProductStatusEnum;
import com.sky.sell.common.enums.SortEnum;
import com.sky.sell.common.utils.jpa.sort.SortUtils;
import com.sky.sell.pojo.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest {

	@Autowired
	private ProductInfoService productInfoService;
	
	@Test
	public void testSave() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("1234567");
		productInfo.setProductName("香蕉");
		productInfo.setProductPrice(new BigDecimal(3.3));
		productInfo.setProductStock(120);
		productInfo.setProductDescription("很好吃的西瓜");
		productInfo.setProductIcon("http://xx.jpg");
		productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
		productInfo.setCategoryType(2);
		
		productInfoService.save(productInfo);
		
	}

	@Test
	public void testFindOne() {
		ProductInfo productInfo = productInfoService.findOne("123456");
		Assert.assertNotNull(productInfo);
	}

	@Test
	public void testFindAll() {
		PageRequest pageRequest = new PageRequest(0, 3, SortUtils.basicSort(SortEnum.DESC.getOrder(), "createTime"));
		Page<ProductInfo> page = productInfoService.findAll(pageRequest);
		System.err.println(page.getTotalElements()+","+page.getTotalPages());
		for(ProductInfo productInfo :page) {
			System.err.println(productInfo.toString());
		}
	}
	
	@Test
	public void testFindUpAll() {
		List<ProductInfo> productInfos = productInfoService.findUpAll();
		Assert.assertNotEquals(0, productInfos.size());
	}

}
