package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculationStrategy_ThreeForTwoTest {

	private CalculationStrategy_ThreeForTwo csThreeForTwo = new CalculationStrategy_ThreeForTwo();
	
	@Test
	public void correctCalculation (){
		assertThat(csThreeForTwo.calculatePrice(11, BigDecimal.valueOf(3))).isEqualTo(BigDecimal.valueOf(3*(6+2)));
		assertThat(csThreeForTwo.calculatePrice(12, BigDecimal.valueOf(3))).isEqualTo(BigDecimal.valueOf(3*8));
	}
}
