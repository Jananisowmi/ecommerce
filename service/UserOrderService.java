package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.UserOrderDto;
import com.hcl.ecommerce.entity.UserOrder;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.exception.UserOrderListException;

public interface UserOrderService {
	
	public  String userOrder(UserOrderDto userOrderDto) throws StoreNotFoundException, UserNotPresentException; 
	
	public List<UserOrder> listUserOrder(Integer userId) throws UserNotPresentException, UserOrderListException;

}
