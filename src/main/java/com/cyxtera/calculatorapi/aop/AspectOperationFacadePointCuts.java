package com.cyxtera.calculatorapi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectOperationFacadePointCuts {
	
	@Pointcut("execution(public com.cyxtera.calculatorapi.service.facade"
			+ ".OperationServiceFacade.createSession(..))")
	public void operationServiceFacadeCreateSession() {}
	
	@Pointcut("execution(public com.cyxtera.calculatorapi"
			+ ".service.facade.OperationServiceFacade.attachOperandToSessionContext(..))")
	public void operationServiceFacadeAttachOperandToSessionContext() {}
	
	@Pointcut("execution(public com.cyxtera.calculatorapi.service.facade"
			+ ".OperationServiceFacade.getOperationResult(..))")
	public void operationServiceFacadeGetOperationResult() {}

}
