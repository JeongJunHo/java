package edu.ssafy.chap15;

public class LambdaTest1 {
	public static void main(String[] args) {
		Printer p;
		
		p = new Printer() {
			@Override
			public void print(String str) {
				// TODO Auto-generated method stub
				System.out.println(str);
			}
			
		};
		
		p.print("Lagacy 방식");
		
		Printer p2 = (String str) -> {
			System.out.println(str);
		};
		p2.print("Lambda1");
		
		Printer p3 = (String str) -> System.out.println(str);System.out.println("ddd");
		p3.print("Lambda2");
		
		Printer p4 = (str) -> System.out.println(str);
		p4.print("Lambda3");
		
		Printer p5 = str -> System.out.println(str);
		p5.print("Lambda4");
		
		new Thread(() -> System.out.println("Hello Thread")).start();
	}
}
