package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	StoreService  storeService;
	
	@PostMapping("")
	public ResponseEntity<Store> saveStore(@RequestBody StoreRequestDto storeRequestDto) {
		Store store=storeService.saveStore(storeRequestDto);
		return new ResponseEntity<Store>(store,HttpStatus.OK);
		
	}

}
