package com.ssafy.java;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println();
		System.out.println("1.5판 3승");
		System.out.println();
		System.out.println("2.3판 2승");
		System.out.println();
		System.out.println("3.1판 1승");
		System.out.println();
		System.out.print("번호를 입력하세요.");
		int number = sc.nextInt();
		System.out.println();
		
		//컴퓨터 요구승수
		int comp_win = 0;
		//사용자 요구승수
		int user_win = 0;
		switch (number) {
		case 1:
			comp_win = 3;
			user_win = 3;
			break;
		case 2:
			comp_win = 2;
			user_win = 2;
			break;
		case 3:
			comp_win = 1;
			user_win = 1;
			break;
		default:
			System.out.println("잘못된 번호를 입력하셨습니다.");
			break;
		}
		
		while (true) {
			int set = (int) (Math.random() * 3) + 1;
			
			System.out.print("가위바위보 중 하나 입력:");
			String user = sc.next();
			System.out.println();
			if (user.trim().equals("가위")) {
				if (set == 1) {
					System.out.println("비겼습니다!!!");
				}else if (set == 2) {
					System.out.println("졌습니다!!!");
					comp_win--;
				}else if (set == 3) {
					System.out.println("이겼습니다!!!");
					user_win--;
				}
			}else if(user.trim().equals("바위")) {
				if (set == 1) {
					System.out.println("이겼습니다!!!");
					user_win--;
				}else if (set == 2) {
					System.out.println("비겼습니다!!!");
				}else if (set == 3) {
					System.out.println("졌습니다!!!");
					comp_win--;
				}
			}else if(user.trim().equals("보")) {
				if (set == 1) {
					System.out.println("졌습니다!!!");
					comp_win--;
				}else if (set == 2) {
					System.out.println("이겼습니다!!!");
					user_win--;
				}else if (set == 3) {
					System.out.println("비겼습니다!!!");
				}
			}else {
				System.out.println("잘못된 입력입니다. 가위, 바위, 보 중 입력해주세요.");
			}
			System.out.println();
			
			if(comp_win == 0) {
				System.out.println();
				System.out.println();
				System.out.println("### 컴퓨터 승!!!");
				break;
			}else if (user_win == 0) {
				System.out.println();
				System.out.println();
				System.out.println("### 사용자 승!!!");
				break;
			}
		}
	}
}
