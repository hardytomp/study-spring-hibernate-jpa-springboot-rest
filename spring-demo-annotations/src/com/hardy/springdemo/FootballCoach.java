package com.hardy.springdemo;

public class FootballCoach implements Coach {

	private FortuneService FortuneService;
	
	public  FootballCoach(FortuneService svc) {
		System.out.println("Football caoch constructor!!");
		FortuneService = svc;
	}
	
	
	@Override
	public String getDaailyWorkout() {
		
		return "Do 200 uppies to become like messi";
	}

	@Override
	public String getDailyFortune() {
		return FortuneService.getFortune();
	}

}
