package com.cyxtera.calculatorapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerServiceAspect {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoggerServiceAspect.class);
	
	@Before("com.cyxtera.calculatorapi.aop.LogginPointCuts.logginService")
	public void loggerBeforeOperation(JoinPoint joinPoint) {
		
		LOGGER.info("init proceses the {} ",joinPoint);
	}
	
	@After("com.cyxtera.calculatorapi.aop.LogginPointCuts.logginService")
	public void loggerAfterOperation(JoinPoint joinPoint) {
		
		LOGGER.info("finish proceses the {} ",joinPoint);
	}

}
