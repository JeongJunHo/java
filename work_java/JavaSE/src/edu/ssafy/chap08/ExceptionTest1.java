package edu.ssafy.chap08;

import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int res = 0;
		try {
			//res = a / b;
			res = div(a, b);
			excep();
			System.out.println("res : " + res);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("0을 입력하시면 안됩니다.");
		} catch (Exception e){
			
		}finally {
			System.out.println("finally block");
		}
		
		System.out.println("program end!!!");
	}
	
	public static void excep() throws Exception {
		
	}
	
	public static int div(int a, int b) throws ArithmeticException {
		int res = 0;
		res = a / b;
		System.out.println("div method end");
		return res;
	}
}

//0으로 나눌 경우 ArithmeticException
