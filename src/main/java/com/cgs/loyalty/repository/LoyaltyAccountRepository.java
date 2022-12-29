package com.cgs.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerAccount;

@Repository
public interface LoyaltyAccountRepository extends JpaRepository<LoyaltyCustomerAccount, String> {
	
    @Query
	LoyaltyCustomerAccount findAccountById(long accountId);

    @Query(value = "SELECT accout_balance FROM customer_accounts WHERE account_id = :accountId" ,nativeQuery = true)
	LoyaltyCustomerAccount findLoyaltyCustomerAccountAccoutBalance(long accountId);
	
//	 @Query(value = "SELECT balance FROM accounts WHERE user_id = :user_id AND account_id = :account_id", nativeQuery = true)
//	   double getAccountBalance(@Param("user_id") int user_id, @Param("account_id") int account_id);
	
}
