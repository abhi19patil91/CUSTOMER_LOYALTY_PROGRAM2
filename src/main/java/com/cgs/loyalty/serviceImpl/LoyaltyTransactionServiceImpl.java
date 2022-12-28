package com.cgs.loyalty.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgs.loyalty.dto.TransactionDto;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerDetails;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerTransaction;
import com.cgs.loyalty.repository.LoyaltyCustomerRepository;
import com.cgs.loyalty.repository.LoyaltyTransactionRepository;
import com.cgs.loyalty.service.LoyaltyTransactionService;
import com.cgs.loyalty.util.CreditAmount;
import com.cgs.loyalty.util.DebitAmount;

@Service
public class LoyaltyTransactionServiceImpl implements LoyaltyTransactionService {
	
	@Autowired
	private LoyaltyTransactionRepository transactionRepository;
	
	@Autowired
	private LoyaltyCustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	public void debit(DebitAmount debitAmount) {
		
		Optional<LoyaltyCustomerDetails> customer = customerRepository.findById(debitAmount.getId());
		
//		long debitamount = debitAmount.getDebitAmount();
//		long toatalBalance = customer.get().getCustomerId().getAccoutBalance() - debitamount;	
//		long points = (long) (debitamount * 0.1) ;
//		long totalPoints = customer.get().getCustomerId().getTotalPoints() + points ;
//	
//		LoyaltyCustomerTransaction transaction = new LoyaltyCustomerTransaction();
//		transaction.setDebitingAmoun(debitamount);
//		transaction.setTotalPoints(totalPoints);
//		transaction.setPoints(points);
//		transaction.setTotalAmount(toatalBalance);
//		
//		transactionRepository.save(transaction);
		
	}


	public void addAmount(CreditAmount creditAmount) {

		LoyaltyCustomerTransaction transaction = transactionRepository.findById(creditAmount.getId()).orElse(null);
		
		LoyaltyCustomerTransaction transaction1 = new LoyaltyCustomerTransaction();
		
		transaction1.setCredtingAmount(creditAmount.getCreditAmount());
		transaction1.setDebitingAmoun(transaction.getDebitingAmoun());
		transaction1.setPoints(transaction.getPoints());
		transaction1.setTotalAmount(transaction.getTotalAmount() + creditAmount.getCreditAmount());
		
		
		transactionRepository.save(transaction1);
	}


	public void saveTransaction(LoyaltyCustomerTransaction transaction) {
		
		transactionRepository.save(transaction);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    	// DTO to LoyaltyCustomerTransaction
		public LoyaltyCustomerTransaction dtoToLoyCustomerDetails(TransactionDto transactionDto) {

			LoyaltyCustomerTransaction transactionDetails = this.modelMapper.map(transactionDto, LoyaltyCustomerTransaction.class);
			return transactionDetails;
		}

		// LoyaltyCustomerTransaction to DTO
		public TransactionDto loyCustomerTransactionToDto(LoyaltyCustomerTransaction loyCustomerTransaction) {

			TransactionDto transactionDto = this.modelMapper.map(loyCustomerTransaction, TransactionDto.class);
			return transactionDto;
		}

}
