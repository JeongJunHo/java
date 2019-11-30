package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book();
		book1.setIsbn("21424");
		book1.setTitle("Java Pro");
		book1.setAuthor("김하나");
		book1.setPublisher("Jaen.kr");
		book1.setPrice(15000);
		book1.setDesc("Java 기본문법");
		System.out.println(book1.toString());
		
		Book book2 = new Book("35355","분석설계","소나무","Jaen.kr",30000,"SW 모델링");
		System.out.println(book2.toString());
		
		Magazine magazine = new Magazine("35535","Java World","편집부","java.com",2018,2,7000,"첫걸음");
		System.out.println(magazine.toString());
	}

}
