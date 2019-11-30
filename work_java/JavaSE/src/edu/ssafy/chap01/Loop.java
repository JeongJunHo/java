package edu.ssafy.chap01;

public class Loop {
	public static void main(String[] args) {
		boolean flag = true;
		int i = 1;
		while (i<10) {
			System.out.println("2 X " + i + " = " + 2*i);
			i++;
		}
		i = 0;
		do {
			System.out.println("2 X " + i + " = " + 2*i);
			i++;
		} while (i<10);
		
		for (int j = 0; j < 10; j++) {
			System.out.println("2 X " + j + " = " + 2*j);
		}
	}
}
