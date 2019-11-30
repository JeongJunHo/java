package edu.ssafy.chap04;

public class SingleMain {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.sayHello();
		
		Singleton s1 = Singleton.getInstance();
		s1.sayHello();
		
		if(s == s1) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
	}
}
