package com.cyxtera.calculatorapi.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cyxtera.calculatorapi.service.IMathOperation;

import ch.obermuhlner.math.big.BigDecimalMath;

@Component("pow")
public class ExponentiationOperation implements IMathOperation {

	@Override
	public BigDecimal operate(Optional<BigDecimal> total, BigDecimal operand) {
		return total
				.map(value -> BigDecimalMath.pow(value, operand, MathContext.DECIMAL128))
				.orElse(operand);
	}

}
