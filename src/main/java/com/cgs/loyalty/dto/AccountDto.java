package com.cgs.loyalty.dto;

import java.util.Date;

import javax.persistence.Id;

import com.cgs.loyalty.entity.customer.LoyaltyCustomerDetails;
import lombok.Data;

@Data
public class AccountDto {

	
	@Id
	private String id;
	private Date DateAndTime = new Date();
	private long initialPoints;
	private long debitedPoints;
	private long accoutBalance;
	private long creditedBalance;
	private long debitedBalance;
	
	private LoyaltyCustomerDetails details;
}
