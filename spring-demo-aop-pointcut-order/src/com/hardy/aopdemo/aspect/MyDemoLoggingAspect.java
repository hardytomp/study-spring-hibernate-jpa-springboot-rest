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
	
	//create a pointcut for getter methods
	@Pointcut("execution(* com.hardy.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//create a pointcut for setter
	@Pointcut("execution(* com.hardy.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcut -> include package ->exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>>> executing @Before advice on addAccount");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performAPIAAnalytics() {
		System.out.println("\n>>>> performing APi analytics");
	}
	
	


	
		
}
