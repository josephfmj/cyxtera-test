package com.cyxtera.calculatorapi.service;

import java.math.BigDecimal;
import java.util.Optional;

@FunctionalInterface
public interface IMathOperation {

	public BigDecimal operate(Optional<BigDecimal> total, BigDecimal operand);
}
