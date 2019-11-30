package com.ssafy.ws;

public class Magazine extends Book {
	/**
	 * 출간 월
	 */
	private int month;
	
	public Magazine() {}
	
	/**
	 * @param isbn
	 * @param title
	 * @param price
	 * @param quantity
	 * @param month
	 */
	public Magazine(String isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		// TODO Auto-generated constructor stub
		this.month = month;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Magazine [month=" + month + ", toString()=" + super.toString() + "]";
	}
}
