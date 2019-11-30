package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution32 {
	static int Answer;
	static int Y, X, N, P;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution32.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // Test case

		// fill up the data
		for (int test_case = 1; test_case <= T; test_case++) {

			Y = sc.nextInt(); // position col
			X = sc.nextInt(); // position row
			N = sc.nextInt(); // number of player

			int[][] room = new int[Y + 1][X + 1];// because start from 1;
			// fill up table
			for (int i = 1; i <= Y; i++) {
				for (int j = 1; j <= X; j++) {
					room[i][j] = sc.nextInt();
				}
			}

			int[][] player = new int[N][3];
			for (int i = 0; i < N; i++) {
				player[i][0] = sc.nextInt(); // coord X
				player[i][1] = sc.nextInt(); // coord Y
				player[i][2] = sc.nextInt(); // steps
			}

			P =sc.nextInt();
			int[][] trap=new int[P][2];
			for(int i = 0; i < P; i++){
				trap[i][0] = sc.nextInt();
				trap[i][1] = sc.nextInt();
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			
			//static이므로 초기화해준다.
			Answer = 0;
			
			//함정설치
			for (int i = 0; i < trap.length; i++) {
				int x = trap[i][0];
				int y = trap[i][1];
				room[x][y] = 0;
			}

			//플레이어 출발
			for (int i = 0; i < player.length; i++) {
				Answer -= 1000;
				//플레이어의 x좌표
				int x = player[i][0];
				//플레이어의 y좌표
				int y = player[i][1];
				//이동가능횟수
				int step = player[i][2];
				
				//이동가능횟수만큼 반복
				for (int j = 1; j <= step; j++) {
					//방향 상:4  하:2  좌:3  우:1
					int direction = room[x][y] / 10;
					//점프칸수
					int jump = room[x][y] % 10;
					
					//우
					if(direction == 1) {
						y += jump;
					//하
					}else if (direction == 2) {
						x += jump;
					//좌
					}else if (direction == 3) {
						y -= jump;
					//상
					}else if (direction == 4) {
						x -= jump;
					}
					
					//경계 테스트
					if(x >= 1 && x <= X && y >= 1 && y <= Y) {
						//함정에 빠졌다면 종료
						if(room[x][y] == 0) {
							break;
						}else {
							//마지막 점프였다면
							if(j == step) {
								//상금
								int reward = room[x][y] * 100;
								//상금합치기
								Answer += reward;
							}
						}
					//경계를 넘어갔을 경우 종료
					}else {
						break;
					}
				}// 이동횟수 for end
			}// 플레이어 for end

			System.out.println("#" + test_case + " " + Answer);
		}

	}
}
