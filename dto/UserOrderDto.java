package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOrderDto {
	
	private Integer userId;
	private String storeName;
	private String productName;

}
