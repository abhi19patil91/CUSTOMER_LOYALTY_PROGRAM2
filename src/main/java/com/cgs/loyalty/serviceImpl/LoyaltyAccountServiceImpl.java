package com.cgs.loyalty.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgs.loyalty.dto.AccountDto;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerAccount;
import com.cgs.loyalty.repository.LoyaltyAccountRepository;
import com.cgs.loyalty.service.LoyaltyAccountService;

@Service
public class LoyaltyAccountServiceImpl implements LoyaltyAccountService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LoyaltyAccountRepository loyaltyAccountRepository;
	
   // save Account
	@Override
	public AccountDto saveAccount(AccountDto accountDto) {
	
		LoyaltyCustomerAccount account = dtoToLoyCustomerAccount(accountDto);
		return loyCustomerAccountToDto(loyaltyAccountRepository.save(account));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// DTO to LoyaltyCustomerAccount
	public LoyaltyCustomerAccount dtoToLoyCustomerAccount(AccountDto accountDto) {

		LoyaltyCustomerAccount accountDetails = this.modelMapper.map(accountDto, LoyaltyCustomerAccount.class);
		return accountDetails;
	}

	// LoyaltyCustomerAccount to DTO
	public AccountDto loyCustomerAccountToDto(LoyaltyCustomerAccount loyCustomerAccount) {

		AccountDto accountDto = this.modelMapper.map(loyCustomerAccount, AccountDto.class);
		return accountDto;
	}

}
