package edu.ssafy.chap01;

public class Oper1 {
	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		if((2 > 5) & (x++ > y)) {
			y++;
		}
		System.out.println("x = " + x + ", y = " + y);
		
		x = 0;
		y = 0;
		if ((2>5) && (x++ > y)) {
			y++;
		}
		System.out.println("x = " + x + ", y = " + y);
	}
}
