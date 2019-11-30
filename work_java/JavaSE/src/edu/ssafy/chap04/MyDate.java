package edu.ssafy.chap04;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public void setYear(int year) {
		if(year<1900 || year>2100) {
			System.out.println("입력하신 년도가 범위를 초과했습니다.");
		}else {
			this.year = year;
		}
	}
	
	public int getYear() {
		return year;
	}
	
	public void setMonth(int month) {
		if (month>=1 && month<=12) {
			this.month = month;
		}else {
			System.out.println("입력하신 월이 범위를 초과했습니다.");
		}
	}
	
	public int getMonth() {
		return month;
	}
	
	MyDate(){
		
	}
	MyDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	void info() {
		System.out.println(year + "," + month + "," + day);
	}
}
