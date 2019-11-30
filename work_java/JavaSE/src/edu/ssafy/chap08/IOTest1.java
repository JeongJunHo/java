package edu.ssafy.chap08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("hello.txt");
		int r = 0;
		while((r = fis.read()) != -1) {
			System.out.print((char)r);
		}
		System.out.println();
		fis.close();
		
		FileOutputStream fos = new FileOutputStream("hellocopy.txt");
		String str = new String("hello ssafy day 안녕하세요");
		fos.write(str.getBytes());
		fos.flush();
		fos.close();
	}
}
