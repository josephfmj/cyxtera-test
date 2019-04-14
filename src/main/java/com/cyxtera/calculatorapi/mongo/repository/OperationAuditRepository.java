/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cyxtera.calculatorapi.mongo.model.OperationsAudit;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
public interface OperationAuditRepository extends MongoRepository<OperationsAudit, String>{

}
