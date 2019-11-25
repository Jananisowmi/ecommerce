package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findUserByUserNameAndPassWord(String userName, String passWord) throws UserNotPresentException {
		User user= userRepository.findUserByUserNameAndPassWord(userName, passWord);
		if(user==null) {
			throw new UserNotPresentException("User not Available");
		}
		 return user;
	}

	@Override
	public String loginUser(UserRequestDto userRequestDto) {
		User user = userRepository.findUserByUserNameAndPassWord(userRequestDto.getUserName(),
				userRequestDto.getPassWord());
		String result = null;
		if (user != null ) {
			result = "Login Success";

		} else {
			result = "Login failed";
		}

		return result;
	}
}
	
	
	

	
	
