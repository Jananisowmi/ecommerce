package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.entity.StoreReview;
@Repository
public interface StoreReviewRepository extends JpaRepository<ProductStore, Integer> {

	StoreReview findByStoreId(Integer storeId);



}
