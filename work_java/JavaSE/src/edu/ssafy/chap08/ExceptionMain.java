package edu.ssafy.chap08;

public class ExceptionMain {
	public static void main(String[] args) {
		int i = 4;
		while(i > 0) {
			try {
				calc(2,i);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				System.out.println("i == 0");
				System.out.println(e.getMessage());
				e.printStackTrace();
				e.exceptionSolution();
			}finally{
				i--;
			}
		}
	}
	
	public static void calc(int a, int b) throws MyException {
		if((a-b) == 0) {
			throw new MyException();
		}
		int res = (a+b)/(a-b);
		System.out.println(res);
		System.out.println(b);
	}
}
