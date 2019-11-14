package com.dxc.demoapp.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dxc.demoapp.backend.dto.ProductPlain;
import com.dxc.demoapp.model.entity.Product;

@Mapper
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	ProductPlain productToProductPlain(Product product);
	
	List<ProductPlain> productToProductPlainList(List<Product> products);

}
