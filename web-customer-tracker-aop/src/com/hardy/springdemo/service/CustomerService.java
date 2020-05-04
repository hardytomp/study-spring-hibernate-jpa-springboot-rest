package com.hardy.springdemo.service;

import java.util.List;

import com.hardy.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomr(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
