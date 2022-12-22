package com.cgs.loyalty.service.customer;

import java.util.List;
import com.cgs.loyalty.dto.CustomerDto;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerDetails;

public interface LoyaltyCustomerService {

	// Create Customer
	public CustomerDto save(CustomerDto customerDto);
	
	// Create Customer
	public LoyaltyCustomerDetails save(LoyaltyCustomerDetails customer);

	// Get Customers
	public List<CustomerDto> getAllCustomer();

	// Get Customer
	public CustomerDto getCustomer(String customerId);

	// Update Customer
	public CustomerDto addCustomer(CustomerDto customerDto);

	// Delete Customer
	public void deleteById(String customerId);

	//Evaluate points
	public CustomerDto valuatePoints(CustomerDto customerDto);

	//Deposit ammount
	public CustomerDto deposit(CustomerDto customerDto);

	

}
