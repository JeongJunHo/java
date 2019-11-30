package edu.ssafy.chap15;

public class Lambda2 {
	public static void main(String[] args) {
		Calc add = (a,b) -> {return a+b;};
		add.calc(5, 2);
		
		System.out.println(add.calc(5, 2));
		Calc cross = (a,b) -> a*b;
		
		System.out.println(cross.calc(4, 7));
	}
}
