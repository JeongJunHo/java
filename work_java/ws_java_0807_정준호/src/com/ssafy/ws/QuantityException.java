package com.ssafy.ws;

public class QuantityException extends Exception {
	
	public QuantityException() {
		super("책 재고 부족");
	}
	
	public void sorry() {
		System.out.println("재고가 부족합니다.");
	}
}
