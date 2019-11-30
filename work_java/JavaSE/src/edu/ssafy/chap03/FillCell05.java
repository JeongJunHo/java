package edu.ssafy.chap03;

import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표의 상하좌우에  1을 표시하기 
 * 입력 :
 *  다음줄 부터 :  배열의 개수  좌표개수  {row좌표, column좌표}*좌표개수
 *  8 4 1 1 3 1 3 3 4 2
 * 
 */
public class FillCell05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int p = sc.nextInt();  //좌표 개수
		for (int i = 1; i <=p; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			////////////////
			/// 처리 코드 작성
			
			map[r][c]=1;
			//위
			if(r > 0) {
				map[r-1][c] = 1;
			}
			//아래
			if (r < N-1) {
				map[r+1][c] = 1;
			}
			//오른쪽
			if (c < N-1) {
				map[r][c+1] = 1;
			}
			//왼쪽
			if (c > 0) {
				map[r][c-1] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
