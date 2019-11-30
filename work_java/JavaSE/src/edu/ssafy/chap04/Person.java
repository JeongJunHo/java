package edu.ssafy.chap04;

/**
 * @author 정준호 
 * @version 0.1 
 * 사람클래스
 * */ 
public class Person {
	/** 이름 */
	String name;
	/** 나이 */
	int age;
	/** 성별 남: false 여: true */
	boolean gender;
	/** 몸무게 */
	float weight;
	
	/** default constructor */
	Person(){
	}
	
	Person(String name, int age, boolean gender, float weight){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
	}
	
	
	
	/** 정보출력함수 */
	String info() {
		return name + "," + age + "," + gender + "," + weight;
	}
}
