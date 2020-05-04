package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//auto wire customer service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer Not found "+customerId);
		}
		
		return theCustomer;
	}
		
	//adding customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	//update the customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//delete the customer
	@DeleteMapping("/customers/{customerId}") 
	public String deleteCustomer(@PathVariable int customerId){
		
		if (customerService.getCustomer(customerId) == null) {
			throw new CustomerNotFoundException("Customer not foung " + customerId );
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id"+customerId;
	}
}
