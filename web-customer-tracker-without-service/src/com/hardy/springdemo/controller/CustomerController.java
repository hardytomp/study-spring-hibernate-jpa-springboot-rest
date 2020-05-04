package com.hardy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hardy.springdemo.dao.CustomerDAO;
import com.hardy.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject DAO into this controller
	
	@Autowired
	private CustomerDAO customerDAO;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	//@PostMapping("/list") //will throw error because only get requests are coming
	public String listCustomers(Model theModel) {
		
		//get the customers from DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		//add customers to the model
		
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
	}
}
