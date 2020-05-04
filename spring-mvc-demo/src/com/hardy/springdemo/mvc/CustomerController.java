package com.hardy.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add an initbinder to convert or trim input strings 
	//remove leading and trailing white spaces
	//resolve issue for our validation
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		System.out.println("initBinder");
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer")Customer theCustomer,
			BindingResult theBindingResult) {
		System.out.println("Process Form binding result"+theBindingResult);
		System.out.println("\n\n");
		System.out.println("last name|"+theCustomer.getLastName()+"|");
		System.out.println("last name"+theCustomer.getFirstName());
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";
	}
	
}
