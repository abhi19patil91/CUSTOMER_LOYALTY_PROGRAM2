package com.cgs.loyalty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerTransaction;
import com.cgs.loyalty.util.CreditAmount;

@Repository
public interface LoyaltyTransactionRepository extends JpaRepository<LoyaltyCustomerTransaction, Long> {

	void save(Optional<LoyaltyCustomerTransaction> transaction);

}
