package edu.ssafy.chap04;

public class MainTest2 {
	public static void main(String[] args) {
		Person p = new Person("둘리", 10, false, 19.0f);
		Person p2 = new Person("또치", 11, false, 29.0f);
		Person p3 = new Person("고길동", 12, false, 39.0f);
		
		Person[] parr = new Person[3];
		parr[0] = p;
		parr[1] = p2;
		parr[2] = p3;
		System.out.println(parr[0].info());
	}
}
