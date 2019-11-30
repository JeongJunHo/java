package edu.ssafy.chap08;

public class MyException extends Exception {
	public MyException() {
		super("MyException");
	}
	
	public void exceptionSolution() {
		System.out.println("예외가 해결됩니다. 죽지않아요.");
	}
}
