package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.UserOrderDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.entity.UserOrder;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.exception.UserOrderListException;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.UserOrderRepository;
import com.hcl.ecommerce.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserOrderServiceTest {
	
	@InjectMocks
	UserOrderServiceImpl userOrderServiceImpl;

	@Mock
	UserOrderRepository userOrderRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	StoreRepository storeRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	ProductStoreRepository productStoreRepository;
	
	
	@Test
	public void testUserOrder() throws StoreNotFoundException, UserNotPresentException {
		UserOrderDto userOrderDto=new UserOrderDto();
		userOrderDto.setProductName("Pen");
		userOrderDto.setStoreName("D-Mart");
		userOrderDto.setUserId(1);
		
		User user=new User();
		Store store=new Store();
		Product product=new Product();
		product.setProductId(1);
		
		ProductStore productStore=new ProductStore();
		productStore.setPrice(200.00);
		UserOrder userOrder=new UserOrder();
		
		userOrder.setOrderId(1);
		userOrder.setPrice(123);
		userOrder.setProductName("Pen");
		userOrder.setStoreId(1);
		userOrder.setUserId(1);
		userOrder.setStoreName("D Mart");
		userOrder.setUserName("Janani");
		
		Mockito.when(userRepository.findUserByUserId(1)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("D-Mart")).thenReturn(store);
		Mockito.when(productRepository.findProductByProductName("Pen")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStore);
		Mockito.when(userOrderRepository.save(userOrder)).thenReturn(userOrder);
		String result = userOrderServiceImpl.userOrder(userOrderDto);		
		assertEquals("Product succesfully ordered", result);
		
	}
	
	
	@Test(expected = StoreNotFoundException.class)
	public void testUserOrderNegative() throws StoreNotFoundException, UserNotPresentException {
		UserOrderDto userOrderDto=new UserOrderDto();
		userOrderDto.setProductName("Pen");
		userOrderDto.setStoreName("D-Mart");
		userOrderDto.setUserId(1);
		
		User user=new User();
		Store store=new Store();
		Product product=new Product();
		product.setProductId(1);
		
		ProductStore productStore=new ProductStore();
		productStore.setPrice(200.00);
		UserOrder userOrder=new UserOrder();
		
		userOrder.setOrderId(1);
		userOrder.setPrice(123);
		userOrder.setProductName("Pen");
		userOrder.setStoreId(1);
		userOrder.setUserId(1);
		userOrder.setStoreName("D Mart");
		userOrder.setUserName("Janani");
		
		Mockito.when(userRepository.findUserByUserId(1)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("D-Mart")).thenReturn(null);
		Mockito.when(productRepository.findProductByProductName("Pen")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStore);
		Mockito.when(userOrderRepository.save(userOrder)).thenReturn(userOrder);
		String result = userOrderServiceImpl.userOrder(userOrderDto);		
		assertEquals("Product succesfully ordered", result);
		
	}
	
	@Test(expected = UserNotPresentException.class)
	public void testUserOrderNegatives() throws StoreNotFoundException, UserNotPresentException {
		UserOrderDto userOrderDto=new UserOrderDto();
		userOrderDto.setProductName("Pen");
		userOrderDto.setStoreName("D-Mart");
		userOrderDto.setUserId(1);
		
		User user=new User();
		Store store=new Store();
		Product product=new Product();
		product.setProductId(1);
		
		ProductStore productStore=new ProductStore();
		productStore.setPrice(200.00);
		UserOrder userOrder=new UserOrder();
		
		userOrder.setOrderId(1);
		userOrder.setPrice(123);
		userOrder.setProductName("Pen");
		userOrder.setStoreId(1);
		userOrder.setUserId(1);
		userOrder.setStoreName("D Mart");
		userOrder.setUserName("Janani");
		
		Mockito.when(userRepository.findUserByUserId(1)).thenReturn(null);
		Mockito.when(storeRepository.findByStoreName("D-Mart")).thenReturn(store);
		Mockito.when(productRepository.findProductByProductName("Pen")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStore);
		Mockito.when(userOrderRepository.save(userOrder)).thenReturn(userOrder);
		String result = userOrderServiceImpl.userOrder(userOrderDto);		
		assertEquals("Product succesfully ordered", result);
		
	}
	
	
	@Test
	public void testListUserOrder() throws UserNotPresentException, UserOrderListException {
		UserOrder userOrder=new UserOrder();
		List<UserOrder> listuserOrder=new ArrayList<UserOrder>();
		userOrder.setOrderId(1);
		userOrder.setPrice(100);
		userOrder.setProductName("Pen");
		userOrder.setStoreId(1);
		userOrder.setStoreName("D-Mart");
		userOrder.setUserId(1);
		userOrder.setUserName("Janani");
		listuserOrder.add(userOrder);
		
		Mockito.when(userOrderRepository.findByUserId(1)).thenReturn(listuserOrder);
		listuserOrder =userOrderServiceImpl.listUserOrder(1);
		
	}
	
	@Test(expected = UserNotPresentException.class)
	public void testListUserOrderNegative() throws UserNotPresentException, UserOrderListException {
		UserOrder userOrder=new UserOrder();
		List<UserOrder> listuserOrder=new ArrayList<UserOrder>();
		userOrder.setOrderId(1);
		userOrder.setPrice(100);
		userOrder.setProductName("Pen");
		userOrder.setStoreId(1);
		userOrder.setStoreName("D-Mart");
		userOrder.setUserId(1);
		userOrder.setUserName("Janani");
		listuserOrder.add(userOrder);
		
		Mockito.when(userOrderRepository.findByUserId(1)).thenReturn(listuserOrder);
		listuserOrder =userOrderServiceImpl.listUserOrder(null);
		
	}


	@Test(expected = UserOrderListException.class)
	public void testListUserOrdersforNegative() throws UserNotPresentException, UserOrderListException {
		UserOrder userOrder=new UserOrder();
		List<UserOrder> listuserOrder=new ArrayList<UserOrder>();
		userOrder.setOrderId(1);
		userOrder.setPrice(100);
		userOrder.setProductName("Pen");
		userOrder.setStoreId(1);
		userOrder.setStoreName("D-Mart");
		userOrder.setUserId(1);
		userOrder.setUserName("Janani");
		listuserOrder.add(userOrder);
		
		Mockito.when(userOrderRepository.findByUserId(null)).thenReturn(listuserOrder);
		listuserOrder =userOrderServiceImpl.listUserOrder(1);
		
	}

}
