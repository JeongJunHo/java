package edu.ssafy.chap06;

class Book{
	
}

class Date{
	static int holiday;
}

class Magazine extends Book{
	Date mm;
	void setMM(Date mm) {
		this.mm = mm;
	}
	
	public Magazine() {
		Date.holiday++;
		mm = new Date();
	}
}

public class UMLMain {

}

class Contact{
	
}

class Manager{
	public void add(Book c) {
		
	}
}