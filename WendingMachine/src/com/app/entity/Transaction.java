package com.app.entity;

import java.util.Arrays;

public class Transaction {
	
	Product[] products;
    Coin[] change;
    
    
	public Transaction(Product[] products, Coin[] change) {
		super();
		this.products = products;
		this.change = change;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	public Coin[] getChange() {
		return change;
	}
	public void setChange(Coin[] change) {
		this.change = change;
	}
	@Override
	public String toString() {
		return "Transaction [products=" + Arrays.toString(products) + ", change=" + Arrays.toString(change) + "]";
	}
    
    

}
