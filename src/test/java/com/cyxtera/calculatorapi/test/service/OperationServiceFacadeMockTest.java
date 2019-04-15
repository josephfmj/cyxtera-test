package com.cyxtera.calculatorapi.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cyxtera.calculatorapi.redis.model.OperationContext;
import com.cyxtera.calculatorapi.redis.model.OperationType;
import com.cyxtera.calculatorapi.test.constants.CalculatorApiTestConstants;
import com.cyxtera.calculatorapi.test.samples.AttachOperandRequestSample;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationServiceFacadeMockTest extends AbstractOperationServiceFacadeMockTest{
	
	@Test
	public void testDoCreateSession() {
		
		expectSessionCreationOperationContext();
		
		assertThat(operationServiceFacade.createSession())
		.isNotNull()
		.isExactlyInstanceOf(String.class)
		.satisfies(this::validateCreatedSession);
		
	}
	
	@Test
	public void testDoAttachOperand() {
		
		expectFindOperationContext(); 
		
		assertThat(operationServiceFacade
				.attachOperandToSessionContext(AttachOperandRequestSample.getAttachOperandRequestSample()))
		.isNotNull()
		.isExactlyInstanceOf(OperationContext.class)
		.satisfies(this::validateCommonData);
		
	}
	
	@Test
	public void testDoGetSUMResult() {
		
		expectFindOperationContextWithOperands();
		
		assertThat(operationServiceFacade.getOperationResult(OperationType.SUM.name(),
				CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue()))
		.isNotNull()
		.isExactlyInstanceOf(OperationContext.class)
		.satisfies(this::validateCommonData)
		.satisfies(value -> assertThat(value.getLastOperand())
				.isEqualTo(new BigDecimal(CalculatorApiTestConstants.SUM_RESULT_TEST.getValue())));
		
	}
	
	@Test
	public void testDoGetSUBSTRACTResult() {
		
		expectFindOperationContextWithOperands();
		
		assertThat(operationServiceFacade.getOperationResult(OperationType.SUBSTRACT.name(),
				CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue()))
		.isNotNull()
		.isExactlyInstanceOf(OperationContext.class)
		.satisfies(this::validateCommonData)
		.satisfies(value -> assertThat(value.getLastOperand())
				.isEqualTo(new BigDecimal(CalculatorApiTestConstants.SUBSTRACT_RESULT_TEST.getValue())));
		
	}
	
	@Test
	public void testDoGetMULTIPLICATIONResult() {
		
		expectFindOperationContextWithOperands();
		
		assertThat(operationServiceFacade.getOperationResult(OperationType.MULTIPLICATION.name(),
				CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue()))
		.isNotNull()
		.isExactlyInstanceOf(OperationContext.class)
		.satisfies(this::validateCommonData)
		.satisfies(value -> assertThat(value.getLastOperand())
				.isEqualTo(new BigDecimal(CalculatorApiTestConstants.MULTIPLICATION_RESULT_TEST.getValue())));
		
	}
	
	@Test
	public void testDoGetDIVISONResult() {
		
		expectFindOperationContextWithOperands();
		
		assertThat(operationServiceFacade.getOperationResult(OperationType.DIVISION.name(),
				CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue()))
		.isNotNull()
		.isExactlyInstanceOf(OperationContext.class)
		.satisfies(this::validateCommonData)
		.satisfies(value -> assertThat(value.getLastOperand())
				.isEqualTo(new BigDecimal(CalculatorApiTestConstants.DIVISION_RESULT_TEST.getValue())));
		
	}
	
	@Test
	public void testDoGetEXPONENTIATIONResult() {
		
		expectFindOperationContextWithOperands();
		
		assertThat(operationServiceFacade.getOperationResult(OperationType.EXPONENTIATION.name(),
				CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue()))
		.isNotNull()
		.isExactlyInstanceOf(OperationContext.class)
		.satisfies(this::validateCommonData)
		.satisfies(value -> assertThat(value.getLastOperand())
				.isEqualTo(new BigDecimal(CalculatorApiTestConstants.EXPONENTIATION_RESULT_TEST.getValue())));
		
	}
	
	private void validateCreatedSession(String id) {
		
		assertThat(id).isNotEmpty();
		assertThat(id).isEqualTo(CalculatorApiTestConstants.OPERATION_CONTEXT_TEST_ID.getValue());
	}
	
	private void validateCommonData(OperationContext context) {
		
		assertThat(context.getOperands()).isNotEmpty();
		assertThat(context.getSessionId()).isNotBlank();
	}
}
