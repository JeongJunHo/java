package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution13 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = 0;
			N = sc.nextInt();
			char[][] area=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////

			//8방좌표 좌상 상 우상 좌 우 좌하 하 우하
			int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int floor = 0;
					boolean isG = false;
					
					if(area[i][j] == 'B') {
						for (int k = 0; k < pos.length; k++) {
							int x = i + pos[k][0];
							int y = j + pos[k][1];

							//초과검사
							if(x >= 0 && x < N && y >= 0 && y < N) {
								if(area[x][y] == 'G') {
									isG = true;
									break;
								}
							}
						}
						
						if (isG) {
							floor = 2;
							if(Answer < floor) {
								Answer = floor;
							}
						}else {
							for (int k = 0; k < N; k++) {
								if(area[i][k] == 'B') {
									floor++;
								}
								if(area[k][j] == 'B') {
									floor++;
								}
							}
							floor--;
							if(Answer < floor) {
								Answer = floor;
							}
						}
					}
				}
			}

			System.out.println("#"+test_case+" "+Answer);
		}
	}
}