package com.cgs.loyalty.dto;

import java.util.Date;
import javax.persistence.Id;
import lombok.Data;

@Data
public class AccountDto {

	@Id
	private String accountId;
	private String customerId;
	private Date DateAndTime = new Date();
	private long totalPoints = 0;
	private long accoutBalance = 0;
	
}
