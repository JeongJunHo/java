package com.ssafy.hw;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("DUPLICATE ERROR");
	}
	
	public void sorry() {
		System.out.println("이미 등록된 제품코드입니다.");
	}
}
