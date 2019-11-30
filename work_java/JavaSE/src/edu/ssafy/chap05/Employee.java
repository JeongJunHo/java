package edu.ssafy.chap05;

public class Employee {
	private int money = 8350;
	
	public void work() {
		System.out.println("일해요.");
		System.out.println(money + "를 법니다.");
	}
	
	public int showMoney() {
		return money;
	}
}
