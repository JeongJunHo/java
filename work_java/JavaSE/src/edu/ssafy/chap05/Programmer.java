package edu.ssafy.chap05;

public class Programmer extends Employee {
	private int money = 100000;
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("개발을 합니다.");
		System.out.println(showMoney() + "를 법니다.");
	}
	
	@Override
	public int showMoney() {
		// TODO Auto-generated method stub
		return money;
	}
	
	public void 삽질() {
		System.out.println("삽질을 합니다.");
	}
}
