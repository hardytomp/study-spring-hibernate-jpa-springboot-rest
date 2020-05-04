package com.hardy.springbootdemo.springbootdemoapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//inject properties
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")	
	private String teamName;

	
	@GetMapping("/teaminfo")
	public String teamInfo() {
		return "Coach "+coachName+" Team "+teamName;
	}
	//expose "/" that return "Hello world"

	@GetMapping("/")
	public String sayHello() {
		return "Hello world is Hardy and Amalu"+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "juggle 100 today boy";
	}	
}
