package edu.ssafy.chap05;

public class Teacher extends Employee {
	private int money = 10000;
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("강의를 합니다");
		System.out.println(showMoney() + "를 법니다.");
	}
	
	@Override
	public int showMoney() {
		// TODO Auto-generated method stub
		return money;
	}
	
	public void 쉽니다() {
		System.out.println("학생 스스로 공부합니다.");
	}
}
