package com.cgs.loyalty.service.customer;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.loyalty.advice.ErrorDetails;
import com.cgs.loyalty.dto.CustomerDto;
import com.cgs.loyalty.entity.customer.LayaltyCustomerAccount;
import com.cgs.loyalty.entity.customer.LoyaltyCustomerDetails;
import com.cgs.loyalty.exception.BadRequestException;
import com.cgs.loyalty.repository.LoyaltyCustomerRepository;
import com.cgs.loyalty.util.CustomerValidator;

@Service
public class LoyaltyCustomerServiceImp implements LoyaltyCustomerService {

	@Autowired
	private LoyaltyCustomerRepository customerLoyaltyRepository;

	@Autowired
	private CustomerValidator customerValidator;

	@Autowired
	private ModelMapper modelMapper;

	// Save customer
	@Override
	public CustomerDto save(CustomerDto customerDto) {

		List<ErrorDetails> errors = customerValidator.validateToCreateCustomerRequest(customerDto);

		if (errors.size() > 0) {
			throw new BadRequestException(errors);
		}

		LoyaltyCustomerDetails customer = dtoToLoyCustomerDetails(customerDto);
		LoyaltyCustomerDetails savedCustomer = customerLoyaltyRepository.save(customer);
		return loyCustomerDetailsToDto(savedCustomer);
	}

	// get all customer
	@Override
	public List<CustomerDto> getAllCustomer() {

		List<LoyaltyCustomerDetails> customers = customerValidator.checkListEmpty();
		List<CustomerDto> dtoCustomers = customers.stream().map(customer -> loyCustomerDetailsToDto(customer))
				.collect(Collectors.toList());
		return dtoCustomers;
	}

	// get customer
	@Override
	public CustomerDto getCustomer(String customerId) {

		LoyaltyCustomerDetails customer = customerValidator.checkCustomerPresentOrNot(customerId);
		return loyCustomerDetailsToDto(customer);
	}

	// Update customer
	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {

		LoyaltyCustomerDetails customer = customerValidator.checkCustomerPresentOrNot(customerDto);

		customer.setName(customerDto.getName());
		customer.setMobileNo(customerDto.getMobileNo());
		customer.setEmail(customerDto.getEmail());
		customer.setDob(customerDto.getDob());
		customer.setCustomerType(customerDto.getCustomerType());
		customer.setRating(customerDto.getRating());
		customer.setChannelOfRegistration(customerDto.getChannelOfRegistration());

		LoyaltyCustomerDetails customer1 = customerLoyaltyRepository.save(customer);
		return loyCustomerDetailsToDto(customer1);
	}

	// delete customer
	@Override
	public void deleteById(String customerId) {

		LoyaltyCustomerDetails customer = customerValidator.checkCustomerPresentOrNot(customerId);
		customerLoyaltyRepository.deleteById(customer.getCustomerId());

	}

	// Dto to LoyaltyCustomerDetails
	public LoyaltyCustomerDetails dtoToLoyCustomerDetails(CustomerDto customerDto) {

		LoyaltyCustomerDetails customerDetails = this.modelMapper.map(customerDto, LoyaltyCustomerDetails.class);
		return customerDetails;
	}

	// LoyaltyCustomerDetails to Dto
	public CustomerDto loyCustomerDetailsToDto(LoyaltyCustomerDetails loyCustomerDetails) {

		CustomerDto customerDto = this.modelMapper.map(loyCustomerDetails, CustomerDto.class);
		return customerDto;
	}

	@Override
	public LoyaltyCustomerDetails save(LoyaltyCustomerDetails customer) {

		return customerLoyaltyRepository.save(customer);
	}

	@Override
	public CustomerDto valuatePoints(CustomerDto customerDto) {

		LoyaltyCustomerDetails account = customerLoyaltyRepository.findById(customerDto.getCustomerId()).orElse(null);

		long balance = account.getCustomerAccount().getAccoutBalance()
				- customerDto.getCustomerAccount().getDebitedBalance();

		long points = (long) (customerDto.getCustomerAccount().getDebitedBalance() * (0.1));
		long totalPoints = (long) (customerDto.getCustomerAccount().getDebitedBalance() * (0.1)
				+ account.getCustomerAccount().getInitialPoints());

		LayaltyCustomerAccount account1 = new LayaltyCustomerAccount();
		account1.setAccoutBalance(balance);
		account1.setDebitedPoints(points);
		account1.setInitialPoints(totalPoints);
		account1.setDebitedBalance(customerDto.getCustomerAccount().getDebitedBalance());
		account1.setId(customerDto.getCustomerAccount().getId());

		LoyaltyCustomerDetails accountt = new LoyaltyCustomerDetails();
		accountt.setCustomerId(customerDto.getCustomerId());
		accountt.setCustomerAccount(account1);

		customerLoyaltyRepository.save(accountt);

		return loyCustomerDetailsToDto(accountt);
	}

	@Override
	public CustomerDto deposit(CustomerDto customerDto) {

		LoyaltyCustomerDetails account = customerLoyaltyRepository.findById(customerDto.getCustomerId()).orElse(null);

		long creditAmmount = (customerDto.getCustomerAccount().getCreditedBalance());
		long totalAmmount = (customerDto.getCustomerAccount().getCreditedBalance()
				+ account.getCustomerAccount().getCreditedBalance());

		LayaltyCustomerAccount account1 = new LayaltyCustomerAccount();
		account1.setAccoutBalance(totalAmmount);
		account1.setCreditedBalance(creditAmmount);
		account1.setId(customerDto.getCustomerAccount().getId());

		LoyaltyCustomerDetails accountt = new LoyaltyCustomerDetails();
		accountt.setCustomerId(customerDto.getCustomerId());
		accountt.setCustomerAccount(account1);

		customerLoyaltyRepository.save(accountt);

		return loyCustomerDetailsToDto(accountt);
	}

}
