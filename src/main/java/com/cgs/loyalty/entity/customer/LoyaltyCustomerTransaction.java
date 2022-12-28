package com.cgs.loyalty.entity.customer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_transaction")
public class LoyaltyCustomerTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tranceId;
	private String accountId;
	private String customerId;
	private Date dateAndTime= new Date();
	private double points=0;
	private double totalPoints=0;
	private double debitingAmoun=0;
	private double credtingAmount=0;
	private double totalAmount=0;
	
}
