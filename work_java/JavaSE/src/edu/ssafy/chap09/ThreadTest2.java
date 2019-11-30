package edu.ssafy.chap09;

public class ThreadTest2 {
	public static void main(String[] args) {
		Runnable r = new MyRun();
		Thread th = new Thread(r);
		th.start();
	}
}

class MyRun implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MyRun");
	}
	
}