package edu.ssafy.chap02;

public class ArrayTest04 {
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		int[] tarr = new int[5];
		System.out.println(arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//얕은 복사
//		tarr = arr;
//		System.out.println();
//		System.out.println(tarr.length);
//		tarr[0] = 100;
//		System.out.println(arr[0]);
		
		//깊은복사
		for (int i = 0; i < arr.length; i++) {
			tarr[i] = arr[i];
		}
		System.out.println(tarr.length);
		for (int i = 0; i < tarr.length; i++) {
			System.out.print(tarr[i] + " ");
		}
		
		System.arraycopy(arr, 0, tarr, 1, 3);
		System.out.println();
		for (int i = 0; i < tarr.length; i++) {
			System.out.print(tarr[i] + " ");
		}
		
		System.out.println();
		
		for (int a : tarr) {
			System.out.println(a + " ");
		}
	}
}
