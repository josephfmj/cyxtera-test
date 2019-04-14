package com.cyxtera.calculatorapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyxtera.calculatorapi.model.AttachOperandRequest;
import com.cyxtera.calculatorapi.redis.model.OperationContext;
import com.cyxtera.calculatorapi.service.facade.OperationServiceFacade;

@RestController("/operation")
public class CalculatorApiController {
	
	@Autowired
	private OperationServiceFacade operationServiceFacade;
	
	@GetMapping("/session")
	public ResponseEntity<String> getSession(){
		
		final String sessionId = operationServiceFacade.createSession();
		return new ResponseEntity<>(sessionId,HttpStatus.OK);
	}
	
	@GetMapping("/result/{operationType}")
	public ResponseEntity<String> getOperationResult(@PathVariable("operationType") String operationType,
			@RequestParam("session") String sessionId){
		
		final OperationContext context = operationServiceFacade.getOperationResult(operationType, sessionId);
		return new ResponseEntity<>(context.getOperands().get(0).toString(),HttpStatus.OK);
	}
	
	@PostMapping("/operand")
	public ResponseEntity<String> insertOperand(@RequestBody AttachOperandRequest request){
		
		final OperationContext context = operationServiceFacade.attachOperandToSessionContext(request);
		final int lastElement = context.getOperands().size()-1;
		
		return  new ResponseEntity<>(context.getOperands().get(lastElement).toString(),HttpStatus.CREATED);
		
	}

}
