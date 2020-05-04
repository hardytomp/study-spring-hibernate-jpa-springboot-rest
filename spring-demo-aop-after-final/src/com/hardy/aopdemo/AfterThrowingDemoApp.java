package com.hardy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hardy.aopdemo.dao.AccountDao;
import com.hardy.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String args[]) {
		//read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDao theAccountDao = context.getBean("accountDao",AccountDao.class);
		//call the method to find accounts
		
		List<Account> theAccounts = null;
		try {
			boolean tripWire = true;
			theAccounts = theAccountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Got Exception in  main"+e.getMessage());
			//e.printStackTrace();
		}
		
		System.out.println("\n\nafter throwing exception------");
		System.out.println(theAccounts);
		System.out.println("------");
		
		context.close();
		

	}

}
