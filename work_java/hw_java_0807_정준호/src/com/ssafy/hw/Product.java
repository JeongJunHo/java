package com.ssafy.hw;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {
	//제품번호
	private String code;
	//제품명
	private String name;
	//가격
	private int price;
	//재고
	private int stock;
	
	public Product() {
		super();
	}
	public Product(String code, String name, int price, int stock) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 *제품코드 기준 오른차준 정렬(사전순)
	 */
	@Override
	public int compareTo(Product o) {
		return this.code.compareTo(o.getCode());
	}
}
