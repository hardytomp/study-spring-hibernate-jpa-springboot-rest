package com.hardy.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach{

	public TennisCoach() {
		System.out.println("TennisCoach default constructor");
	}
//filed injection using reflection
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	//if both starting characters are caps no need to conver to lowercase see exmaple here
/*	@Qualifier("RESTFortuneService")*/
	
	
/*	// constructor injection
	@Autowired
	public  TennisCoach( FortuneService svc) {
		fortuneService = svc;
	}*/
	
	
	@Override
	public String getDaailyWorkout() {
		return "Practice u r back hand";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	// setter injection
/*	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setting the fortune service");
		this.fortuneService = fortuneService;
	}*/
	// method injection
/*	@Autowired
	public void methodinjectionFortuneService(FortuneService fortuneService) {
		System.out.println("method injection setting the fortune service");
		this.fortuneService = fortuneService;
	}*/
	
	// define my init menthod
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("My startup stuff");
	}
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("My cleanup stuff");
	}
}
