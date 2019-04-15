package com.cyxtera.calculatorapi.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyxtera.calculatorapi.redis.model.OperationType;
import com.cyxtera.calculatorapi.service.IMathOperation;
import com.cyxtera.calculatorapi.service.IOperationService;

@Service
public class OperationService implements IOperationService{
	
	@Autowired
	@Qualifier("sum")
	private IMathOperation sumOperation;
	
	@Autowired
	@Qualifier("substract")
	private IMathOperation substractOperation;
	
	@Autowired
	@Qualifier("divide")
	private IMathOperation divideOperation;
	
	@Autowired
	@Qualifier("multiplicy")
	private IMathOperation multiplicyOperation;
	
	@Autowired
	@Qualifier("pow")
	private IMathOperation exponentiationOperation;
	
	private Map<OperationType, IMathOperation> provider;
	
	private Optional<BigDecimal> result;
	
	@PostConstruct
	public void setProvider() {
		
		this.provider = new HashMap<>();
		this.provider .put(OperationType.SUM, sumOperation);
		this.provider .put(OperationType.SUBSTRACT, substractOperation);
		this.provider .put(OperationType.MULTIPLICATION, multiplicyOperation);
		this.provider .put(OperationType.DIVISION, divideOperation);
		this.provider .put(OperationType.EXPONENTIATION, exponentiationOperation);
		
	}
	
	@Override
	public BigDecimal execOperation(OperationType type, List<BigDecimal> operands) {
		
		this.result = Optional.empty();
		
		operands
		.forEach(operand -> this.result = Optional.ofNullable(this.provider.get(type).operate(result, operand)));
		
		return result
				.map(value -> value)
				.orElse(BigDecimal.ZERO);
	}

}
