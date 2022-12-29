package com.cgs.loyalty.service;

import com.cgs.loyalty.dto.TransactionDto;
import com.cgs.loyalty.util.CreditAmount;

public interface LoyaltyTransactionService {

	TransactionDto initiateTransaction(TransactionDto transactionDto);

	void doCredit(CreditAmount creditAmount);

}
