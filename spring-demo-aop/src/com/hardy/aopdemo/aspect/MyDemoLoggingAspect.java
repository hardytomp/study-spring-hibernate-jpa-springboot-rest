package com.hardy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add allo of our related advices for logging
	
	//lets start with @Before advice
	
	//@Before("execution(public void com.hardy.aopdemo.dao.AccountDao.addAccount())")
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>>> executing @Before advice on addAccount");
	}
	

	@Before("execution(public void add*(com.hardy.aopdemo.Account))")
	//should be fully qualified name or use with wild cards
//	@Before("execution(public void add*(Account))")
	public void addAccountAdvice() {
		System.out.println("\n>>>> executing adding with account ");
	}	
	
	@Before("execution(public void add*(com.hardy.aopdemo.Account, ..))")
	//should be fully qualified name or use with wild cards
//	@Before("execution(public void add*(Account))")
	public void addAccountAdviceWithinfiniteNoArgs() {
		System.out.println("\n>>>> executing adding with infinite args ");
	}	
	
		
}
