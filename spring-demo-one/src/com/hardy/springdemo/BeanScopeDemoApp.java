package com.hardy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {


		// load spring config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-application.xml");
		
		// retreieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
	}

}
