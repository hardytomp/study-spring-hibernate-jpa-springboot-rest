package com.hardy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hardy.aopdemo.dao.AccountDao;
import com.hardy.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String args[]) {
		//read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDao theAccountDao = context.getBean("accountDao",AccountDao.class);
		//call the method to find accounts
		List<Account> theAccounts = theAccountDao.findAccounts();
		
		System.out.println("\n\nafter returning accounts------");
		System.out.println(theAccounts);
		System.out.println("------");
		
		context.close();
		

	}

}
