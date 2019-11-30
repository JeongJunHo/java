package edu.ssafy.chap07;

public class Car implements Comparable<Car> {
	String num;
	int price;
	
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return o.price - this.price;
	}
	
	Car(String num, int price){
		this.num = num;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [num=" + num + ", price=" + price + "]";
	}
}
