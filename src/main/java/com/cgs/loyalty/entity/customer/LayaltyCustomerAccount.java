package com.cgs.loyalty.entity.customer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_account" )
public class LayaltyCustomerAccount {
	
	@Id
	@Column(name = "account_id")
	private String accountId;
	private Date DateAndTime=new Date();
	private long initialPoints=0;
	private long creditedPoints;
	private long debitedPoints;
	private long accoutBalance=5000;
	private long creditedBalance;
	private long debitedBalance;
	
	
	
	
//	@OneToOne
//	@JoinTable(name = "customer_id")
//	private LoyaltyCustomerDetails loyaltyCustomerDetails;

}
