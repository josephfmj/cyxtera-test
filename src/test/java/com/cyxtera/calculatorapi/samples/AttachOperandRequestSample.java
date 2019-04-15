package com.cyxtera.calculatorapi.samples;

import com.cyxtera.calculatorapi.constants.CalculatorApiTestConstants;
import com.cyxtera.calculatorapi.model.AttachOperandRequest;

public class AttachOperandRequestSample {
	
	public static AttachOperandRequest getAttachOperandRequestSample() {
		
		AttachOperandRequest attachOperandRequest = new AttachOperandRequest();
		attachOperandRequest.setSessionId(CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue());
		attachOperandRequest.setOperand(Double.parseDouble(CalculatorApiTestConstants.FIRST_OPERAND_TEST.getValue()));
		
		return attachOperandRequest;
	}

}
