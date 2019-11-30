package edu.ssafy.chap09;

public class ThreadTest3 {
	void go() {
		Thread th = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("run");
			}
		};
		th.start();

		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void main(String[] args) {
		new ThreadTest3().go();
	}
	
}
