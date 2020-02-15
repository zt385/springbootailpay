package com.zt.ailpayspringboot.service.imp;

import java.util.List;

import com.zt.ailpayspringboot.mapper.ProductMapper;
import com.zt.ailpayspringboot.pojo.Product;
import com.zt.ailpayspringboot.pojo.ProductExample;
import com.zt.ailpayspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;

	@Override
	public List<Product> getProducts() {

		ProductExample pe = new ProductExample();
		// Criteria pc = pe.createCriteria();
		List<Product> list = productMapper.selectByExample(pe);

		return list;
	}

	@Override
	public Product getProductById(String productId) {

		return productMapper.selectByPrimaryKey(productId);
	}

}
