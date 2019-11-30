package edu.ssafy.chap15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelEx {
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
	
	public static void print(Integer i) {
		System.out.println(i + " : " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("일길동","이길동","삼길동","사길동","오길동","육길동","칠길동","팔길동","구길동");
		List<Integer> intList = Arrays.asList(100,200,300,400,500,600,700,800,900);
		
//		Stream<String> stream = list.stream();
//		stream.forEach(ParallelEx::print);
//		
//		Stream<Integer> stream2 = intList.stream();
//		stream2.forEach(ParallelEx::print);
		
		Stream<String> stream3 = list.parallelStream();
		stream3.forEach(ParallelEx::print);
		
		Stream<Integer> stream4 = intList.parallelStream();
		stream4.forEach(ParallelEx::print);
	}
}
