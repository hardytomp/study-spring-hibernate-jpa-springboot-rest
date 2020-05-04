package com.hardy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAPIAnalytics {
	
	@Before("com.hardy.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performAPIAAnalytics() {
		System.out.println("\n>>>> performing APi analytics");
	}

}
