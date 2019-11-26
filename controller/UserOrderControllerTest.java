package com.hcl.ecommerce.controller;

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
import com.hcl.ecommerce.entity.UserOrder;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.exception.UserOrderListException;
import com.hcl.ecommerce.service.UserOrderService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserOrderControllerTest {
	
	@InjectMocks
	UserOrderController userOrderController;
	
	@Mock
	UserOrderService userOrderService;
	
	UserOrderDto userOrderDto=new UserOrderDto();
	
	@Test
	public void testProductOrderPositive() throws StoreNotFoundException, UserNotPresentException {
		userOrderDto.setProductName("Pen");
		userOrderDto.setStoreName("D-Mart");
		userOrderDto.setUserId(1);
		String message="Product succesfully ordered";
		Mockito.when(userOrderService.userOrder(userOrderDto)).thenReturn(message);
		Integer result=userOrderController.productOrder(userOrderDto).getStatusCodeValue();
		assertEquals(200, result);
	}

	
	@Test
	public void testProductOrderNegative() throws StoreNotFoundException, UserNotPresentException {
		userOrderDto.setProductName("Pencil");
		userOrderDto.setStoreName("Forum");
		userOrderDto.setUserId(2);
		String message="Product not ordered";
		Mockito.when(userOrderService.userOrder(userOrderDto)).thenReturn(message);
		Integer result=userOrderController.productOrder(userOrderDto).getStatusCodeValue();
		assertEquals(204, result);
	}
	
	
	@Test
	public void testGetUserOrderPositive() throws UserNotPresentException, UserOrderListException {
		UserOrder userOrder=new UserOrder();
		List<UserOrder> productList= new ArrayList<UserOrder>();
		userOrder.setUserId(1);
		userOrder.setOrderId(1);
		userOrder.setProductName("Lap");
		userOrder.setPrice(5);
		userOrder.setStoreId(152);
		userOrder.setUserName("Janani");
		productList.add(userOrder);
		Integer userId=1;
		Mockito.when(userOrderService.listUserOrder(userId)).thenReturn(productList);
		Integer result=userOrderController.getUserOrder(1).getStatusCodeValue();
		assertEquals(200, result);
	}
	


	@Test
	public void testGetUserOrderNegative() throws UserNotPresentException, UserOrderListException {
		UserOrder userOrder=new UserOrder();
		List<UserOrder> productList= new ArrayList<UserOrder>();
//		userOrder.setUserId(2);
//		userOrder.setOrderId(2);
//		userOrder.setProductName("Pen");
//		userOrder.setPrice(3);
//		userOrder.setStoreId(156);
//		userOrder.setUserName("janu");
//		productList.add(userOrder);
//		Integer userId=2;
		Mockito.when(userOrderService.listUserOrder(1)).thenReturn(productList);
		Integer result=userOrderController.getUserOrder(1).getStatusCodeValue();
		assertEquals(204, result);
	}
	
}
