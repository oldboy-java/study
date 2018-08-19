package com.sky.sell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sky.sell.common.enums.ProductStatusEnum;
import com.sky.sell.dao.ProductInfoDAO;
import com.sky.sell.pojo.ProductInfo;
import com.sky.sell.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	private ProductInfoDAO productInfoDAO;
	
	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return productInfoDAO.save(productInfo);
	}

	@Override
	public ProductInfo findOne(String productId) {
		return productInfoDAO.findOne(productId);
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return productInfoDAO.findAll(pageable);
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoDAO.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

}
