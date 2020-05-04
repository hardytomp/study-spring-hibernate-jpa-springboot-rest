package com.hardy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class setterrDemoApp {

	public static void main(String[] args) {
		//load spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		FootballCoach coach = context.getBean("myFootballCoach", FootballCoach.class);
		//call methods on bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());
		//colose context
		context.close();
	}

}
