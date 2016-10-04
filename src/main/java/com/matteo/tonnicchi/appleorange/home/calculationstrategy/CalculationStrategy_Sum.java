package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

import java.math.BigDecimal;

public class CalculationStrategy_Sum implements CalculationStrategy {

	@Override
	public BigDecimal calculatePrice(int productAmount, BigDecimal price) {
		
		return price
			.multiply(BigDecimal.valueOf(productAmount));
		
	}

}