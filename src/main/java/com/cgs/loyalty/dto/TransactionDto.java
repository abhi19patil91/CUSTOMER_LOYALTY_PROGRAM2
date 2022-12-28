package com.cgs.loyalty.dto;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class TransactionDto {
	
	@Id
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
