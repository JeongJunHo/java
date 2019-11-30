package edu.ssafy.chap08;

import java.io.FileNotFoundException;

public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("program start");
		try {
			unChecked();			
		}catch (RuntimeException e) {
			System.out.println("Exception 발생");
		}
		
		try {
			checked();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("program end");
	}
	
	public static void checked() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	public static void unChecked() throws RuntimeException {
		throw new RuntimeException();
	}
}
