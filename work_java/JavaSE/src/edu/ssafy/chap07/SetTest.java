package edu.ssafy.chap07;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
//		Set<String> s = new HashSet<>();
		TreeSet<String> s = new TreeSet<>();
		s.add("Gwangju");
		s.add("Seoul");
		s.add("Daejeon");
		s.add("Gumi");
		s.add("Gumi");
		
		System.out.println("=========================");
		System.out.println(s.first());
		System.out.println("=========================");
		System.out.println(s.last());
		
		
		Iterator<String> iterator = s.iterator();
		while (iterator.hasNext()) {
			String obj = iterator.next();
			System.out.println(obj.toString());
		}
		
		System.out.println("----------------------------");
		for (String string : s) {
			System.out.println(string);
		}
	}
}
