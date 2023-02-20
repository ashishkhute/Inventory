package com.project.IMS.service;

import java.util.List;

import com.project.IMS.entity.Customer;




public interface CustomerService {
    
    List<Customer> getAllCustomers();
	
    Customer saveCustomer(Customer customer);
	
    Customer getCustomerById(long itemcode);
	
    Customer updateCustomer(Customer customer);

	void deleteCustomerById(long itemcode);
}

