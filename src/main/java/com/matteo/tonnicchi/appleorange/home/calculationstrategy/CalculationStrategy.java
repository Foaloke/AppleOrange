package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

import java.math.BigDecimal;

public interface CalculationStrategy {
	BigDecimal calculatePrice(int productAmount, BigDecimal price);
}
