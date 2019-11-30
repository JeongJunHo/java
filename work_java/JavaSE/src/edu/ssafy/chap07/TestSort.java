package edu.ssafy.chap07;

import java.util.Arrays;
import java.util.Comparator;

public class TestSort {
	public static void main(String[] args) {
		Integer[] ins = new Integer[5];
		ins[0] = 3;
		ins[1] = 13;
		ins[2] = 53;
		ins[3] = 43;
		ins[4] = 23;
		
		Comparator<Integer> com = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		};
		
		Arrays.sort(ins, com);
		
		for (Integer i : ins) {
			System.out.println(i);
		}
		
		for (int i = 0; i < ins.length; i++) {
			
		}
		
	}
}
