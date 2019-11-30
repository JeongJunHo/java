package edu.ssafy.chap07;

import java.util.ArrayList;
import java.util.Collections;

public class TestSort3 {
	public static void main(String[] args) {
		ArrayList<Car> list = new ArrayList<>();
		list.add(new Car("111",3000));
		list.add(new Car("333",2000));
		list.add(new Car("222",1000));
		list.add(new Car("555",6000));
		list.add(new Car("444",9000));
		
		Collections.sort(list);
		
		for (Car c : list) {
			System.out.println(c.toString());
		}
	}
}
