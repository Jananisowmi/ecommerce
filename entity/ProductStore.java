package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product_store")
@Getter
@Setter
public class ProductStore {
	
	@Id
	private Integer id;
	private Integer productId;
	private String productName;
	private Integer storeId;
	private double price;
	
	 

}
