package com.cgs.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgs.loyalty.entity.customer.LayaltyCustomerAccount;

public interface LoyaltyAccountRepository extends JpaRepository<LayaltyCustomerAccount, String> {

}
