package edu.ssafy.chap06;

// final
// 위치: 클래스, 맴버메소드, 맴버변수
// 클래스의 final: 상속불가
// 메소드의 final: override 불가
// 맴버변수의 final: 

public class FinalTest {
	final String MSG = "Hello";
	
	public final String toString() {
//		MSG = "조미료";
		
		return super.toString();
	}
	
	public static void main(String[] args) {
		
	}
}
