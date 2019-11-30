package com.ssafy.hw;

public class CodeNotFoundException extends Exception {
	public CodeNotFoundException() {
		super("CODE NOT FOUND");
	}
	
	public void sorry() {
		System.out.println("제품코드를 찾을 수 없습니다.");
	}
}
