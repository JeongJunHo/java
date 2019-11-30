package edu.ssafy.chap08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTest3 {
	public static void main(String[] args) throws Exception {
//		FileOutputStream fos = new FileOutputStream("hello.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("hello.txt")));
		
		bw.write("Hello 안녕 아이오테스트 !!!");
		bw.flush();
		bw.close();
		
//		FileInputStream fis = new FileInputStream("hello.txt");
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("hello.txt")));
		
		String str = new String();
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
	}
}
