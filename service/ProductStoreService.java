package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;

public interface ProductStoreService {
	
	
   public List<ProductStoreResponseDto> productDetails(String productName);
}
