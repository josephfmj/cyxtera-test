/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.mongo.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
@Document(collection="operations")
public class OperationsAudit {
	
	@Id
	private ObjectId id;
	
	private String sessionId;
	
	private Date firstSessionDate; 
	
	private Date lastSessionDate;
	
	private List<OperationRequest> operationRequests;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getFirstSessionDate() {
		return firstSessionDate;
	}

	public void setFirstSessionDate(Date firstSessionDate) {
		this.firstSessionDate = firstSessionDate;
	}

	public Date getLastSessionDate() {
		return lastSessionDate;
	}

	public void setLastSessionDate(Date lastSessionDate) {
		this.lastSessionDate = lastSessionDate;
	}

	public List<OperationRequest> getOperationRequests() {
		return operationRequests;
	}

	public void setOperationRequests(List<OperationRequest> operationRequests) {
		this.operationRequests = operationRequests;
	}
	
	public void attachOperationRequest(OperationRequest operationRequest) {
		this.operationRequests.add(operationRequest);
	}
	
	public void removeOperationRequest(OperationRequest operationRequest) {
		this.operationRequests.remove(operationRequest);
	}

}
