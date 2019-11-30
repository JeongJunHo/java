package com.ssafy.ws;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		String a = "서울출판";
		String b = "서울출판";
		
		
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		
		while (true) {
			System.out.println("===================================");
			System.out.println("1. 등록");
			System.out.println("2. 리스트");
			System.out.println("3. 번호 검색");
			System.out.println("4. 제목 검색");
			System.out.println("5. 책 리스트");
			System.out.println("6. 매거진 리스트");
			System.out.println("7. 출판사 검색");
			System.out.println("8. 가격 검색");
			System.out.println("9. 합계 금액 조회");
			System.out.println("10. 1권당 평균 금액 조회");
			System.out.println("11. 프로그램 종료");
			System.out.println("===================================");
			System.out.print("S 전자 오픈 도서관입니다. 메뉴를 선택해주세요.");
			
			
			int num = sc.nextInt();
			//등록
			if (num == 1) {
				while (true) {
					System.out.println("1. 책");
					System.out.println("2. 매거진");
					System.out.print("등록할 책의 타입을 선택해주세요.");
					
					int num2 = sc.nextInt();
					
					if(num2 == 1 || num2 == 2) {
						Book book = null;
						if (num2 == 1) {
							book = new Book();
						}else if (num2 == 2) {
							book = new Magazine();
						}
						
						System.out.print("책번호 : ");
						book.setIsbn(sc.next());
						System.out.print("책제목 : ");
						book.setTitle(sc.next());
						System.out.print("출판사 : ");
						book.setPublisher(sc.next());
						System.out.print("저자 : ");
						book.setAuthor(sc.next());
						System.out.print("설명 : ");
						book.setDesc(sc.next());
						System.out.print("가격 : ");
						book.setPrice(sc.nextInt());
						if(num2 == 2) {
							Magazine ma = (Magazine) book;
							System.out.print("발행 년 : ");
							ma.setYear(sc.nextInt());
							System.out.print("발행 월 : ");
							ma.setMonth(sc.nextInt());
							
							book = ma;
						}
						
						bm.addBook(book);
						break;
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					}
				}
			//리스트
			}else if (num == 2) {
				Book[] arr = bm.list();
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//번호 검색
			}else if (num == 3) {
				System.out.print("검색번호 : ");
				Book[] arr = bm.searchByNumber(sc.next());
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//제목 검색
			}else if (num == 4) {
				System.out.print("제목 : ");
				Book[] arr = bm.searchByTitle(sc.next());
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//책 리스트
			}else if (num == 5) {
				Book[] arr = bm.bookList();
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//매거진 리스트
			}else if (num == 6) {
				Book[] arr = bm.magazineList();
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//출판사 검색
			}else if (num == 7) {
				System.out.print("출판사 : ");
				Book[] arr = bm.searchByPublisher(sc.next());
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//가격 검색
			}else if (num == 8) {
				System.out.print("가격 : ");
				Book[] arr = bm.searchByPrice(sc.nextInt());
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("책 정보가 없습니다.");
			//합계 금액 조회
			}else if (num == 9) {
				System.out.println("합계 금액 : " + bm.totalPrice());
			//1권당 평균가격 조회
			}else if (num == 10) {
				System.out.println("1권당 평균 금액 : " + bm.avgPrice());
			//잘못 입력했을 경우
			}else if(num == 11){
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			System.out.println();
			System.out.println();
		}// end while
	}
}
