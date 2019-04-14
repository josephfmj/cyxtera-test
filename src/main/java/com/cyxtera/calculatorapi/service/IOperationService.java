package com.cyxtera.calculatorapi.service;

import java.math.BigDecimal;
import java.util.List;

import com.cyxtera.calculatorapi.redis.model.OperationType;

public interface IOperationService {
	
	public BigDecimal execOperation(OperationType type, List<BigDecimal> operands);

}
