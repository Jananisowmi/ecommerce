package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.entity.StoreReview;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.StoreReviewRepository;

@Service
public class ProductStoreServiceImpl implements ProductStoreService {
	@Autowired
	ProductStoreRepository productStoreRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	StoreReviewRepository storeReviewRepository;
	

	

	@Override
	public List<ProductStoreResponseDto> productDetails(String productName) {
		List<ProductStore> productStores=productStoreRepository.findByProductName(productName);
//		List<Store> store=storeRepository.findStoreByStoreId(productStores.set);
		List<ProductStoreResponseDto> productStoreResponseDto=new ArrayList<>();
//		List<StoreReview> storeReviews=storeReviewRepository.findByStoreId(Integer storeId);
		for (ProductStore productStore : productStores) {
			ProductStoreResponseDto  ProductStoreResponsesDto=new ProductStoreResponseDto();
			ProductStoreResponsesDto.setProductName(productStore.getProductName());
			ProductStoreResponsesDto.setStoreId(productStore.getStoreId());
			ProductStoreResponsesDto.setPrice(productStore.getPrice());
//			ProductStoreResponsesDto.setRating(rating);
			productStoreResponseDto.add(ProductStoreResponsesDto);
		}
		return productStoreResponseDto;
	}
	}
			
		

		
		
				
			
		
					
		
	
			
		
			
			
		
		
			
		

		
		

