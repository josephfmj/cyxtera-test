/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.redis.repository;

import org.springframework.data.repository.CrudRepository;

import com.cyxtera.calculatorapi.redis.model.OperationContext;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
public interface OperationContextRespository extends CrudRepository<OperationContext, String>{

}
