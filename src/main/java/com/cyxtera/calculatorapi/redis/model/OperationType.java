/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.redis.model;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
public enum OperationType {
	
	SUM,
	
	SUBSTRACT,
	
	MULTUIPLICATION,
	
	DIVISION,
	
	EXPONENTIATION;
	
	public static OperationType fromLowerValueOf(String value) {
		
		return OperationType.valueOf(value.toUpperCase());
	}
}
