package com.dxc.demoapp.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.dxc.demoapp.model.entity.Product;

/**
 * ProductRepository
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    
}