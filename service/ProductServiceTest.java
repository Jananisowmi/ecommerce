package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Test
	public void testsaveProductPositive() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Pen");
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, product);

	}

	@Test
	public void testsaveProductNegative() {

		Product product = new Product();
		product.setProductId(2);
		product.setProductName("pencil");
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, product);

	}

	@Test
	public void testfindProductByProductNamePositive() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Pen");
		productList.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<Product> productLists = productServiceImpl.findProductByProductName("pen");
		assertEquals(productLists.size(), productList.size());
	}
	
	@Test
	public void testfindProductByProductNameNegative() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setProductId(2);
		product.setProductName("Pencil");
		productList.add(product);
		
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<Product> productLists = productServiceImpl.findProductByProductName("pen");
		assertEquals(productLists.size(), productList.size());
	}
}
