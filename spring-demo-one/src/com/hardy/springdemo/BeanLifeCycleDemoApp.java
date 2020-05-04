package com.hardy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {


		// load spring config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retreieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		System.out.println(alphaCoach == theCoach);
		System.out.println("memoryLocation"+ theCoach);
		System.out.println("memoryLocation"+ alphaCoach);
		context.close();
	}

}
