package edu.ssafy.chap03;

import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3  1 1
 * 
 */
public class FillCell02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();

		////////////////
		/// 처리 코드 작성
//		map[r][c]=1;
//		map[r-1][c] = 1;
//		map[r+1][c] = 1;
//		map[r][c-1] = 1;
//		map[r][c+1] = 1;
		
		//8방                      상         하         좌         우        우상     우하       좌하        좌상
		int[][] pos = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,1},{1,-1},{-1,-1}};
		int nc=0,nr=0;
		for (int i = 0; i < pos.length; i++) {
			nr = r + pos[i][0];
			nc = c + pos[i][1];
			map[nr][nc] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
