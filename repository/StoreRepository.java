package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerce.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

	
	
	Store findStoreByStoreId(Integer StoreId);

	Store findByStoreName(String storeName);


}
