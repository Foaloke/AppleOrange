package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculationStrategy_SumTest {

	private CalculationStrategy_Sum csSum = new CalculationStrategy_Sum();
	
	@Test
	public void correctCalculation (){
		assertThat(csSum.calculatePrice(12, BigDecimal.valueOf(3))).isEqualTo(BigDecimal.valueOf(3*12));
	}
}
