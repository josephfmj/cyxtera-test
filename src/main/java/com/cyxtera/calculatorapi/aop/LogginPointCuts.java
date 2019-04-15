package com.cyxtera.calculatorapi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogginPointCuts {
	
	@Pointcut("execution(* com.cyxtera.calculatorapi..*.*(..))")
	public void logginService() {}

}
