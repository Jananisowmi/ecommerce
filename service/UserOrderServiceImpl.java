package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class UserOrderServiceImpl implements UserOrderService {
	
	@Autowired
	UserOrderRepository userOrderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	ProductStoreRepository productStoreRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public String userOrder(UserOrderDto userOrderDto) throws StoreNotFoundException,UserNotPresentException {
		User user=userRepository.findUserByUserId(userOrderDto.getUserId());
		if(user!=null) {
		Store store=storeRepository.findByStoreName(userOrderDto.getStoreName());
		if(store!=null) {
		Product product=productRepository.findProductByProductName(userOrderDto.getProductName());
		ProductStore productStore=productStoreRepository.findByProductId(product.getProductId());
		
		UserOrder userOrder=new UserOrder();
		userOrder.setUserId(userOrderDto.getUserId());
		userOrder.setUserName(user.getUserName());
		userOrder.setStoreId(store.getStoreId());
		userOrder.setStoreName(userOrderDto.getStoreName());
		userOrder.setProductName(userOrderDto.getProductName());
		userOrder.setPrice(productStore.getPrice());
		userOrderRepository.save(userOrder);
		}else {
			throw new StoreNotFoundException("Store is not available");
		}
		}else {
			throw new UserNotPresentException("User is not available");
		}
		
		return "Product succesfully ordered";
	}

	@Override
	public List<UserOrder> listUserOrder(Integer userId) throws UserNotPresentException, UserOrderListException {
		if(userId!=null) {
		 List<UserOrder> listOrder=userOrderRepository.findByUserId(userId);
		 if(listOrder.isEmpty()) {
			 throw new UserOrderListException("UserOrder list is empty");
		 }
		return listOrder;
	} else {
		throw new UserNotPresentException("User not Available");

	}	
	
}
}
