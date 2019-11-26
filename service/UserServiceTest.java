package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	public void testFindUserByUserNameAndPassWordPositive() throws UserNotPresentException {
		User user = new User();
		user.setUserName("Janani");
		user.setPassWord("janu");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("Janani", "janu")).thenReturn(user);
		User result = userServiceImpl.findUserByUserNameAndPassWord("Janani", "janu");
		assertEquals("Janani", result.getUserName());
	}

	@Test(expected = UserNotPresentException.class)
	public void testFindUserByUserNameAndPassWordNegative() throws UserNotPresentException {
		User user = new User();
		user.setPassWord("sowmi");
		user.setUserName("sowmiya");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("sowmiya", "sowmi")).thenReturn(null);
		user = userServiceImpl.findUserByUserNameAndPassWord("sowmiya", "sowmi");
	}

	@Test
	public void testLoginUserPositive() {
		UserRequestDto userRequestDto = new UserRequestDto();
		User user = new User();
		userRequestDto.setUserName("Janani");
		userRequestDto.setPassWord("janu");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("Janani", "janu")).thenReturn(user);
		String result = userServiceImpl.loginUser(userRequestDto);
		assertEquals("Login Success", result);
	}

	@Test
	public void testLoginUserNegative() {
		UserRequestDto userRequestDto = new UserRequestDto();
		User user = new User();
		userRequestDto.setUserName("Janani");
		userRequestDto.setPassWord("janu");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("Janani1", "janu1")).thenReturn(user);
		String result = userServiceImpl.loginUser(userRequestDto);
		assertEquals("Login failed", result);
	}

}
