package com.cgs.loyalty.entity.customer;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customer_account" )
public class LoyaltyCustomerAccount {
	
	@Id
	private String accountId;
	private String customerId;
	private Date DateAndTime = new Date();
	private long totalPoints;
	private long accoutBalance;
	
	
	
}
