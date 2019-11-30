package edu.ssafy.chap07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap();
		m.put(1, "My");
		m.put(2, "Your");
		m.put(3, "Ours");
		System.out.println(m);
		
		System.out.println(m.get(2));
		
		System.out.println("========================");
		
		Collection<String> values = m.values();
		for (String s : values) {
			System.out.println(s);
		}
		
		System.out.println("========================");
		
		Iterator<Integer> iter = m.keySet().iterator();
		while (iter.hasNext()) {
			System.out.println(m.get(iter.next()));
		}
	}
}
