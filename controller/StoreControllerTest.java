package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTest {
	
	@InjectMocks
	StoreController stockController;
	
	@Mock
	StoreService storeService;
	
	@Test
	public void testsaveStorePositive() {
	Store store=new Store();
	StoreRequestDto  storeRequestDto=new StoreRequestDto();
	storeRequestDto.setStoreName("D-Mart");
	storeRequestDto.setContactNumber("9865526711");
	storeRequestDto.setStoreLocation("E city");
	
	Mockito.when(storeService.saveStore(storeRequestDto)).thenReturn(store);
	Integer result=stockController.saveStore(storeRequestDto).getStatusCodeValue();
	assertEquals(200, result);
	
	
	}
	
	@Test
	public void testsaveStoreNegative() {
	Store store=new Store();
	StoreRequestDto  storeRequestDto=new StoreRequestDto();
	StoreRequestDto  storeRequestDto2=new StoreRequestDto();
	storeRequestDto.setStoreName("dsdf");
	storeRequestDto.setContactNumber("09743");
	storeRequestDto.setStoreLocation("efse");

	Mockito.when(storeService.saveStore(storeRequestDto)).thenReturn(store);
	Integer result=stockController.saveStore(storeRequestDto2).getStatusCodeValue();
	assertEquals(204, result);
	
	
	}

}
