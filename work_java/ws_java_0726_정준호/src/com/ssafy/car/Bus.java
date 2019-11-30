package com.ssafy.car;

public class Bus extends Car {
	private int seat;
	
	public Bus() {
		super();
	}

	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
}
