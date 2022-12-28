package com.cgs.loyalty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.loyalty.entity.customer.LoyaltyCustomerTransaction;
import com.cgs.loyalty.serviceImpl.LoyaltyTransactionServiceImpl;
import com.cgs.loyalty.util.CreditAmount;
import com.cgs.loyalty.util.DebitAmount;

@RestController
@RequestMapping(value = "/transaction")
public class CustomerTransactionController {
	
	@Autowired
	private LoyaltyTransactionServiceImpl transactionService;
	
	
	@PostMapping("/saveTransaction")
	public String transaction(@RequestBody LoyaltyCustomerTransaction transaction) {
		transactionService.saveTransaction(transaction);
		return "created";
	}
	
	
	@PutMapping("/debit")
	public String debitAmount(@RequestBody DebitAmount debitAmount) {
		
		transactionService.debit(debitAmount);
		
		return "debited amount : " + debitAmount.getDebitAmount();
	}
	
	@PostMapping("/addAmount")
	public String creditAmount(@RequestBody CreditAmount creditAmount) {
		
		transactionService.addAmount(creditAmount);
		return "credited Amount = " + creditAmount.getCreditAmount() ;
	}
	
	
	

}
