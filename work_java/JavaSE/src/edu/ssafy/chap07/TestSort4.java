package edu.ssafy.chap07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestSort4 {
	public static void main(String[] args) {
		ArrayList<Bag> list = new ArrayList<>();
		list.add(new Bag(3000));
		list.add(new Bag(2000));
		list.add(new Bag(1000));
		list.add(new Bag(6000));
		list.add(new Bag(9000));
		
		Comparator<Bag> compare = new Comparator<Bag>() {

			@Override
			public int compare(Bag o1, Bag o2) {
				// TODO Auto-generated method stub
				return o1.price - o2.price;
			}
			
		};
		
		Collections.sort(list, compare);
		
		for (Bag bag : list) {
			System.out.println(bag.toString());
		}
	}
}
