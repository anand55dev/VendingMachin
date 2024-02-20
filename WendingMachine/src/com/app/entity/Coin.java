package com.app.entity;

public class Coin {
	
	 int value;
     private int quantity;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Coin() {
		super();
		
	}
	public Coin(int value, int quantity) {
		super();
		this.value = value;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Coin [value=" + value + ", quantity=" + quantity + "]";
	}
     
     

}
