package edu.ssafy.chap04;

public class MainTest1 {
	public static void main(String[] args) {
		Person p = new Person();
		p.name = "홍길동";
		p.age = 21;
		p.gender = false;
		p.weight = 60.3f;
		System.out.println(p.info());
		
		Person p1 = new Person();
		p1.name = "둘리";
		p1.age = 8;
		p1.gender = false;
		p1.weight = 20.0f;
		
		System.out.println(p1.info());
		
		Person p2 = new Person("도우너", 10, false, 20.0f);
		
		System.out.println(p2.info());
	}
}
