package com.hardy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigurationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class); 
		// get bean from spring container
		Coach coach = context.getBean("tennisCoach",Coach.class);
		// call a method on the bean
		System.out.println(coach.getDaailyWorkout());
		//dailuy fortune
		System.out.println(coach.getDailyFortune());
		
		//close the context
		context.close(); 
	}

}
