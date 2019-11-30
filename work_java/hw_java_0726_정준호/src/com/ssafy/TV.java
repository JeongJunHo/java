package com.ssafy;

public class TV extends Product {
	private int inch;
	
	public TV() {
		super();
	}

	public TV(String code, String name, int price, int stock, int inch) {
		super(code, name, price, stock);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [inch=" + inch + ", toString()=" + super.toString() + "]";
	}
}
