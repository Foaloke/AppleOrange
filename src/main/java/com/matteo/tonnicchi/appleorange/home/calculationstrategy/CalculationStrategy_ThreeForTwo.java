package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

import java.math.BigDecimal;

public class CalculationStrategy_ThreeForTwo implements CalculationStrategy {

	@Override
	public BigDecimal calculatePrice(int productAmount, BigDecimal price) {
		
		long remainder = productAmount%3;
		long amountDivisibleByThree = productAmount - remainder;
		
		return price
			.multiply(BigDecimal.valueOf((amountDivisibleByThree/3L)*2L))
			.add(price.multiply(BigDecimal.valueOf(remainder)));
		
	}

}
