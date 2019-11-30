package edu.ssafy.chap07.two;

public class AquaMan extends 승우 implements ISwim,IFly {

	@Override
	public void swimming() {
		// TODO Auto-generated method stub
		System.out.println("아쿠아맨이 수영합니다.");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("아쿠아맨이 날라요.");
	}
	
}
