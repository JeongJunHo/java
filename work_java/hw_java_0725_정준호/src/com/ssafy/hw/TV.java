package com.ssafy.hw;

public class TV extends Product {
	private int inch;
	private int hz;

	
	public TV() {
		super();
	}

	public TV(String code, String name, int price, int stock, int inch, int hz) {
		super(code, name, price, stock);
		this.inch = inch;
		this.hz = hz;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public int getHz() {
		return hz;
	}

	public void setHz(int hz) {
		this.hz = hz;
	}
}
