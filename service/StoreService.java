package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.StoreNotFoundException;

public interface StoreService {
	
	Store saveStore(StoreRequestDto storeRequestDto);
	
	Store findStoreByStoreId(Integer StoreId) throws StoreNotFoundException;

}
