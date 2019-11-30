package com.ssafy;


public class ProductMgr {
	private Product[] arr;
	private int max = 10;
	private int index = 0;
	private static ProductMgr pm = new ProductMgr();
	
	public ProductMgr() {
		arr = new Product[max];
	}
	
	public static ProductMgr getInstance() {
		return pm;
	}
	
	/**
	 * 제품 목록에 담기
	 * @param product
	 */
	public void addProduct(Product product) {
		//사이즈 내
		if(index < max) {
			arr[index] = product;
		//공간이 부족할 경우 배열공간 확보
		}else {
			max *=2;
			Product[] tmp = new Product[max];
			System.arraycopy(arr, 0, tmp, 0, arr.length);
			arr = tmp;
			arr[index] = product;
		}
		index++;
	}
	
	/**
	 * 모든 제품 리스트 반환
	 */
	public Product[] list() {
		Product[] tmp = new Product[index];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[i];
		}
		
		return tmp;
	}
	
	/**
	 * 코드로 검색
	 * @param code 제품번호
	 */
	public Product[] searchByCode(String code) {
		int cnt = 0;
		Product[] tmp = new Product[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//만약 번호가 같은 책을 찾았다면 출력 후 종료
			if(arr[i].getCode().equals(code)) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 제품명으로 상품 검색
	 * @param name
	 */
	public Product[] searchByName(String name) {
		int cnt = 0;
		Product[] tmp = new Product[index];
		
		//모든 제품 순회
		for (int i = 0; i < index; i++) {
			//검색어가 들어간 제품이 있다면 모두 출력
			if(arr[i].getName().contains(name)) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 제품명과 가격으로 상품 검색
	 * @param name
	 * @param price
	 * @return
	 */
	public Product[] searchByName(String name, int price) {
		int cnt = 0;
		Product[] tmp = new Product[index];
		
		//모든 제품 순회
		for (int i = 0; i < index; i++) {
			//검색어가 포함되고 제시한 가격보다 작은 제품이 있다면 모두 출력
			if(arr[i].getName().contains(name) && arr[i].getPrice() < price) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * TV 리스트
	 */
	public Product[] tvList() {
		int cnt = 0;
		Product[] tmp = new Product[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//매거진을 발견할 경우 출력
			if(arr[i] instanceof TV) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 냉장고 리스트
	 */
	public Product[] refrigeratorList() {
		int cnt = 0;
		Product[] tmp = new Product[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//매거진을 발견할 경우 출력
			if(arr[i] instanceof Refrigerator) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 제품 삭제
	 * @param code
	 */
	public void remove(String code) {
		Product[] tmp = new Product[max];
		int cnt = 0;
		int del = 0;
		
		for (int i = 0; i < index; i++) {
			if(arr[i].getCode().equals(code)) {
				del++;
			}else {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		index -= del;
		arr = tmp;
	}
	
	/**
	 * 제품가격합계 반환
	 * @return
	 */
	public int totalPrice() {
		int total = 0;
		
		for (int i = 0; i < index; i++) {
			int tmp = arr[i].getStock() * arr[i].getPrice();
			total += tmp;
		}
		return total;
	}
	
	/**
	 * 배열 사이즈 재조정 메소드
	 * @param tmp
	 * @param cnt
	 * @return
	 */
	public Product[] arrResize(Product[] tmp, int cnt) {
		//찾은 숫자만큼 새로운 배열 생성
		Product[] tmp2 = new Product[cnt];
		System.arraycopy(tmp, 0, tmp2, 0, cnt);
		
		return tmp2;
	}
	
	/**
	 * 제품을 입력받아 해당 제품의 재고금액 합계를 반환
	 * @param product
	 * @return
	 */
	public int stockPriceTotal(Product product) {
		int total = 0;
		
		if(product instanceof Refrigerator) {
			for (int i = 0; i < index; i++) {
				if(arr[i] instanceof Refrigerator) {
					int sum = arr[i].getPrice() * arr[i].getStock();
					total += sum;
				}
			}
		}else if(product instanceof TV) {
			for (int i = 0; i < index; i++) {
				if(arr[i] instanceof TV) {
					int sum = arr[i].getPrice() * arr[i].getStock();
					total += sum;
				}
			}
		}
		
		return total;
	}
	
	/**
	 * 제품을 입력받아 해당 제품의 재고합계를 반환
	 * @param product
	 * @return
	 */
	public int stockTotal(Product product) {
		int totalStock = 0;
		
		if(product instanceof Refrigerator) {
			for (int i = 0; i < index; i++) {
				if(arr[i] instanceof Refrigerator) {
					totalStock += arr[i].getStock();
				}
			}
		}else if(product instanceof TV) {
			for (int i = 0; i < index; i++) {
				if(arr[i] instanceof TV) {
					totalStock += arr[i].getStock();
				}
			}
		}
		
		return totalStock;
	}
	
	
	/**
	 * TV 재고의 평균 인치를 반환
	 * @return
	 */
	public float avgInch() {
		int totalStock = 0;
		int totalInch = 0;
		
		for (int i = 0; i < index; i++) {
			if(arr[i] instanceof TV) {
				TV tv = (TV) arr[i];
				
				totalInch += (tv.getInch() * tv.getStock());
				totalStock += tv.getStock();
			}
		}
		
		float avgInch = (float)totalInch / totalStock;
		
		return avgInch;
	}
	
	/**
	 * 냉장고 리터의 합계를 반환
	 * @return
	 */
	public float avgLiter() {
		int totalLiter = 0;
		
		for (int i = 0; i < index; i++) {
			if (arr[i] instanceof Refrigerator) {
				Refrigerator re = (Refrigerator) arr[i];
				
				totalLiter += re.getLiter();
			}
		}
		
		return totalLiter;
	}
}
