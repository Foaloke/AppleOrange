package com.matteo.tonnicchi.appleorange.home;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.matteo.tonnicchi.appleorange.home.calculationstrategy.CalculationStrategyHelper.StrategyCode;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	private static final String APPLE_CODE = "apple";
	private static final String APPLE_NAME = "Apple";
	private static final BigDecimal APPLE_PRICE = BigDecimal.valueOf(5);
	private static final StrategyCode APPLE_STRATEGY = StrategyCode.SUM;

	private static final String ORANGE_CODE = "orange";
	private static final String ORANGE_NAME = "Orange";
	private static final BigDecimal ORANGE_PRICE = BigDecimal.valueOf(7);
	private static final StrategyCode ORANGE_STRATEGY = StrategyCode.SUM;
	
	private static final Product APPLE_MOCK = new Product(APPLE_CODE, APPLE_NAME, APPLE_PRICE, APPLE_STRATEGY);
	private static final Product ORANGE_MOCK = new Product(ORANGE_CODE, ORANGE_NAME, ORANGE_PRICE, ORANGE_STRATEGY);
	
	@InjectMocks
	private ProductService productService = new ProductService();

	@Mock
	private ProductRepository productRepositoryMock;
	
	@Before
	public void init() {
		when(productRepositoryMock.findOneByCode(APPLE_CODE))
			.thenReturn(APPLE_MOCK);
		when(productRepositoryMock.findOneByCode(ORANGE_CODE))
			.thenReturn(ORANGE_MOCK);
	}
	
	@Test
	public void shouldInitializeWithTwoDemoProducts() {
		// act
		productService.initialize();
		// assert
		verify(productRepositoryMock, times(2)).save(any(Product.class));
	}

	@Test
	public void shouldCalculatePrice(){
		// arrange
		int appleAmount = 1;
		int orangeAmount = 3;
		List<ProductFormEntry> productEntries = new ArrayList<>();
		productEntries.add(new ProductFormEntry(APPLE_CODE, APPLE_NAME, appleAmount));
		productEntries.add(new ProductFormEntry(ORANGE_CODE, APPLE_NAME, orangeAmount));
		// act
		BigDecimal total = productService.calculatePrice(productEntries);
		// assert
		BigDecimal applesPrice = APPLE_PRICE.multiply(BigDecimal.valueOf(appleAmount));
		BigDecimal orangesPrice = ORANGE_PRICE.multiply(BigDecimal.valueOf(orangeAmount));
		assertThat(total).isEqualTo(applesPrice.add(orangesPrice));
	}
	
}
