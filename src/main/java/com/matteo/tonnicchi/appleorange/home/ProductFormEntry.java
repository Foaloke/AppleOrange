package com.matteo.tonnicchi.appleorange.home;

public class ProductFormEntry {

	private String code = "";
	private String name = "";
	private int amount = 0;
	
	public ProductFormEntry(){
		
	}
	
	public ProductFormEntry(String code, String name, int amount) {
		this.code = code;
		this.name = name;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
