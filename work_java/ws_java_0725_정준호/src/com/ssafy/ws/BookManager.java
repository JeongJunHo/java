package com.ssafy.ws;

public class BookManager {
	private Book[] arr;
	private int max = 10;
	private int index = 0;

	public BookManager() {
		arr = new Book[max];
	}
	
	/**
	 * 책 목록에 담기
	 * @param book
	 */
	public void addBook(Book book) {
		//사이즈이내로 들어올 경우
		if(index < max) {
			arr[index] = book;
		//공간이 부족할 경우 2배로 늘린다.
		}else {
			//최대치를 2배로 늘린다.
			max *= 2;
			//늘린 최대치만큼의 공간을 새로 확보한다.
			Book[] tmp = new Book[max];
			//기존의 배열을 새로운 넓은 공간에 복사한다.
			System.arraycopy(arr, 0, tmp, 0, arr.length);
			//기존의 넓은 공간을 현재 사용하던 변수로 치환한다.
			arr = tmp;
			//책을 등록한다.
			arr[index] = book;
		}
		//인덱스를 하나 늘려 다음 들어올 책 번호를 기억한다.
		index++;
	}
	
	/**
	 * 모든 책 리스트 반환(매거진포함)
	 */
	public Book[] list() {
		Book[] tmp = new Book[index];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[i];
		}
		
		return tmp;
	}
	
	/**
	 * 번호로 책 검색
	 * @param isbn 책번호(String)
	 */
	public Book[] searchByNumber(String isbn) {
		int cnt = 0;
		Book[] tmp = new Book[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//만약 번호가 같은 책을 찾았다면 출력 후 종료
			if(arr[i].getIsbn().equals(isbn)) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * title로 책 검색
	 * @param title
	 */
	public Book[] searchByTitle(String title) {
		int cnt = 0;
		Book[] tmp = new Book[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//검색어가 들어간 책이 있다면 모두 출력
			if(arr[i].getTitle().contains(title)) {
				tmp[cnt] = arr[i];
				cnt++;
			}
			System.out.println();
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 책 리스트
	 */
	public Book[] bookList() {
		int cnt = 0;
		Book[] tmp = new Book[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//책을 발견할 경우 출력
			if(!(arr[i] instanceof Magazine)) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 매거진 리스트
	 */
	public Book[] magazineList() {
		int cnt = 0;
		Book[] tmp = new Book[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			//매거진을 발견할 경우 출력
			if(arr[i] instanceof Magazine) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 출판사로 책 검색
	 * @param publisher
	 */
	public Book[] searchByPublisher(String publisher) {
		int cnt = 0;
		Book[] tmp = new Book[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			if(arr[i].getPublisher().equals(publisher)) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 가격으로 책 검색(가격이내)
	 * @param price
	 */
	public Book[] searchByPrice(int price) {
		int cnt = 0;
		Book[] tmp = new Book[index];
		
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			if (arr[i].getPrice() <= price) {
				tmp[cnt] = arr[i];
				cnt++;
			}
		}
		
		return arrResize(tmp, cnt);
	}
	
	/**
	 * 합계
	 */
	public int totalPrice() {
		int total = 0;
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			total += arr[i].getPrice();
		}
		
		return total;
	}
	
	/**
	 * 평균
	 */
	public float avgPrice() {
		int total = 0;
		float avg;
		//모든 책 순회
		for (int i = 0; i < index; i++) {
			total += arr[i].getPrice();
		}
		
		avg = (float)total / index;
		
		return avg;
	}
	
	/**
	 * 배열 사이즈 재조정 메소드
	 * @param tmp
	 * @param cnt
	 * @return
	 */
	public Book[] arrResize(Book[] tmp, int cnt) {
		//찾은 숫자만큼 새로운 배열 생성
		Book[] tmp2 = new Book[cnt];
		System.arraycopy(tmp, 0, tmp2, 0, cnt);
		
		return tmp2;
	}
}
