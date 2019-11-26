
package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.service.ProductStoreService;

@RunWith(MockitoJUnitRunner.Silent.class)

public class ProductStoreControllerTest {

	@InjectMocks
	ProductStoreController productStoreController;

	@Mock
	ProductStoreService productStoreService;

	@Test
	public void testproductDetailsPositive() {
		ProductStore productStore = new ProductStore();
		List<ProductStore> listProductStore = new ArrayList<ProductStore>();
		productStore.setId(1);
		productStore.setPrice(100);
		productStore.setProductId(1);
		productStore.setProductName("Pen");
		productStore.setStoreId(1);
		listProductStore.add(productStore);

		ProductStoreResponseDto ProductStoreResponsesDto = new ProductStoreResponseDto();
		List<ProductStoreResponseDto> listProductStoreResponseDto = new ArrayList<>();
		ProductStoreResponsesDto.setPrice(100);
		ProductStoreResponsesDto.setProductName("Pen");
		ProductStoreResponsesDto.setRating(2);
		ProductStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(ProductStoreResponsesDto);

		Mockito.when(productStoreService.productDetails("pen")).thenReturn(listProductStoreResponseDto);
		Integer result = productStoreController.productDetails("pen").getStatusCodeValue();
		assertEquals(200, result);
	}
	
	@Test
	public void testproductDetailsNegative() {
		ProductStore productStore = new ProductStore();
		List<ProductStore> listProductStore = new ArrayList<ProductStore>();
		productStore.setId(1);
		productStore.setPrice(100);
		productStore.setProductId(1);
		productStore.setProductName("Pen");
		productStore.setStoreId(1);
		listProductStore.add(productStore);

		ProductStoreResponseDto ProductStoreResponsesDto = new ProductStoreResponseDto();
		List<ProductStoreResponseDto> listProductStoreResponseDto = new ArrayList<>();
		ProductStoreResponsesDto.setPrice(100);
		ProductStoreResponsesDto.setProductName("Pen");
		ProductStoreResponsesDto.setRating(2);
		ProductStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(ProductStoreResponsesDto);

		Mockito.when(productStoreService.productDetails("pen")).thenReturn(listProductStoreResponseDto);
		Integer result = productStoreController.productDetails("pencil").getStatusCodeValue();
		assertEquals(204, result);
	}

}
