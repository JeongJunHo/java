package com.ssafy.ws;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookMgrImpl bm = BookMgrImpl.getInstance();
		while (true) {
			System.out.println("===================================");
			System.out.println("0. 테스트 데이터 입력");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 전체 검색");
			System.out.println("3. Isbn 검색");
			System.out.println("4. Title 검색(검색어가 제목에 포함된 모든 내용)");
			System.out.println("5. Book 리스트");
			System.out.println("6. Magazine 리스트");
			System.out.println("7. 올해의 Magazine 리스트");
			System.out.println("8. 출판사 검색");
			System.out.println("9. 가격 검색");
			System.out.println("10. 합계 금액 조회");
			System.out.println("11. 1권당 평균 금액 조회");
			System.out.println("12. 프로그램 종료");
			System.out.println("===================================");
			System.out.print("S 전자 오픈 도서관입니다. 메뉴를 선택해주세요.");
			
			
			int num = sc.nextInt();
			//테스트용 고정데이터 입력
			if (num == 0) {
				bm.addBook(new Book("1", "어린왕자", "베리베리", "삼성출판", 15000, "소설"));
				bm.addBook(new Book("2", "LG책", "LGLG", "LG출판", 20000, "LG"));
				bm.addBook(new Book("3", "삼성책", "삼성삼성", "삼성출판", 30000, "삼성"));
				bm.addBook(new Magazine("4", "KT매거진", "KTKT", "KT출판", 2017, 5, 23000, "KT내용"));
				bm.addBook(new Magazine("5", "SK매거진", "SKSK", "SK출판", 2018, 6, 28000, "SK내용"));
				bm.addBook(new Magazine("6", "삼성매거진", "삼성삼성", "삼성출판", 2019, 7, 40000, "삼성"));
			//등록
			}else if (num == 1) {
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
				printList(bm.list());
			//번호 검색
			}else if (num == 3) {
				System.out.print("검색번호 : ");
				printList(bm.searchByNumber(sc.next()));
			//제목 검색
			}else if (num == 4) {
				System.out.print("제목 : ");
				printList(bm.searchByTitle(sc.next()));
			//책 리스트
			}else if (num == 5) {
				printList(bm.onlyBook());
			//매거진 리스트
			}else if (num == 6) {
				printList(bm.onlyMagazine());
			//올해의 매거진 리스트
			}else if (num == 7) {
				printList(bm.ThisYearMagazine());
			//출판사 검색
			}else if (num == 8) {
				System.out.print("출판사 : ");
				printList(bm.searchByPublisher(sc.next()));
			//가격 검색
			}else if (num == 9) {
				System.out.print("가격 : ");
				printList(bm.searchByPrice(sc.nextInt()));
			//합계 금액 조회
			}else if (num == 10) {
				System.out.println("합계 금액 : " + bm.totalPrice());
			//1권당 평균가격 조회
			}else if (num == 11) {
				System.out.println("1권당 평균 금액 : " + bm.avgPrice());
			//종료
			}else if(num == 12){
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			System.out.println();
			System.out.println();
		}// end while
	}
	
	public static void printList(ArrayList<Book> list) {
		for (Book book : list) {
			System.out.println(book.toString());
		}
		if(list.isEmpty()) {
			System.out.println("정보가 없습니다.");
		}
	}
}
