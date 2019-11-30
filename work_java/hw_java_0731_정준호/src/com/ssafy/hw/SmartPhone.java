package com.ssafy.hw;

public class SmartPhone extends Product {

	/**
	 * 
	 */
	public SmartPhone() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param name
	 * @param price
	 * @param stock
	 */
	public SmartPhone(String code, String name, int price, int stock) {
		super(code, name, price, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SmartPhone [toString()=" + super.toString() + "]";
	}
}
