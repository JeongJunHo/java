package edu.ssafy.chap08;

import java.io.File;

public class FileInfo {
	public static void main(String[] args) {
		String name = "hello.txt";
//		String name = "src/edu/ssafy/chap08/iotest.txt";
		File f = new File(name);
		if(f.exists()) {
			System.out.println(f.getName());
			System.out.println(f.getPath());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.canWrite());
			System.out.println(f.canRead());
			System.out.println(f.length());
		}else{
			System.out.println("hello.txt는 존재하지 않습니다.");
		}
	}
}
