package com.ssafy.hw;

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
		return super.toString() + "Refrigerator [liter=" + liter + "]";
	}
	/**
	 * @return the liter
	 */
	public int getLiter() {
		return liter;
	}
	/**
	 * @param liter the liter to set
	 */
	public void setLiter(int liter) {
		this.liter = liter;
	}
}
