package com.cyxtera.calculatorapi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectOperationFacadePointCuts {
	
	@Pointcut("execution(* com.cyxtera.calculatorapi.service.facade.OperationServiceFacade.createSession (..))")
	public void operationServiceFacadeCreateSession() {}
	
	@Pointcut("execution(* com.cyxtera.calculatorapi.service.facade.OperationServiceFacade.attachOperandToSessionContext (..))")
	public void operationServiceFacadeAttachOperandToSessionContext() {}
	
	@Pointcut("execution(* com.cyxtera.calculatorapi.service.facade.OperationServiceFacade.getOperationResult (..))")
	public void operationServiceFacadeGetOperationResult() {}

}
