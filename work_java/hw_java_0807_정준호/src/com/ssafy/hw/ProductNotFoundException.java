package com.ssafy.hw;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
		super("PRODUCT NOT FOUND");
	}
	
	public void sorry() {
		System.out.println("상품이 없습니다.");
	}
}
