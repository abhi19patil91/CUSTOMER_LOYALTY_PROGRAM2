package com.cgs.loyalty.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.cgs.loyalty.dto.TransactionDto;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerAccount;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerTransaction;
import com.cgs.loyalty.repository.LoyaltyAccountRepository;
import com.cgs.loyalty.repository.LoyaltyTransactionRepository;
import com.cgs.loyalty.service.LoyaltyTransactionService;
import com.cgs.loyalty.util.CreditAmount;

@Service
public class LoyaltyTransactionServiceImpl implements LoyaltyTransactionService {

	@Autowired
	private LoyaltyTransactionRepository transactionRepository;
	
	@Autowired
	private LoyaltyAccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TransactionDto initiateTransaction(TransactionDto transactionDto) {

		LoyaltyCustomerTransaction transaction = transactionRepository
				.save(dtoToLoyCustomerTransaction(transactionDto));

		return loyCustomerTransactionToDto(transaction);
	}
	
	@Override
	public void doCredit(CreditAmount creditAmount) {
	       
		LoyaltyCustomerAccount Account = accountRepository.findLoyaltyCustomerAccountAccoutBalance(creditAmount.getAccountId());
		

		
		
	}

	// DTO to LoyaltyCustomerTransaction
	public LoyaltyCustomerTransaction dtoToLoyCustomerTransaction(TransactionDto transactionDto) {

		LoyaltyCustomerTransaction transactionDetails = this.modelMapper.map(transactionDto,
				LoyaltyCustomerTransaction.class);
		return transactionDetails;
	}

	// LoyaltyCustomerTransaction to DTO
	public TransactionDto loyCustomerTransactionToDto(LoyaltyCustomerTransaction loyCustomerTransaction) {

		TransactionDto transactionDto = this.modelMapper.map(loyCustomerTransaction, TransactionDto.class);
		return transactionDto;
	}

	

}
