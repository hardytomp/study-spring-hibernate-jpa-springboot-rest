package com.hardy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hardy.aopdemo.dao.AccountDao;
import com.hardy.aopdemo.dao.MembershipDAO;
import com.hardy.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String args[]) {
		//read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\n main program");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("fortune is ->"+data);
		
		context.close();
		

	}

}
