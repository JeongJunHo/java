package com.ssafy.hw;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgrImpl pm = ProductMgrImpl.getInstance();
		
		while (true) {
			System.out.println("===================================");
			System.out.println("1. 등록");
			System.out.println("2. 리스트");
			System.out.println("3. 코드 검색");
			System.out.println("4. 제품명 검색");
			System.out.println("5. TV 리스트");
			System.out.println("6. 냉장고 리스트");
			System.out.println("7. 400L 이상 냉장고 검색");
			System.out.println("8. 50inch 이상 TV 검색");
			System.out.println("9. 가격 변경");
			System.out.println("10. 제품 삭제");
			System.out.println("11. 재고 상품 합계 금액 조회");
			System.out.println("12. 고정 데이터 등록");
			System.out.println("13. 제품명 & 가격 검색");
			System.out.println("14. 서버 전송");
			System.out.println("15. 저장");
			System.out.println("16. 불러오기");
			System.out.println("0. 프로그램 종료(저장 후 종료)");
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
							
							product = tv;
						}else if (num2 == 2) {
							Refrigerator re = (Refrigerator) product;
							System.out.print("리터 : ");
							re.setLiter(sc.nextInt());
							
							product = re;
						}
						
						try {
							pm.addProduct(product);
						} catch (DuplicateException e) {
							e.sorry();
						}
						break;
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					}
				}
			//리스트
			}else if (num == 2) {
				try {
					printList(pm.list());
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//코드 검색
			}else if (num == 3) {
				System.out.print("검색코드 : ");
				try {
					System.out.println(pm.searchByCode(sc.next()).toString());
				} catch (CodeNotFoundException e) {
					e.sorry();
				}
				
			//제품명 검색
			}else if (num == 4) {
				System.out.print("제품명 : ");
				try {
					printList(pm.searchByName(sc.next()));
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//TV 리스트
			}else if (num == 5) {
				try {
					printList(pm.tvList());
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//냉장고 리스트
			}else if (num == 6) {
				try {
					printList(pm.refrigeratorList());
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//400L 이상 냉장고 검색
			}else if (num == 7) {
				try {
					printList(pm.over400Lrefrigerator());
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//50inch 이상 TV 검색
			}else if (num == 8) {
				try {
					printList(pm.over50InchTV());
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//가격 변경
			}else if (num == 9) {
				System.out.print("변경할 제품 코드 : ");
				String code = sc.next();
				System.out.print("변경할 가격 : ");
				int price = sc.nextInt();
				try {
					pm.updatePrice(code, price);
				} catch (CodeNotFoundException e) {
					e.sorry();
				}
			//상품삭제
			}else if (num == 10) {
				System.out.print("상품코드 : ");
				try {
					pm.delete(sc.next());
				} catch (CodeNotFoundException e) {
					e.sorry();
				}
			//합계 금액 조회
			}else if (num == 11) {
				System.out.println("합계 금액 : " + pm.totalPrice());
			//기초 데이터 등록
			}else if (num == 12) {
				try {
					pm.addProduct(new TV("TV1","samsungTV1",100000,100,24));
					pm.addProduct(new TV("TV2","samsungTV2",200000,200,27));
					pm.addProduct(new TV("TV3","samsungTV3",1600000,50,50));
					pm.addProduct(new Refrigerator("ref1","samsung_ref1",400000,100,300));
					pm.addProduct(new Refrigerator("ref2","LG_ref1",500000,150,250));
					pm.addProduct(new Refrigerator("ref3","samsung_ref2",1000000,60,600));
					pm.addProduct(new Refrigerator("ref4","LG_ref2",1200000,40,700));
				} catch (DuplicateException e) {
					e.sorry();
				}
			//제품명 & 가격 검색
			}else if (num == 13) {
				System.out.print("제품명 : ");
				String name = sc.next();
				System.out.print("검색할 가격 : ");
				int price = sc.nextInt();
				try {
					printList(pm.searchByName(name, price));
				} catch (ProductNotFoundException e) {
					e.sorry();
				}
			//서버 전송
			}else if (num == 14) {
				pm.send();
			//저장
			}else if (num == 15) {
				pm.save();
			//불러오기
			}else if (num == 16) {
				pm.load();
			//종료
			}else if(num == 0){
				System.out.println("이용해주셔서 감사합니다.");
				pm.save();
				break;
			//잘못 입력 했을경우
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			System.out.println();
			System.out.println();
		}// end while
	}
	
	public static void printList(ArrayList<Product> list) {
		for (Product product : list) {
			System.out.println(product.toString());
		}
		if(list.isEmpty()) {
			System.out.println("정보가 없습니다.");
		}
	}
}
