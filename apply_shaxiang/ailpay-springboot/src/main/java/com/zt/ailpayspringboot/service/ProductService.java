package com.zt.ailpayspringboot.service;

import java.util.List;

import com.zt.ailpayspringboot.pojo.Product;

public interface ProductService {

	/**
	 * 获取所有产品列表
	 * @return
	 */
	public List<Product> getProducts();
	
	/**
	 * 根据产品ID查询产品详情
	 * @param productId
	 * @return
	 */
	public Product getProductById(String productId);
}
