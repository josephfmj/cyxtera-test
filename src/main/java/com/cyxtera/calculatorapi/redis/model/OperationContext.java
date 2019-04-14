/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.redis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
@RedisHash
public class OperationContext {
	
	@Id
	private String sessionId;
	
	private List<BigDecimal> operands;
	
	private OperationType operationsType;
	
	public OperationContext() {
		
		this.operands = new ArrayList<>();
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public List<BigDecimal> getOperands() {
		return operands;
	}

	public void setOperands(List<BigDecimal> operands) {
		this.operands = operands;
	}
	
	public void attachOperand(BigDecimal value) {
		this.operands.add(value);
	}
	
	public void clearOperands() {
		this.operands.clear();
	}
	
	public BigDecimal getLastOperand() {
		
		final int lastOperand = this.operands.size()-1;
		return this.operands.get(lastOperand);
	}

	public OperationType getOperationsType() {
		return operationsType;
	}

	public void setOperationsType(OperationType operationsType) {
		this.operationsType = operationsType;
	}
}
