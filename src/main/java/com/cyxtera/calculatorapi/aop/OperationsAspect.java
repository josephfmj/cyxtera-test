package com.cyxtera.calculatorapi.aop;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyxtera.calculatorapi.mongo.model.OperationRequest;
import com.cyxtera.calculatorapi.mongo.model.OperationsAudit;
import com.cyxtera.calculatorapi.mongo.repository.OperationAuditRepository;
import com.cyxtera.calculatorapi.redis.model.OperationContext;
import com.cyxtera.calculatorapi.redis.repository.OperationContextRespository;

@Aspect
@Component
public class OperationsAspect {
	
	@Autowired
	private OperationAuditRepository operationAuditRepository;
	
	@Autowired
	private OperationContextRespository operationContextRespository;
	
	@AfterReturning(pointcut = "com.cyxtera.calculatorapi.aop.AspectOperationFacadePointCuts"
			+ ".operationServiceFacadeCreateSession()", returning = "sessionId")
	public void auditSessionCreation(Object sessionId) {
		
		final String toSaveSessionId = String.valueOf(sessionId);
		
		OperationsAudit operationsAudit = new OperationsAudit();
		operationsAudit.setFirstSessionDate(new Date());
		operationsAudit.setOperationRequests(Arrays.asList(new OperationRequest()));
		operationsAudit.setSessionId(toSaveSessionId);		
		
		Optional<OperationsAudit> savedOperationsAudit = Optional
				.ofNullable(operationAuditRepository.save(operationsAudit));
		
		if(!savedOperationsAudit.isPresent()) {
			throw new IllegalArgumentException("Auditory not found");
		}
	}
	
	@AfterReturning(pointcut = "com.cyxtera.calculatorapi.aop.AspectOperationFacadePointCuts"
			+ ".operationServiceFacadeAttachOperandToSessionContext()", returning = "context")
	public void auditAttachOperand(Object context) {
		
		final OperationContext operationContext = (OperationContext) context;
		
		if(ObjectUtils.anyNotNull(operationContext)) {
			
			operationContextRespository.save(operationContext);
			
			Optional<OperationsAudit> operationsAudit = operationAuditRepository
					.findBySessionId(operationContext.getSessionId());
			
			operationsAudit
			.map(value -> updateOperationsAuditWithOperand(value, operationContext))
			.map(value -> operationAuditRepository.save(value))
			.map(value -> value)
			.orElseThrow(() -> new IllegalArgumentException("Auditory not found"));
			
		}else{
			
			throw new IllegalArgumentException("Context not found");
		}		
		
		
	}
	
	@AfterReturning(pointcut = "com.cyxtera.calculatorapi.aop.AspectOperationFacadePointCuts"
			+ ".operationServiceFacadeGetOperationResult()", returning = "context")
	public void auditOperationResult(Object context) {
		
		final OperationContext operationContext = (OperationContext) context;
		
		if(ObjectUtils.anyNotNull(operationContext)) {
			
			operationContextRespository.save(operationContext);
			
			Optional<OperationsAudit> operationsAudit = operationAuditRepository
					.findBySessionId(operationContext.getSessionId());
			
			operationsAudit
			.map(value -> updateOperationsAuditWithOperationResult(value,operationContext))
			.map(value -> operationAuditRepository.save(value))
			.map(value -> value)
			.orElseThrow(() -> new IllegalArgumentException("Auditory not found"));
			
		}else{
			
			throw new IllegalArgumentException("Context not found");
		}
		
	}
	
	private OperationsAudit updateOperationsAuditWithOperand(OperationsAudit operationsAudit,
			OperationContext operationContext) {
		
		operationsAudit.setLastSessionDate(new Date());
		operationsAudit
		.getLastOperationRequest()
		.attachOperand(operationContext.getLastOperand());
		
		return operationsAudit;
	}
	
	private OperationsAudit updateOperationsAuditWithOperationResult(OperationsAudit operationsAudit,
			OperationContext operationContext) {
		
		Date date =new Date();
		operationsAudit.setLastSessionDate(date);
		operationsAudit.getLastOperationRequest().setOperationsType(operationContext.getOperationsType());
		operationsAudit.getLastOperationRequest().setOperationResult(operationContext.getLastOperand());
		operationsAudit.getLastOperationRequest().setOperationDate(date);
		operationsAudit.attachOperationRequest(new OperationRequest());
		operationsAudit
		.getLastOperationRequest()
		.attachOperand(operationContext.getLastOperand());
		
		return operationsAudit;
	}

}
