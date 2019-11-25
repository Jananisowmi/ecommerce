package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.ProductStore;
@Repository
public interface ProductStoreRepository extends JpaRepository<ProductStore, Integer> {
	
//	ProductStore findProductStoreById(Integer id);

	ProductStore findByProductId(Integer productId);

	ProductStore findBystoreId(Integer storeId);

	List<ProductStore> findByProductName(String productName);

}
