package com.hardy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigurationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class); 
		// get bean from spring container
		SwimCoach coach = (SwimCoach) context.getBean("swimCoachs",Coach.class);
		// call a method on the bean
		System.out.println(coach.getDaailyWorkout());
		//dailuy fortune
		System.out.println(coach.getDailyFortune());
		
		//setting values through properties file
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		
		//close the context
		context.close(); 
	}

}
