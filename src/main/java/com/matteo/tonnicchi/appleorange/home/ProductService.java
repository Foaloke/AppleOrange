package com.matteo.tonnicchi.appleorange.home;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.tonnicchi.appleorange.home.calculationstrategy.CalculationStrategyHelper;
import com.matteo.tonnicchi.appleorange.home.calculationstrategy.CalculationStrategyHelper.StrategyCode;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct	
	protected void initialize() {
		save(new Product("apple", "Apple", BigDecimal.valueOf(0.6), StrategyCode.TWOONEFREE));
		save(new Product("orange", "Orange", BigDecimal.valueOf(0.25), StrategyCode.THREEFORTWO));
	}

	public BigDecimal calculatePrice(List<ProductFormEntry> productEntries) {
		
		return productEntries.stream()
			.map(this::calculatePriceAccordingToStrategy)
			.reduce((priceOne,priceTwo) -> priceOne.add(priceTwo))
			.orElse(BigDecimal.valueOf(0));

	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	private Product getProduct(String code) {
		return productRepository.findOneByCode(code);
	}

	private void save(Product product) {
		productRepository.save(product);
	}
	
	private BigDecimal calculatePriceAccordingToStrategy(ProductFormEntry productEntry){
		Product entryProduct = this.getProduct(productEntry.getCode());
		StrategyCode strategyCode = entryProduct.getStrategyCode();
		return CalculationStrategyHelper.strategyFromCode(strategyCode).calculatePrice(productEntry.getAmount(), entryProduct.getPrice());
	}

}
