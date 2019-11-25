package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.repository.StoreRepository;

@Service
public class StoreServiceImpl  implements StoreService {
	
	@Autowired
	StoreRepository storeRepository;

	@Override
	public Store saveStore(StoreRequestDto storeRequestDto) {
		Store store=new Store();
		store.setStoreName(storeRequestDto.getStoreName());
		store.setStoreLocation(storeRequestDto.getStoreLocation());
		store.setContactNumber(storeRequestDto.getContactNumber());
		storeRepository.save(store);
		return store;
	}

	@Override
	public Store findStoreByStoreId(Integer StoreId) throws StoreNotFoundException {
		Store store=storeRepository.findStoreByStoreId(StoreId);
		if(store==null) {
			throw new StoreNotFoundException("store is not available");
		}
		return store;
	}

}
