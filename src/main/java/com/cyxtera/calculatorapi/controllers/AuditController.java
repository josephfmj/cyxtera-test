package com.cyxtera.calculatorapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cyxtera.calculatorapi.mongo.model.OperationsAudit;
import com.cyxtera.calculatorapi.mongo.repository.OperationAuditRepository;

@RestController("/auditory")
public class AuditController {
	
	@Autowired
	private OperationAuditRepository operationAuditRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<OperationsAudit>> getAllOperationAudit(){
		
		return new ResponseEntity<>(operationAuditRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{auditoriId}")
	public ResponseEntity<OperationsAudit> findById(@PathVariable("auditoriId") String auditoriId){
		
		return operationAuditRepository.findById(auditoriId)
				.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
