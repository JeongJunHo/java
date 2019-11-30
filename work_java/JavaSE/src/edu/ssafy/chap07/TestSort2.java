package edu.ssafy.chap07;

import java.util.Arrays;

public class TestSort2 {
	public static void main(String[] args) {
		Car[] cars = new Car[5];
		cars[0] = new Car("111", 3000);
		cars[1] = new Car("333", 2000);
		cars[2] = new Car("222", 1000);
		cars[3] = new Car("555", 6000);
		cars[4] = new Car("444", 9000);
		
		Arrays.sort(cars);
		
		for (Car c : cars) {
			System.out.println(c.toString());
		}
	}
}
