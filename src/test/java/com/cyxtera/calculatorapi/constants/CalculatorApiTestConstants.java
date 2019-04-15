package com.cyxtera.calculatorapi.constants;

public enum CalculatorApiTestConstants {
	
	OPERATION_CONTEXT_TEST_ID("123456789"),
	
	FIRST_OPERAND_TEST("6"),
	
	SECOND_OPERAND_TEST("2"),
	
	SUM_RESULT_TEST("8"),
	
	SUBSTRACT_RESULT_TEST("4"),
	
	MULTIPLICATION_RESULT_TEST("12"),
	
	DIVISION_RESULT_TEST("3"),
	
	EXPONENTIATION_RESULT_TEST("36");
	
	private String value;
	
	private CalculatorApiTestConstants(String value){
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
