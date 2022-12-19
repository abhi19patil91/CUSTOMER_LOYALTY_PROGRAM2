package com.cgs.loyalty.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.loyalty.entity.customer.LayaltyCustomerAccount;
import com.cgs.loyalty.repository.LoyaltyAccountRepository;

@Service
public class LoyaltyAccountService {

	@Autowired
	private LoyaltyAccountRepository loyaltyAccountRepository;

    // save account
	public LayaltyCustomerAccount save(LayaltyCustomerAccount account) {
		
		
		
		
		
		
		return loyaltyAccountRepository.save(account);

	}

	public void delete(String account_id) {
		
		
		loyaltyAccountRepository.deleteById(account_id);
	}
	
	

	public void transaction(LayaltyCustomerAccount account) {
	
		LayaltyCustomerAccount savedAccount = loyaltyAccountRepository.findById(account.getAccountId()).orElse(null);
		
		savedAccount.setDebitedBalance(account.getDebitedBalance());
		savedAccount.setAccoutBalance(savedAccount.getAccoutBalance()-account.getDebitedBalance());
		savedAccount.setDebitedPoints(account.getDebitedBalance()*2);
		savedAccount.setInitialPoints(savedAccount.getInitialPoints()+account.getDebitedBalance()*2);
		
		loyaltyAccountRepository.save(savedAccount);
		
	}

}
