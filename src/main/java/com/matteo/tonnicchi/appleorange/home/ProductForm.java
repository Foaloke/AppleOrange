package com.matteo.tonnicchi.appleorange.home;

import java.util.ArrayList;
import java.util.List;

public class ProductForm {

	private List<ProductFormEntry> productEntries = new ArrayList<>();

	public ProductForm(){
	}
	
	public List<ProductFormEntry> getProductEntries() {
		return productEntries;
	}

	public void setProductEntries(List<ProductFormEntry> products) {
		this.productEntries = products;
	}
	
}
