package com.hardy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {
	
	
	//lets start with @Before advice
	@Pointcut("execution(* com.hardy.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create a pointcut for getter methods
	@Pointcut("execution(* com.hardy.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create a pointcut for setter
	@Pointcut("execution(* com.hardy.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut -> include package ->exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	

}
