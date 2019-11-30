package edu.ssafy.chap04;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		
	}
	
	static Singleton getInstance() {
		return instance;
	}
	
	public void sayHello() {
		System.out.println("Hello, welcome");
	}
}
