package com.dxc.demoapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.demoapp.backend.dto.ProductPlain;
import com.dxc.demoapp.backend.service.ProductService;

/**
 * ProductsController
 */
@RestController
@RequestMapping("api/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;

    @CrossOrigin
	@GetMapping("/list")
    public List<ProductPlain> list() {

        return productService.list();
    }
}