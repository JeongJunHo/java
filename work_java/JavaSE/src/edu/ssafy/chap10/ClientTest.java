package edu.ssafy.chap10;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {
	private void start() {
		new ClientThread().start();
	}
	
	private class ClientThread extends Thread{
		@Override
		public void run() {
			go();
		}
	}
	
	private void go() {
		Socket sSock = null;
		try {
			sSock = new Socket("localhost", 7000);
			OutputStream os = sSock.getOutputStream();
			InputStream is = sSock.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(os));
			oos.writeObject(new Message("강사님", "태희", "빈파일을 올리지마"));
			oos.flush();
			oos.writeObject(new Message("강사님2", "태희2", "빈파일을 올리지마2"));
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sSock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ClientTest clientTest = new ClientTest();
		
		clientTest.start();
		
		System.out.println("aaaa");
	}
}
