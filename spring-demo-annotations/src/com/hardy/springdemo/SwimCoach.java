package com.hardy.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService FortuneService;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")	
	private String team;
	
	public SwimCoach(FortuneService svc) {
		System.out.println("Constructor of SwimCoach");
		FortuneService = svc;
	}
	
	@Override
	public String getDaailyWorkout() {
		return "swim 1000 meters bouy as warmup";
	}

	@Override
	public String getDailyFortune() {
		return FortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
}
