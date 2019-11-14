package com.dxc.demoapp.backend.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.demoapp.backend.dto.ProductPlain;
import com.dxc.demoapp.backend.mapper.ProductMapper;
import com.dxc.demoapp.model.entity.Product;
import com.dxc.demoapp.model.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductPlain> list() {
		List<ProductPlain> result = new ArrayList<>();
		
		Iterator<Product> entities = productRepository.findAll().iterator();
		
		while (entities.hasNext()) {
			Product entity = entities.next();

			result.add(ProductMapper.INSTANCE.productToProductPlain(entity));
		}
		
		return result;
	}

}
