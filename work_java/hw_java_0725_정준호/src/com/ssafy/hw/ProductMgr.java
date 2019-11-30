package com.ssafy.hw;


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
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//검색어가 들어간 책이 있다면 모두 출력
			if(arr[i].getName().contains(name)) {
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
}
