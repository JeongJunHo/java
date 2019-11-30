package edu.ssafy.chap03;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution13_sol_2 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			char[][] area=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			//////////////////////////////
			int[] rows = new int[N];
			int[] columns = new int[N];
			boolean[][] isBuild = new boolean[N][N];
			for(boolean[] row : isBuild) // boolean 초기값이 false라 isBuild의 뜻에 맞게 초기값  true로 변경
				Arrays.fill(row, true);
			final char B = 'B'; // 그냥 심심해서 함
			final char G = 'G';
			final int[][] pos ={ {-1,-1},{-1,0},{0,-1},{0,0},{1,0},{0,1},{1,1},{1,-1},{-1,1}}; // 4중 for문 싫어서 만듬
			int maxFloor = 0; // B가 0개이면 0층 출력용
			
			for(int i=0; i <N; i++) {
				for(int j = 0; j < N; j++) {
					if(area[i][j] == B) {// B이면 행과 열에 B의 숫자 증가
						rows[i]++;
						columns[j]++;
						if(maxFloor == 0) // B가 1개 이상이면 무조건 2층 이상 B가 1개이상 반드시 나온다는 조건이 없어서...
							maxFloor = 2;
					}else { // G 이면 isBuild 배열 갱신
						for(int k = 0; k <pos.length; k++) {
							int x = i + pos[k][0];
							int y = j + pos[k][1];
							if(0<= x && x < N && 0 <= y && y <N)
								isBuild[x][y]=false;//G 기준으로 자신 + 8방향은 못지음
						}
					}
				}
			}
			
			for(int i=0; i <N; i++) {
				for(int j = 0; j < N; j++) {
					if(isBuild[i][j]) { // B이면서 주변에 G가 없는경우
						int floor = rows[i] + columns[j] -1;
						if(floor > maxFloor) {
							maxFloor = floor;
						}
					}
				}
			}
			Answer = maxFloor;
			//////////////////////////////




			System.out.println("#"+test_case+" "+Answer);
		}
	}
}