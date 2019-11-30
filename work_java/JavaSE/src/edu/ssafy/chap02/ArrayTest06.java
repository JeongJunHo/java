package edu.ssafy.chap02;

public class ArrayTest06 {
	public static void main(String[] args) {
		int[][] arr = new int[3][];
		
		arr[0] = new int[3];
		arr[1] = new int[5];
		arr[2] = new int[2];
		
		arr[1][3] = 5;
		
		int[][] k = {{1,2,3,4,5,6,7,8}, {2,3,4,5}, {6,8}};
		
		for (int i = 0; i < k.length; i++) {
			for (int j = 0; j < k[i].length; j++) {
				System.out.print(k[i][j]+" ");
			}
			System.out.println();
		}
	}
}
