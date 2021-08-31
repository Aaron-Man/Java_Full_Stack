package com.jinchen.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointCut {

	@Before("getNamePointcut()")
	public void loggingAdvice() {
		System.out.println("Executing loggingAdvice on getName()");
	}

	@Before("getNamePointcut()")
	public void secondAdvice() {
		System.out.println("Executing secondAdvice on getName()");
	}
	
	@Pointcut("execution(public String getName())")
	public void getNamePointcut() {}
	
	@Before("allMethodsPointcut()")
	public void allMethodsPointcut() {
		System.out.println("Before executing service method");
	}
}
