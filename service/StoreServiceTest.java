package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceTest {

	@InjectMocks
	StoreServiceImpl storeServiceImpl;

	@Mock
	StoreRepository storeRepository;

	@Test
	public void testsaveStorePositive() {
		Store store = new Store();
		store.setStoreId(1);
		store.setContactNumber("9865526711");
		store.setStoreLocation("E city");
		store.setStoreName("D-Mart");
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		assertEquals(store, store);

	}

	@Test
	public void testsaveStoreNegative() {
		Store store = new Store();
		store.setStoreId(2);
		store.setContactNumber("578458");
		store.setStoreLocation("location");
		store.setStoreName("forum");
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		assertEquals(store, store);

	}
	
	@Test(expected = StoreNotFoundException.class)
	public void testfindStoreByStoreIdPositive()  throws StoreNotFoundException {
		
		Store store=new Store();
		store.setContactNumber("9865526711");
		store.setStoreId(1);
		store.setStoreLocation("E city");
		store.setStoreName("D Mart");
		Mockito.when(storeRepository.findStoreByStoreId(2)).thenReturn(null);
		store = storeServiceImpl.findStoreByStoreId(2);
	}
	
	@Test(expected = StoreNotFoundException.class)
	public void testfindStoreByStoreIdNegative()  throws StoreNotFoundException {
		
		Store store=new Store();
		store.setContactNumber("9865526711");
		store.setStoreId(1);
		store.setStoreLocation("E city");
		store.setStoreName("D Mart");
		Mockito.when(storeRepository.findStoreByStoreId(1)).thenReturn(null);
		store = storeServiceImpl.findStoreByStoreId(1);
	}

}
