/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.redis.model;

import java.math.BigDecimal;
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
	
	private String auditoryId;
	
	private List<BigDecimal> operands;
	
	private OperationType operationType;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAuditoryId() {
		return auditoryId;
	}

	public void setAuditoryId(String auditoryId) {
		this.auditoryId = auditoryId;
	}

	public List<BigDecimal> getOperands() {
		return operands;
	}

	public void setOperands(List<BigDecimal> operands) {
		this.operands = operands;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

}
