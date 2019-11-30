package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int weight = sc.nextInt();
		
		int formula = weight + 100 - height;

		System.out.println("비만수치는 " + formula + "입니다.");
		
		if(formula > 0) {
			System.out.println("당신은 비만이군요.");
		}else {
			System.out.println("당신은 정상이군요.");
		}
	}
}
