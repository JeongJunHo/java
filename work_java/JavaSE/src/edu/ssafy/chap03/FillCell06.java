package edu.ssafy.chap03;

import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표에서 지정한 칸수까지 상하 좌우에 1 채우기
 *  다음줄 부터 :  배열의 개수  좌표개수 칸수  {row좌표, column좌표}*좌표개수
 *  8 4 3 1 1 3 1 3 3 4 2
 */
public class FillCell06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int p = sc.nextInt();  //좌표 개수
		int count = sc.nextInt();  //칸수
		
		for (int k = 1; k <=p; k++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			////////////////
			/// 처리 코드 작성
			
			map[r][c]=1;
			//위
			for (int i = 1; i <= count; i++) {
				if(r-i < 0) {
					break;
				}
				map[r-i][c] = 1;
			}
			//아래
			for (int i = 1; i <= count; i++) {
				if(r+i > N-1) {
					break;
				}
				map[r+i][c] = 1;
			}
			//오른쪽
			for (int i = 1; i <= count; i++) {
				if(c+i > N-1) {
					break;
				}
				map[r][c+i] = 1;
			}
			//왼쪽
			for (int i = 1; i <= count; i++) {
				if(c-i < 0) {
					break;
				}
				map[r][c-i] = 1;
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
