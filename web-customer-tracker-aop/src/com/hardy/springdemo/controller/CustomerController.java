package com.hardy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardy.springdemo.dao.CustomerDAO;
import com.hardy.springdemo.entity.Customer;
import com.hardy.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject  customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	//@PostMapping("/list") //will throw error because only get requests are coming
	public String listCustomers(Model theModel) {
		
		//get the customers from service
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to the model
		
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
	
	
	
	@GetMapping("/showFormForAdd") 
	public String showFormForAdd(Model model) {
		
		//create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomr(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id,Model model) {
		
		// get the customer from db
		Customer customer = customerService.getCustomer(id);
		
		// set the customere as a model for attribure to prepopulate the form
		model.addAttribute("customer",customer);
		
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		//delete customer
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
}
