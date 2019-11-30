package edu.ssafy.chap08;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest2 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("hello.txt");
		
		
		int read = 0;
		while((read=fr.read()) != -1) {
			System.out.print((char)read);
		}
		System.out.println();
		
		FileWriter fw = new FileWriter("hellocopy.txt");
		String str = new String("Hello Ssafy hello 하핳하하핳");
		fw.write(str.toCharArray());
		fw.flush();
		fw.close();
	}
}
