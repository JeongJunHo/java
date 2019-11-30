package com.ssafy.java;

public class AlpaTest2 {
	public static void main(String[] args) {
		char alpa = 'A';
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("   ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print(alpa + "  ");
				alpa = next(alpa);
			}
			System.out.println();
		}
	}
	
	static char next(char alpa) {
		int nextNum = alpa + 1;
		char nextApla = (char)nextNum;
		
		return nextApla;
	}
}
