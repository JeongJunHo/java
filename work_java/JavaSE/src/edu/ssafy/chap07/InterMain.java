package edu.ssafy.chap07;

public class InterMain {
	public static void main(String[] args) {
//		InterEx1 s = (InterEx1)new InterSub();
//		s.print();
		
		InterSub s = new InterSub();
		test(s);
	}
	
	public static void test(InterEx3 ex) {
		InterEx1 a = (InterEx1)ex;
	}
}
