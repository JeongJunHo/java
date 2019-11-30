package edu.ssafy.chap01;

import java.lang.invoke.SwitchPoint;

public class Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 13 / 5;
		int jumsu = (int) (Math.random() * 100 % 45 + 1);
		
		System.out.println(jumsu);
		if(jumsu > 90) {
			System.out.println("A");
		}else if(jumsu > 80) {
			System.out.println("B");
		}else if(jumsu > 70) {
			System.out.println("C");
		}else if(jumsu > 60){
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		String str = "Hello";
		switch (str) {
			case "Hello": 
				System.out.println("Hello");
				break;
			case " ":
				break;
			case "  ":
				break;
			case "   ":
				break;
			default:
				break;
		}
	}
}
