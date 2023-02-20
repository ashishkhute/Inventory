package com.project.IMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project.IMS.entity.Customer;
import com.project.IMS.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(long custId) {
		Optional<Customer> optional = customerRepository.findById(custId);
		Customer customer = null;
		if (optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + custId);
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(long itemcode) {
		customerRepository.deleteById(itemcode);	
	}

	
	}

