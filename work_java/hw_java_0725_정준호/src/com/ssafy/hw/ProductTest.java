package com.ssafy.hw;

import java.awt.print.Book;
import java.util.Scanner;


public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr pm = ProductMgr.getInstance();
		
		while (true) {
			System.out.println("===================================");
			System.out.println("1. 등록");
			System.out.println("2. 리스트");
			System.out.println("3. 코드 검색");
			System.out.println("4. 제품명 검색");
			System.out.println("5. TV 리스트");
			System.out.println("6. 냉장고 리스트");
			System.out.println("7. 제품 삭제");
			System.out.println("8. 재고 상품 합계 금액 조회");
			System.out.println("9. 프로그램 종료");
			System.out.println("===================================");
			System.out.print("ABC 디지털 대리점입니다. 메뉴를 선택해주세요.");
			
			
			int num = sc.nextInt();
			//등록
			if (num == 1) {
				while (true) {
					System.out.println("1. TV");
					System.out.println("2. 냉장고");
					System.out.print("등록할 제품을 선택해주세요.");
					
					int num2 = sc.nextInt();
					
					if(num2 == 1 || num2 == 2) {
						Product product = null;
						if (num2 == 1) {
							product = new TV();
						}else if (num2 == 2) {
							product = new Refrigerator();
						}
						
						System.out.print("제품코드 : ");
						product.setCode(sc.next());
						System.out.print("제품명 : ");
						product.setName(sc.next());
						System.out.print("제품가격 : ");
						product.setPrice(sc.nextInt());
						System.out.print("재고수량 : ");
						product.setStock(sc.nextInt());
						if(num2 == 1) {
							TV tv = (TV) product;
							System.out.print("인치 : ");
							tv.setInch(sc.nextInt());
							System.out.print("주사율 : ");
							tv.setHz(sc.nextInt());
							
							product = tv;
						}else if (num2 == 2) {
							Refrigerator re = (Refrigerator) product;
							System.out.print("타입 : ");
							re.setType(sc.next());
							System.out.print("리터 : ");
							re.setLiter(sc.nextInt());
							
							product = re;
						}
						
						pm.addProduct(product);
						break;
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					}
				}
			//리스트
			}else if (num == 2) {
				Product[] arr = pm.list();
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("제품 정보가 없습니다.");
			//코드 검색
			}else if (num == 3) {
				System.out.print("검색코드 : ");
				Product[] arr = pm.searchByCode(sc.next());
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("제품 정보가 없습니다.");
			//제품명 검색
			}else if (num == 4) {
				System.out.print("제품명 : ");
				Product[] arr = pm.searchByName(sc.next());
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("제품 정보가 없습니다.");
			//TV 리스트
			}else if (num == 5) {
				Product[] arr = pm.tvList();
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("제품 정보가 없습니다.");
			//냉장고 리스트
			}else if (num == 6) {
				Product[] arr = pm.refrigeratorList();
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].toString());
				}
				
				if(arr.length == 0) System.out.println("제품 정보가 없습니다.");
			//상품삭제
			}else if (num == 7) {
				System.out.print("상품코드 : ");
				pm.remove(sc.next());
			//합계 금액 조회
			}else if (num == 8) {
				System.out.println("합계 금액 : " + pm.totalPrice());
			//종료
			}else if(num == 9){
				System.out.println("이용해주셔서 감사합니다.");
				break;
			//잘못 입력 했을경우
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			System.out.println();
			System.out.println();
		}// end while
	}
}
