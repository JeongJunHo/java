package com.ssafy.ws;

public class Magazine extends Book {
	/**
	 * 출간 년
	 */
	private int year;
	/**
	 * 출간 월
	 */
	private int month;
	
	public Magazine() {}
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", toString()=" + super.toString() + "]";
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
