package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStoreResponseDto {
	
//	private Integer productId;
	private String productName;
	private Integer storeId;
//	private String storeName;
	
	private double price;
	private Integer rating;


}
