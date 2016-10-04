package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

import java.math.BigDecimal;

public class CalculationStrategy_TwoOneFree implements CalculationStrategy {

	@Override
	public BigDecimal calculatePrice(int productAmount, BigDecimal price) {
		
		long oddRemainder = productAmount%2;
		long evenAmount = productAmount - oddRemainder;
		
		return price
			.multiply(BigDecimal.valueOf(evenAmount/2L))
			.add(price.multiply(BigDecimal.valueOf(oddRemainder)));
		
	}

}
