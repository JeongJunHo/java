package edu.ssafy.chap07.two;

public class Eagle extends Animal implements IFly {
	public void fly() {
		System.out.println("독수리가 난다.");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("독수리가 걷는다.");
	}
}
