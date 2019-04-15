package com.cyxtera.calculatorapi.test.samples;

import java.math.BigDecimal;

import com.cyxtera.calculatorapi.redis.model.OperationContext;
import com.cyxtera.calculatorapi.test.constants.CalculatorApiTestConstants;

public class OperationContextSample {
	
	public static OperationContext getInitSessionOperationContext() {
		
		OperationContext operationContext = new OperationContext();		
		operationContext.setSessionId(CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue());
		
		return operationContext;
	}
	
	public static OperationContext getWithOperandOperationContext() {
		
		OperationContext operationContext = new OperationContext();		
		operationContext.setSessionId(CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue());
		operationContext.attachOperand(new BigDecimal(CalculatorApiTestConstants.FIRST_OPERAND_TEST.getValue()));
		operationContext.attachOperand(new BigDecimal(CalculatorApiTestConstants.SECOND_OPERAND_TEST.getValue()));
		return operationContext;
	}

}
