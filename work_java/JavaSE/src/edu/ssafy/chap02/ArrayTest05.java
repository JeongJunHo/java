package edu.ssafy.chap02;

public class ArrayTest05 {
	public static void main(String[] args) {
		int [][] arr = new int[3][2];
		int [][] arr1 = {{12,23},{13,41},{42,55}};
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.println(arr1[i][j]);
			}
		}
	}
}
