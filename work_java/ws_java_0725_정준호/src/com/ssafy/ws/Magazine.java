package com.ssafy.ws;

public class Magazine extends Book {
	private int year;
	private int month;
	
	public Magazine() {}
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getIsbn())
			.append(" \t| ")
			.append(getTitle())
			.append(" \t| ")
			.append(getAuthor())
			.append(" \t| ")
			.append(getPublisher())
			.append(" \t| ")
			.append(getPrice())
			.append("\t| ")
			.append(getDesc())
			.append(" \t| ")
			.append(year)
			.append(".")
			.append(month);
		
		return sb.toString();
	}

	public int getYear() {
		return year;
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
