package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/{productName}")
	public ResponseEntity<Product> saveProduct(@RequestParam (name="productName") String productName) {
		Product product=productService.saveProduct(productName);
		if(product==null) {
			return new ResponseEntity<Product> (product,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product> (product,HttpStatus.OK);
		
	}
	
	@GetMapping("/{productName}") 
	public ResponseEntity<List<Product>> getProductName(@RequestParam String productName ) {
		List<Product> product=productService.findProductByProductName(productName);
		if(product.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
		
	}
	

	
}
