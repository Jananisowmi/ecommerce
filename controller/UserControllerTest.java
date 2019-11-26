package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	
	@Test
	public void testLoginUserPositive() {
		UserRequestDto userRequestDto=new UserRequestDto();
		
		
		userRequestDto.setPassWord("janu");
		userRequestDto.setUserName("Janani");
		
		String message="Login Success";
		Mockito.when(userService.loginUser(userRequestDto)).thenReturn(message);
		Integer result=userController.loginUser(userRequestDto).getStatusCodeValue();
		assertEquals(200, result);
	}
	
	@Test
	public void testLoginUserNegative() {
		UserRequestDto userRequestDto=new UserRequestDto();

//		userRequestDto.setPassWord("janu");
//		userRequestDto.setUserName("Janani");
		
		String message="Login Success";
		Mockito.when(userService.loginUser(userRequestDto)).thenReturn(message);
		Integer result=userController.loginUser(userRequestDto).getStatusCodeValue();
		assertEquals(200, result);
	}
	}
	




