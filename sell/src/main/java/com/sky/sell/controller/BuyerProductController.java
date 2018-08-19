package com.sky.sell.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.sell.dao.ProductCategoryDAO;
import com.sky.sell.pojo.ProductCategory;
import com.sky.sell.pojo.ProductInfo;
import com.sky.sell.service.ProductInfoService;
import com.sky.sell.vo.ProductInfoVO;
import com.sky.sell.vo.ProductVO;
import com.sky.sell.vo.ResultVO;

/**
 * 买家商品
 * @author	刘力
 * @date	2017年12月2日下午7:28:09
 * @version 1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

	@Autowired
	private ProductInfoService productInfoService;
	
	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	
	@GetMapping("/list")
	public ResultVO<ProductVO> list(){
		//查询所有在架商品
		List<ProductInfo> productInfoList = productInfoService.findUpAll();
		
		List<Integer> categoryTypeList = new ArrayList<Integer>();
		for(ProductInfo productInfo:productInfoList) {
			categoryTypeList.add(productInfo.getCategoryType());
		}
		List<ProductVO> productVOList = new ArrayList<ProductVO>();
		//查询所有分类
		List<ProductCategory> productCategories = productCategoryDAO.findByCategoryTypeIn(categoryTypeList);
		for(ProductCategory productCategory:productCategories) {
			ProductVO productVO = new ProductVO();
			productVO.setProductName(productCategory.getCategoryName());
			productVO.setCategoryType(productCategory.getCategoryType());
			
			List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
			
			
			
			productVO.setProductInfoVOList(productInfoVOList);
		}
		
		return null;
		
		Stack<E>
	}
}
