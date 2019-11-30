package com.ssafy.hw;

public class Refrigerator extends Product {
	private int liter;
	private String type;
	
	public Refrigerator() {
		super();
	}
	public Refrigerator(String code, String name, int price, int stock, int liter, String type) {
		super(code, name, price, stock);
		this.liter = liter;
		this.type = type;
	}
	
	
	
	@Override
	public String toString() {
		return "Refrigerator [liter=" + liter + ", type=" + type + ", toString()=" + super.toString() + "]";
	}
	
	public int getLiter() {
		return liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
