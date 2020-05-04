package com.hardy.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.hardy.springdemo.controller.*.*(..))")
	private void forControllerPackage(){}
	
	@Pointcut("execution(* com.hardy.springdemo.service.*.*(..))")
	private void forServicePackage(){}	
	
	@Pointcut("execution(* com.hardy.springdemo.dao.*.*(..))")
	private void forDaoPackage(){}	
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void appFlow(){}

	//add @before advice
	@Before("appFlow()")
	public void before(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println(">> @Before "+method);
		
		//display argumerts
		Object []args = theJoinPoint.getArgs();
		
		for(Object arg:args) {
			System.out.println(">> args"+arg);
		}
		
	}
	
	@AfterReturning(
				pointcut="appFlow()",
				returning="theResult"
			)
	//returning value should be same
	public void afterRetuning(JoinPoint theJoinPoint,Object theResult) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("<< @afterReturning "+method);
		
		//display argumerts
		Object []args = theJoinPoint.getArgs();
		
		for(Object arg:args) {
			System.out.println("<< for args"+arg);
		}
		
		System.out.println("Returns ->"+theResult+"<<<<<<");
		
	}	
	
}
