package com.hardy.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hardy.aopdemo.dao.AccountDao;
import com.hardy.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String args[]) {
		//read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		
		AccountDao accDao= context.getBean("accountDao",AccountDao.class);
		
		//ge t the membership bean
		
		//call the business method
		
		accDao.addAccount();
		
		accDao.addMatchOnReturnType();
		
		accDao.addAccount(new Account());
		
		accDao.addAccount(new Account(),true);
		
		accDao.doWork();
		
		
		System.out.println("------");
		
		//ge t the membership bean
		MembershipDAO memDao = context.getBean("membershipDAO",MembershipDAO.class);
		memDao.addAccount();
		
		memDao.goToSleep();
		//close the context
		context.close();
		

	}

}
