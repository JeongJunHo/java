package edu.ssafy.chap02;

import java.util.Random;

public class Lotto {
	static int[] su = new int[6];
	public static void main(String[] args) {
		for (int i = 0; i < su.length; i++) {
			su[i] = uniqueValue(su.length);			
		}

		System.out.println("오늘의 행운의 숫자 !!!");
		for (int num : su) {
			System.out.print(num + " ");
		}
	}
	
	private static int uniqueValue(int index) {
		//출력번호
		int imsi;
		//중복여부
		boolean eq;
		
		Random ran = new Random();
		
		do {
			imsi = ran.nextInt(45) + 1;
			eq = false;
			for (int i = 0; i < index; i++) {
				if(imsi == su[i]) {
					eq = true;
					break;
				}
			}
		} while (eq);
		
		return imsi;
	}
}
