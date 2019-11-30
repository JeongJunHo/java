package com.ssafy.hw;

import java.io.Serializable;

public class TV extends Product {
	private int inch;
	
	public TV() {
		super();
	}

	public TV(String code, String name, int price, int stock, int inch) {
		super(code, name, price, stock);
		this.inch = inch;
	}

	

	@Override
	public String toString() {
		return super.toString() + "TV [inch=" + inch + "]";
	}

	/**
	 * @return the inch
	 */
	public int getInch() {
		return inch;
	}

	/**
	 * @param inch the inch to set
	 */
	public void setInch(int inch) {
		this.inch = inch;
	}
}
