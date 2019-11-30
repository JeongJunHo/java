package com.ssafy.ws;

import java.io.FileNotFoundException;
import java.io.IOException;
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
			System.out.println("7. 판매");
			System.out.println("8. 구매");
			System.out.println("9. 가격 검색");
			System.out.println("10. 합계 금액 조회");
			System.out.println("11. 1권당 평균 금액 조회");
			System.out.println("12. 서버로 전송");
			System.out.println("13. 프로그램 종료");
			System.out.println("===================================");
			System.out.print("S 전자 오픈 도서관입니다. 메뉴를 선택해주세요.");
			
			
			int num = sc.nextInt();
			//테스트용 고정데이터 입력
			if (num == 0) {
				bm.add(new Book("1", "어린왕자", 15000, 10));
				bm.add(new Book("2", "LG책", 20000, 20));
				bm.add(new Book("3", "삼성책", 30000, 15));
				bm.add(new Magazine("4", "KT매거진", 13000, 15, 5));
				bm.add(new Magazine("5", "SK매거진", 21000, 30, 8));
				bm.add(new Magazine("6", "삼성매거진", 18000, 12, 8));
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
						System.out.print("가격 : ");
						book.setPrice(sc.nextInt());
						if(num2 == 2) {
							Magazine ma = (Magazine) book;
							System.out.print("발행 월 : ");
							ma.setMonth(sc.nextInt());
							
							book = ma;
						}
						
						bm.add(book);
						break;
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					}
				}
			//리스트
			}else if (num == 2) {
				printList(bm.search());
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
			//판매
			}else if (num == 7) {
				System.out.print("판매할 책 번호 : ");
				String isbn = sc.next();
				System.out.print("판매 부수 : ");
				int quantity = sc.nextInt();
				try {
					bm.sell(isbn, quantity);
				} catch (QuantityException e) {
					e.sorry();
				} catch (ISBNNotFoundException e) {
					e.sorry();
				}
			//구매
			}else if (num == 8) {
				System.out.print("구매할 책 번호 : ");
				String isbn = sc.next();
				System.out.print("구매 부수 : ");
				int quantity = sc.nextInt();
				try {
					bm.buy(isbn, quantity);
				} catch (ISBNNotFoundException e) {
					e.sorry();
				}
			//가격 검색
			}else if (num == 9) {
				System.out.print("가격 : ");
				printList(bm.searchByPrice(sc.nextInt()));
			//합계 금액 조회
			}else if (num == 10) {
				System.out.println("합계 금액 : " + bm.getTotalAmount());
			//1권당 평균가격 조회
			}else if (num == 11) {
				System.out.println("1권당 평균 금액 : " + bm.avgPrice());
			//서버로 전송
			}else if (num == 12) {
				bm.send();
			//종료
			}else if(num == 13){
				try {
					bm.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		if(list.isEmpty()) {
			System.out.println("정보가 없습니다.");
		}else {
			for (Book book : list) {
				System.out.println(book.toString());
			}
		}
	}
}
