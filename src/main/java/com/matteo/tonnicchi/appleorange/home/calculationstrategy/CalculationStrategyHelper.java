package com.matteo.tonnicchi.appleorange.home.calculationstrategy;

public class CalculationStrategyHelper {

	public enum StrategyCode {
		THREEFORTWO, TWOONEFREE, SUM
	}
	
	private static final CalculationStrategy threeForTwo
		= new CalculationStrategy_ThreeForTwo();
	private static final CalculationStrategy twoOneFree
		= new CalculationStrategy_TwoOneFree();
	private static final CalculationStrategy sum
		= new CalculationStrategy_Sum();
	
	public static CalculationStrategy strategyFromCode(StrategyCode code) {
		switch(code){
		case THREEFORTWO:
			return threeForTwo;
		case TWOONEFREE:
			return twoOneFree;
		case SUM:
			return sum;
		default:
			throw new IllegalArgumentException("Can not find a calculation strategy for code "+code);
		}
	}
	
}
