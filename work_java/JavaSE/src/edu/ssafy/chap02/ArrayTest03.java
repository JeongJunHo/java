package edu.ssafy.chap02;

public class ArrayTest03 {
	public static void main(String[] args) {
		int a = 100;
		primitiveAdd(a);		
		System.out.println("main a:" + a);
		int[] arr = {3,5,7};
		arrAdd(arr);
		System.out.println("main arr[0]:" + arr[0]);
	}
	
	static void arrAdd(int[] arr) {
		arr[0]++;
		System.out.println("add arr[0]:" + arr[0]);
	}
	
	static void primitiveAdd(int a) {
		a++;
		System.out.println("add a: " + a);
	}
}
