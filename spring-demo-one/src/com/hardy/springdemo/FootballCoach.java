package com.hardy.springdemo;

public class FootballCoach implements Coach{

	private FortuneService fortuneService;
	private String team;
	private String emailAddress;
	public String getDailyWorkout(){
		return "U need to score like Messi bouy";
	}

	public  FootballCoach() {
		System.out.println("football coach");
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService svc) {
		System.out.println("inside set function");
		fortuneService = svc;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("setting team");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("setting email address ");
		this.emailAddress = emailAddress;
	}
}
