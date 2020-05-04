package com.hardy.aopdemo.aspect;


import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hardy.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.hardy.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pcdjp) throws Throwable {
		String method = pcdjp.getSignature().toShortString();
				myLogger.info("<< @around starting >>"+method);
				long begin = System.currentTimeMillis();
				
				Object result =null;
				// actual call to the function
				result = pcdjp.proceed();
		
				long end = System.currentTimeMillis();
		
				long duration = end-begin;
				
				myLogger.info("Duration> "+duration/1000 +" seconds");
		
		return result;
	}
	
	
	@Around("execution(* com.hardy.aopdemo.service.*.getFortuneException(..))")
	public Object aroundGetFortuneException(ProceedingJoinPoint pcdjp) throws Throwable {
		String method = pcdjp.getSignature().toShortString();
				myLogger.info("<< @around starting >>"+method);
				long begin = System.currentTimeMillis();
				
				Object result =null;
				// actual call to the function
				try {
					result = pcdjp.proceed();
				} catch (Exception e) {
					// if u dont waant to handle exception
					//result = "no Fortune today man";
					
					//rethrowing exception
					throw e;
				}
		
				long end = System.currentTimeMillis();
		
				long duration = end-begin;
				
				myLogger.info("Duration> "+duration/1000 +" seconds");
		
		return result;
	}
		
	
	
	@After("execution(* com.hardy.aopdemo.dao.AccountDao.findAccounts(..))")	
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info(">> after executing the method finally >>"+method);
		
	}
	
	
	@AfterThrowing(
				pointcut="execution(* com.hardy.aopdemo.dao.AccountDao.findAccounts(..))",
				throwing="theException"
			)
	
	public void afterThrowingFindAccountsAdvice(JoinPoint joinpoint,Throwable theException) {
		String method = joinpoint.getSignature().toShortString();
		myLogger.info("After Throwing on method >> "+method);
		myLogger.info("Excception is >>>"+theException);
	}
	
	
	
	@AfterReturning(
			pointcut="execution(* com.hardy.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result"
	)
	//returning and argument name should be equal
	public void afterReturningFindAccounds(JoinPoint joinPoint,List<Account> result) {
		//print out ehich methods we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Executing @after method >>"+method);
		myLogger.info("Result is"+result);
		
		//modifying the return data
		
		
		//convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("after converting into uppercase"+result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for(Account temp :result) {
			
			//get the upper case
			String upperCaseName = temp.getName().toUpperCase();
			//update the name on list
			temp.setName(upperCaseName);
			
		}

	}

	//this is where we add allo of our related advices for logging
	

	@Before("com.hardy.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n>>>> executing @Before advice on addAccount");
		
		//display the method signature
		String methodSignature = theJoinPoint.getSignature().toShortString();
		myLogger.info("<<method>>");
		myLogger.info(methodSignature);
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgs: args) {
			myLogger.info(tempArgs.toString());
			if(tempArgs instanceof Account) {
				myLogger.info("<<Args...>>");
				Account theAccount = (Account)tempArgs;
				myLogger.info("account name :"+theAccount.getName());
				myLogger.info("account name :"+theAccount.getLevel());
				
			}
			
		}
		
	}
	

	



	
		
}
