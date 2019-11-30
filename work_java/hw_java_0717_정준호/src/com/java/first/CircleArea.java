package com.java.first;

public class CircleArea {
	public static void main(String[] args) {
		int half = 5;
		double area = half * 2 * 3.14;
		
		System.out.println("반지름이 " + half + "Cm인 원의 넓이는  " + String.format("%.1f", area) + "Cm2입니다.");
	}
}
