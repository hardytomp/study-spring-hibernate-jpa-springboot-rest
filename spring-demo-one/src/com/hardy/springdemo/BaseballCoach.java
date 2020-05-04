package com.hardy.springdemo;

public class BaseballCoach implements Coach{
	
	//private field
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService thefortuneService) {
		fortuneService = thefortuneService;
	}
	
	

	public String getDailyWorkout() {
		return "spent 30 mins in football field";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
