package com.hardy.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hardy.aopdemo.dao.AccountDao;
import com.hardy.aopdemo.dao.MembershipDAO;
import com.hardy.aopdemo.service.TrafficFortuneService;

public class AroundWithException {
	
	private static Logger myLogger = Logger.getLogger(AroundWithException.class.getName());

	public static void main(String args[]) {
		//read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n main program");
		
		String data = theFortuneService.getFortuneException();
		
		myLogger.info("fortune is ->"+data);
		
		context.close();
		myLogger.info("\n\nend!!!");
		

	}

}
