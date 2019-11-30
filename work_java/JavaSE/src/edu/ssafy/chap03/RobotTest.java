package edu.ssafy.chap03;

import java.util.Scanner;

public class RobotTest {
	public static void main(String[] args) {
		//S 공백
		//W 벽
		//A B C 로봇
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			String[][] arr = new String[n][n];
			int move = 0;
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j].equals("A")) {
						//우
						for (int k = j+1; k < arr.length; k++) {
							if(arr[i][k].equals("S")) {
								move++;
							}else {
								break;
							}
						}
					}else if(arr[i][j].equals("B")) {
						//우
						for (int k = j+1; k < arr.length; k++) {
							if(arr[i][k].equals("S")) {
								move++;
							}else {
								break;
							}
						}
						//좌
						for (int k = j-1; k >= 0; k--) {
							if(arr[i][k].equals("S")) {
								move++;
							}else {
								break;
							}
						}
					}else if(arr[i][j].equals("C")) {
						//상
						for (int k = j-1; k >= 0; k--) {
							if(arr[k][j].equals("S")) {
								move++;
							}else {
								break;
							}
						}
						//하
						for (int k = j+1; k < arr.length; k++) {
							if(arr[k][j].equals("S")) {
								move++;
							}else {
								break;
							}
						}
						//우
						for (int k = j+1; k < arr.length; k++) {
							if(arr[i][k].equals("S")) {
								move++;
							}else {
								break;
							}
						}
						//좌
						for (int k = j-1; k >= 0; k--) {
							if(arr[i][k].equals("S")) {
								move++;
							}else {
								break;
							}
						}
					}// else if c end
				}// for j end
			}// for i end
			
			System.out.println("#" + tc + " " + move);
		}// for tc end
	}// main end
}
