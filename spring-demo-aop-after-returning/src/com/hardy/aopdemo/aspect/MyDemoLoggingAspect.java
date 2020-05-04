package com.hardy.aopdemo.aspect;


import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	@AfterReturning(
			pointcut="execution(* com.hardy.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result"
	)
	//returning and argument name should be equal
	public void afterReturningFindAccounds(JoinPoint joinPoint,List<Account> result) {
		//print out ehich methods we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @after method >>"+method);
		System.out.println("Result is"+result);
		
		//modifying the return data
		
		
		//convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		System.out.println("after converting into uppercase"+result);
		
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
		System.out.println("\n>>>> executing @Before advice on addAccount");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("<<method>>");
		System.out.println(methodSignature);
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgs: args) {
			System.out.println(tempArgs);
			if(tempArgs instanceof Account) {
				System.out.println("<<Args...>>");
				Account theAccount = (Account)tempArgs;
				System.out.println("account name :"+theAccount.getName());
				System.out.println("account name :"+theAccount.getLevel());
				
			}
			
		}
		
	}
	

	



	
		
}
