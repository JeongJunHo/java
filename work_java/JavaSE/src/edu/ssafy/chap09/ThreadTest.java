package edu.ssafy.chap09;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread Start");
		
		MyThread th = new MyThread();
		th.start();
		
		System.out.println("5초간 대기후 MyThread를 종료합니다.");
		Thread.sleep(5*1000);
		th.interrupt();
		System.out.println("Main Thread End");
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 1;
		while(true) {
			try {
				sleep(1*1000);
				System.out.println("MyThread");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("resource release");
				break;
			}
		}
	}
}
