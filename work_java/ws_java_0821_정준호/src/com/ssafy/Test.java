package com.ssafy;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		//데이터 입력
		dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
		dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
		dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000, "실전"));
		System.out.println();
		
		//도서 목록 출력
		new Test().printAllBooks(dao.listBooks());
		System.out.println();
		
		//a1101 도서 검색
		System.out.println(dao.findBook("a1101").toString());
		System.out.println();
		
		//a1104 도서를 추가하세요.
		dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
		
		//a1102 도서를 수정 후 목록을 출력하세요.
		Book book = dao.findBook("a1102");
		book.setTitle("JAVA 기본2");
		book.setPrice(20000);
		dao.updateBook(book);
		new Test().printAllBooks(dao.listBooks());
		System.out.println();
		
		//a1103 도서를 삭제 후 목록을 출력하세요.
		dao.deleteBook("a1103");
		new Test().printAllBooks(dao.listBooks());
		System.out.println();
	}
	
	private void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
}