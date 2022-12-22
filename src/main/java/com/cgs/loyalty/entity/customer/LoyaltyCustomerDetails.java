package com.cgs.loyalty.entity.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_Loyalty1")
public class LoyaltyCustomerDetails {

	@Id
	@Column(name = "customer_id")
	private String customerId;
	private String name;
	private String mobileNo;
	private String email;
	private String dob;
	private String customerType;
	private String rating;
	private String channelOfRegistration;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_customerId", nullable = false)
	private LayaltyCustomerAccount customerAccount;
}
