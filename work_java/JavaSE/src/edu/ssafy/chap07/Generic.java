package edu.ssafy.chap07;

public class Generic <T> {
	private T i;
	public T getI() {
		return i;
	}
	
	public void setI(T... i) {
		for (int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
	}
}
