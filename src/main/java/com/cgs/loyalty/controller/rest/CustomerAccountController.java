package com.cgs.loyalty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.loyalty.dto.AccountDto;
import com.cgs.loyalty.service.LoyaltyAccountService;


@RestController
@RequestMapping(value = "/account")
public class CustomerAccountController {
	
	@Autowired
	private LoyaltyAccountService loyaltyAccountService;
	
	
	@PostMapping("/saveAccount")
	public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto){
		
		AccountDto account = loyaltyAccountService.saveAccount(accountDto);
		
		return new ResponseEntity<AccountDto>(account,HttpStatus.CREATED);
	}
	
	
	

}
