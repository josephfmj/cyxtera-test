package com.cyxtera.calculatorapi.service.facade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyxtera.calculatorapi.model.AttachOperandRequest;
import com.cyxtera.calculatorapi.redis.model.OperationContext;
import com.cyxtera.calculatorapi.redis.model.OperationType;
import com.cyxtera.calculatorapi.redis.repository.OperationContextRespository;
import com.cyxtera.calculatorapi.service.IOperationService;

@Service
public class OperationServiceFacade {
	
	private IOperationService operationService;
	
	private OperationContextRespository operationContextRespository;
	
	@Autowired
	public OperationServiceFacade(IOperationService operationService,
			OperationContextRespository operationContextRespository){
		
		this.operationService = operationService;
		this.operationContextRespository = operationContextRespository;
	}
	
	public String createSession() {
		
		OperationContext operationContext = new OperationContext();
		
		Optional<String> sessionId = Optional
				.ofNullable(operationContextRespository.save(operationContext).getSessionId());
		
		return sessionId
				.map(id -> id)
				.orElseThrow(() -> new IllegalArgumentException(""));
		
	}
	
	public OperationContext attachOperandToSessionContext(AttachOperandRequest request) {
		
		Optional<OperationContext> operationContext = operationContextRespository
				.findById(request.getSessionId());
		
		return operationContext
				.map(context -> insertOperand(context,request.getOperand()))
				.map(context -> operationContextRespository.save(context))
				.map(context -> context)
				.orElseThrow(() -> new IllegalArgumentException(""));
	}
	
	public OperationContext getOperationResult(String operationType, String sessionId) {
		
		Optional<OperationContext> operationContext = operationContextRespository
				.findById(sessionId);
		
		return operationContext
				.map(context -> updateContextOperandWithOperationResult(context, operationType))
				.map(context -> operationContextRespository.save(context))
				.map(context -> context)
				.orElseThrow(() -> new IllegalArgumentException(""));
				
	}
	
	private OperationContext insertOperand(OperationContext context, double value) {
		context.attachOperand(new BigDecimal(value));
		return context;
	}
	
	private BigDecimal execOperation(String operationType, List<BigDecimal> operands) {
		
		return operationService
				.execOperation(OperationType.fromLowerValueOf(operationType), operands);
	}
	
	private OperationContext updateContextOperandWithOperationResult(OperationContext context, String operationType) {
		
		BigDecimal result = execOperation(operationType,context.getOperands());
		context.clearOperands();
		context.attachOperand(result);
		
		return context;
	}
}
