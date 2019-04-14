package com.cyxtera.calculatorapi.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cyxtera.calculatorapi.service.IMathOperation;

@Component("divide")
public class DivideOperation implements IMathOperation {

	@Override
	public BigDecimal operate(Optional<BigDecimal> total, BigDecimal operand) {
		return total
				.map(value -> value.divide(operand))
				.orElse(operand);
	}

}
