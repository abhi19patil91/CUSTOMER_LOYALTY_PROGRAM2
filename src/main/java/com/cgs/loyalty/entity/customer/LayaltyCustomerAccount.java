package com.cgs.loyalty.entity.customer;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_account" )
public class LayaltyCustomerAccount {
	
	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private Date DateAndTime = new Date();
	private long initialPoints;
	private long debitedPoints;
	private long accoutBalance=5000;
	private long creditedBalance;
	private long debitedBalance;
	
	@OneToOne(mappedBy = "customerAccount", fetch = FetchType.LAZY)
	private LoyaltyCustomerDetails details;
	
}
