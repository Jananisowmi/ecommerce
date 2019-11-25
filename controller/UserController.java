package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public ResponseEntity<String> loginUser(@RequestBody UserRequestDto userRequestDto) {
		String user=userService.loginUser(userRequestDto);
		if (user.equals("Login Success")) {
			return new ResponseEntity<String>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(user, HttpStatus.BAD_REQUEST);
		}
	
		
	}
}
