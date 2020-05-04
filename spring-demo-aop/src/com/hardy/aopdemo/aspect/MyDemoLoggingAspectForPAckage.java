package com.hardy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectForPAckage {

	//@Before("execution( * com.hardy.aopdemo.dao.*(..))") will not work
	
	//@Before("execution( * *(..))") is working
	@Before("execution( * com.hardy.aopdemo.dao.*.*(..))")
	public void paackageAspect() {
		System.out.println("\n>>>> package aspect...");
	}
	

	
		
}
