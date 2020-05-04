package com.hardy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FootballConfigAssignmentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FootbalConfig.class);
		FortuneService fortuneService = context.getBean("getfootBallFortune",FortuneService.class);
		FootballCoach coach = context.getBean("getFootBallCoach",FootballCoach.class);
		System.out.println(coach.getDaailyWorkout());
		System.out.println(coach.getDailyFortune());
		context.close();
	}

}
