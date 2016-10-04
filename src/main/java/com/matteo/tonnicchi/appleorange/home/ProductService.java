package com.matteo.tonnicchi.appleorange.home;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct	
	protected void initialize() {
		save(new Product("apple", "Apple", BigDecimal.valueOf(0.6)));
		save(new Product("orange", "Orange", BigDecimal.valueOf(0.25)));
	}

	public BigDecimal calculatePrice(List<ProductFormEntry> productEntries) {
		BigDecimal price = new BigDecimal(0);
		for(ProductFormEntry productEntry : productEntries){
			price =
				price.add(
					this.getProduct(productEntry.getCode()).getPrice()
						.multiply(BigDecimal.valueOf(productEntry.getAmount())));
		}
		return price;
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

}
