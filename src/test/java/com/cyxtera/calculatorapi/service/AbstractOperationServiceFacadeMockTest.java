package com.cyxtera.calculatorapi.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.cyxtera.calculatorapi.custom.CustomObjectMatcher;
import com.cyxtera.calculatorapi.redis.model.OperationContext;
import com.cyxtera.calculatorapi.redis.repository.OperationContextRespository;
import com.cyxtera.calculatorapi.samples.OperationContextSample;
import com.cyxtera.calculatorapi.service.facade.OperationServiceFacade;
import com.cyxtera.calculatorapi.service.impl.DivideOperation;
import com.cyxtera.calculatorapi.service.impl.ExponentiationOperation;
import com.cyxtera.calculatorapi.service.impl.MultiplicyOperation;
import com.cyxtera.calculatorapi.service.impl.OperationService;
import com.cyxtera.calculatorapi.service.impl.SubstractOperation;
import com.cyxtera.calculatorapi.service.impl.SumOperation;

public class AbstractOperationServiceFacadeMockTest {
	
	@Spy
	protected SumOperation sumOperation;
	
	@Spy
	protected SubstractOperation substractOperation;
	
	@Spy
	protected DivideOperation divideOperation;
	
	@Spy
	protected MultiplicyOperation multiplicyOperation;
	
	@Spy
	protected ExponentiationOperation exponentiationOperation;
	
	@Spy 
	@InjectMocks
	protected OperationService operationService;
	
	@Mock
	protected OperationContextRespository operationContextRespository;
	
	@InjectMocks
	protected OperationServiceFacade operationServiceFacade;
	
	@Before
	public void before() {
		operationService.setProvider();
	}
	
	protected void expectFindOperationContext() {
		
		when(operationContextRespository.findById(anyString()))
		.thenReturn(Optional.ofNullable(OperationContextSample.getInitSessionOperationContext()));
	}
	
	protected void expectFindOperationContextWithOperands() {
		
		when(operationContextRespository.findById(anyString()))
		.thenReturn(Optional.ofNullable(OperationContextSample.getWithOperandOperationContext()));
	}
	
	protected void expectSessionCreationOperationContext() {
		
		when(operationContextRespository.save(argThat(new CustomObjectMatcher<>(OperationContext.class))))
		.thenReturn(OperationContextSample.getInitSessionOperationContext());
	}

}
