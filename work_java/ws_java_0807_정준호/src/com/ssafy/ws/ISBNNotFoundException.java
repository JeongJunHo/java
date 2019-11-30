package com.ssafy.ws;

public class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException() {
		super("ISBN NOT FOUND");
	}
	
	public void sorry() {
		System.out.println("해당 책은 존재하지 않습니다.");
	}
}
