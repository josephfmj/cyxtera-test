/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.mongo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.cyxtera.calculatorapi.redis.model.OperationType;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
public class OperationRequest {
	
	private List<BigDecimal> operands;
	
	private BigDecimal operationResult;
	
	private OperationType operationsType;
	
	private Date operationDate;

	public List<BigDecimal> getResultOperands() {
		return operands;
	}

	public void setResultOperands(List<BigDecimal> operands) {
		this.operands = operands;
	}

	public BigDecimal getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(BigDecimal operationResult) {
		this.operationResult = operationResult;
	}

	public OperationType getOperationsType() {
		return operationsType;
	}

	public void setOperationsType(OperationType operationsType) {
		this.operationsType = operationsType;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

}
