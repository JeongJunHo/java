package edu.ssafy.chap15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("일길동","이길동","삼길동","사길동","오길동","육길동","칠길동","팔길동","구길동");
		Stream<String> stream = list.stream();
		
//		stream.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//				// TODO Auto-generated method stub
//				System.out.println(t)
//			}
//		});
		
		stream.forEach(t -> System.out.println(t));
	}
}
