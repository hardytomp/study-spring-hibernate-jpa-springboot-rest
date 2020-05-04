package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

	//add handler for customer not found exception
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
		
		CustomerErrorResponse obj= new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
															ex.getMessage(),
															System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResponse>(obj,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleAnyException(Exception ex) {
		
		CustomerErrorResponse obj= new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
															ex.getMessage(),
															System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResponse>(obj,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
