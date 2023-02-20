package com.project.IMS.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.IMS.entity.Customer;
import com.project.IMS.service.CustomerService;



@RestController

public class CustomerController {
   
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	// handler method to handle list customers and return model and view
	@GetMapping("/customers")
	public String listItems(Model model) {
		model.addAttribute("customer", customerService.getAllCustomers());
		return "customers";
	}
	
	@GetMapping("/customers/new")
	public String createCustomerForm(Model model) {
		
		// create item object to hold customer form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "create_customer";
		
	}
	
	@PostMapping("/customers")
	public String saveItem(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/items";
	}
	
	@GetMapping("/customers/edit/{itemcode}")
	public String editItemForm(@PathVariable Long itemcode, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(itemcode));
		return "edit_customer";
	}

	@PostMapping("/customers/{custId}")
	public String updateCustomer(@PathVariable Long custId,
			@ModelAttribute("customer") Customer customer,
			Model model) {
		
		// get item from database by id
		Customer existingCustomer = customerService.getCustomerById(custId);
		existingCustomer.setCustId(custId);
		existingCustomer.setCustName(customer.getCustName());
		existingCustomer.setCustContact(customer.getCustContact());
		existingCustomer.setAddress(customer.getAddress());
		
		
		// save updated item object
		customerService.updateCustomer(existingCustomer);
		return "redirect:/customers";		
	}
	
	// handler method to handle delete item request
	
	@GetMapping("/customers/{custId}")
	public String deleteItem(@PathVariable Long custId) {
		customerService.deleteCustomerById(custId);
		return "redirect:/customers";
	}
    }
