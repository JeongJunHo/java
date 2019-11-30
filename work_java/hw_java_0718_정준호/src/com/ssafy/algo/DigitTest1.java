package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = "";
		
		while (true) {
			int num = sc.nextInt();
			
			if(num != 0) {
				if(num < 10) {
					str += "0" + num + ",";
				}else {
					str += num + ",";
				}
			}else {
				String[] strList = str.split(",");
				int[] count = new int[10];
				for (String s : strList) {
					int tmp = Integer.parseInt(String.valueOf(s.charAt(0)));
					count[tmp]++;
				}
				
				for (int i = 0; i < count.length; i++) {
					if(count[i] > 0) {
						System.out.println(i + " : " + count[i] + "개");
					}
				}
				
				break;
			}
		}
	}
}
