package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution22 {
	static long Answer;
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution22.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//테스트 케이스 수

		for(int test_case=1; test_case<=T; test_case++){
			N=sc.nextInt(); //배열의 크기 NxN
			int[][] lake=new int[N][N];

			S=sc.nextInt();//소금쟁이(Strider)수
			int[][] strider=new int[S][3];
			for(int k=0; k<S; k++){
				strider[k][0]=sc.nextInt();//행위치
				strider[k][1]=sc.nextInt();//열위치
				strider[k][2]=sc.nextInt();//방향(1:하,2:우)
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			
			//소금쟁이 수 초기화
			Answer = 0;
			
			for (int i = 0; i < strider.length; i++) {
				//x축좌표
				int x = strider[i][0];
				//y축좌표
				int y = strider[i][1];
				//방향 상:1 하:2 좌:3 우:4
				int way = strider[i][2];

				//해당 자리에 소금쟁이가 이미 있다면 바로 종료
				if(lake[x][y] == 1) {
					break;
				}
				//3 2 1 점프
				for (int j = 3; j > 0; j--) {
					//상
					if (way == 1) {
						x -= j;
					//하
					}else if (way == 2) {
						x += j;
					//좌
					}else if (way == 3) {
						y -= j;
					//우
					}else if (way == 4) {
						y += j;
					}
					
					//연못 안이라면
					if(x >= 0 && x < N && y >= 0 && y < N) {
						//소금쟁이가 있다면
						if(lake[x][y] == 1) {
							break;
						}else {
							//마지막 점프에서 살았다면
							if(j == 1) {
								//살아남은 소금쟁이
								Answer++;
								//소금쟁이 표시
								lake[x][y] = 1;
							}
						}
					}else {
						break;
					}
				}
			}

			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
