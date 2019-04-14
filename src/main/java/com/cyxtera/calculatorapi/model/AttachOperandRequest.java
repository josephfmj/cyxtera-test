package com.cyxtera.calculatorapi.model;

public class AttachOperandRequest {
	
	private String sessionId;
	
	private double operand;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public double getOperand() {
		return operand;
	}

	public void setOperand(double operand) {
		this.operand = operand;
	}

}
