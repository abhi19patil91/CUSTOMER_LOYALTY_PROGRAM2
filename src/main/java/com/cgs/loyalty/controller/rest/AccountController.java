package com.cgs.loyalty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.loyalty.entity.customer.LayaltyCustomerAccount;
import com.cgs.loyalty.service.customer.LoyaltyAccountService;

@RestController
@RequestMapping(value = "/account/")
public class AccountController {
	
	@Autowired
	private LoyaltyAccountService loyaltyAccountService;
	
	@PostMapping("/saveAccount")
	public ResponseEntity<LayaltyCustomerAccount> saveAccount(@RequestBody LayaltyCustomerAccount account ) {
		
		LayaltyCustomerAccount savedAccount = loyaltyAccountService.save(account);
		return new ResponseEntity<LayaltyCustomerAccount>(savedAccount,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletes/{account_id}")
	public void deleteAccount(@PathVariable("account_id") String account_id) {
		
		loyaltyAccountService.delete(account_id);
		
	}
	
	@PutMapping("/transaction")
	public void doTransaction(@RequestBody LayaltyCustomerAccount account) {
		
		loyaltyAccountService.transaction(account);
		
		
	}

}
