package com.matteo.tonnicchi.appleorange.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findOneByCode(String code);
}
