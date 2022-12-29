package com.cgs.loyalty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cgs.loyalty.dto.TransactionDto;
import com.cgs.loyalty.service.LoyaltyTransactionService;
import com.cgs.loyalty.util.CreditAmount;

@RestController
@RequestMapping(value = "/transaction")
public class CustomerTransactionController {
	
	@Autowired
	private LoyaltyTransactionService transactionService;
	
	
	@PostMapping("/initiateTansaction")
	public ResponseEntity<String>  transaction(@RequestBody TransactionDto transactionDto) {
		
		transactionService.initiateTransaction(transactionDto);
		return new ResponseEntity<String>("Account Created with Zero balance",HttpStatus.CREATED);
	}
	
	@PostMapping("/credit")
	public ResponseEntity<String> creditAmount(@RequestBody CreditAmount creditAmount){
		
		transactionService.doCredit(creditAmount);
		String amount = "credited amount : "+ creditAmount.getCreditAmount()+ " Rs";
		return new ResponseEntity<String>(amount,HttpStatus.OK);
	}
	
	
//	@PutMapping("/debit")
//	public String debitAmount(@RequestBody DebitAmount debitAmount) {
//		
//		transactionService.debit(debitAmount);
//		
//		return "debited amount : " + debitAmount.getDebitAmount();
//	}
//	
//	@PostMapping("/addAmount")
//	public String creditAmount(@RequestBody CreditAmount creditAmount) {
//		
//		transactionService.addAmount(creditAmount);
//		return "credited Amount = " + creditAmount.getCreditAmount() ;
//	}
	

}
