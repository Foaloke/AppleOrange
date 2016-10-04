package com.matteo.tonnicchi.appleorange.home;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.matteo.tonnicchi.appleorange.home.calculationstrategy.CalculationStrategyHelper.StrategyCode;

@SuppressWarnings("serial")
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Column(unique=true)
	private String code;

	private BigDecimal price;
	
	private StrategyCode strategyCode;

	protected Product() {
	}

	public Product(String code, String name, BigDecimal price, StrategyCode strategyCode) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.strategyCode = strategyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public StrategyCode getStrategyCode() {
		return strategyCode;
	}

	public void setStrategyCode(StrategyCode strategyCode) {
		this.strategyCode = strategyCode;
	}

}
