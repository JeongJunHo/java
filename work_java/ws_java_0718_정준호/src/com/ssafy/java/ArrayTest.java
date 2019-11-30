package com.ssafy.java;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		//배열생성
		int[] arr = {34, 23, 64, 25, 12, 75, 22, 88, 53, 37};
		//배열출력
		print(arr);
		//배열합계
		total(arr);
		//배열평균
		average(arr);
		//최소값
		minimum(arr);
	}

	static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static void total(int[] arr) {
		int total = 0;
		
		for (int i : arr) {
			total += i;
		}
		
		System.out.println("배열의 합 : " + total);
	}
	
	static void average(int[] arr) {
		int total = 0;
		
		for (int i : arr) {
			total += i;
		}
		
		System.out.println("배열의 평균 : " + total / arr.length);
	}
	
	static void minimum(int[] arr) {
		Arrays.sort(arr);
		System.out.println("배열의 최소값 : " + arr[0]);
	}
}
