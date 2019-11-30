package edu.ssafy.chap07;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Gwangju");
		list.add("Seoul");
		list.add("Daejeon");
		list.add("Gumi");
		list.add("Gumi");
		
		System.out.println("=========================");
		System.out.println(list.get(0));
		System.out.println("=========================");
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String obj = iterator.next();
			System.out.println(obj.toString());
		}
		
		System.out.println("----------------------------");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
