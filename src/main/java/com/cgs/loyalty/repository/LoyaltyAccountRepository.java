package com.cgs.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerAccount;

@Repository
public interface LoyaltyAccountRepository extends JpaRepository<LoyaltyCustomerAccount, String> {
	
}
