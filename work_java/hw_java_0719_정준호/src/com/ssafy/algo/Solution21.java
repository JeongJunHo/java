package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21 {
	static long Answer;
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution21.txt"));
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
			
			//소금쟁이 번호
			Answer = 0;
			
			for (int i = 0; i < strider.length; i++) {
				//x축좌표
				int x = strider[i][0];
				//y축좌표
				int y = strider[i][1];
				//방향 하:1 우:2
				int way = strider[i][2];

				//해당 자리가 이미 다른 소금쟁이가 뛰었다면 바로 종료
				if(lake[x][y] == 1) {
					Answer = i+1;
					break;
				}
				//3 2 1 점프
				for (int j = 3; j > 0; j--) {
					//하
					if (way == 1) {
						x += j;
					//우
					}else if (way == 2) {
						y += j;
					}
					
					//연못 안이라면
					if(x >= 0 && x < N && y >= 0 && y < N) {
						//점프했던 자리라면
						if(lake[x][y] == 1) {
							Answer = i+1;
							break;
						}else {
							//점프위치 표시
							lake[x][y] = 1;
						}
					}else {
						break;
					}
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
