package com.hardy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add allo of our related advices for logging
	
	//lets start with @Before advice
	@Pointcut("execution(* com.hardy.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>>> executing @Before advice on addAccount");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAAnalytics() {
		System.out.println("\n>>>> performing APi analytics");
	}
	
	


	
		
}
