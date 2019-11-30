package edu.ssafy.chap02;

public class ArrayTest01 {
	// Array
	// 정의 : 같은 데이터타입의 순서적 나열(속도가 가장빠른 자료구조)
	// 특징 : 선언과 동시에 크기가 결저외어지고 한번 결정된 크기는 변경되지 않습니다.
	// 배열을 생성하면 기본값으로 초기화 이루어집니다.
	// 정수 : 0, 실수 : 0.0, 문자 : \u0000, 논리 : false, 참조 : null
	public static void main(String[] args) {
		int kuk=100, math=90, eng=80;
		int[] jumsu = new int[3];
		jumsu[0] = 100;
		jumsu[1] = 90;
		jumsu[2] = 80;
		int sum = 0;
		
		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
		}
		System.out.println(sum);
	}
}
