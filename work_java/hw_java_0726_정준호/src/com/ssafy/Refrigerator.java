package com.ssafy;

public class Refrigerator extends Product {
	private int liter;
	
	public Refrigerator() {
		super();
	}
	public Refrigerator(String code, String name, int price, int stock, int liter) {
		super(code, name, price, stock);
		this.liter = liter;
	}
	
	
	
	@Override
	public String toString() {
		return "Refrigerator [liter=" + liter +  ", toString()=" + super.toString() + "]";
	}
	
	public int getLiter() {
		return liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
}
