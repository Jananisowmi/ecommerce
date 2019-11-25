package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotPresentException;

public interface UserService {
	
     User findUserByUserNameAndPassWord(String userName,String passWord) throws UserNotPresentException;
	
	 public String loginUser(UserRequestDto userRequestDto);

}
