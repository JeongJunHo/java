package com.ssafy.ws;

import java.util.ArrayList;

public interface IBookMgr {
	/**
	 * 데이터 입력
	 * @param book
	 */
	public void addBook(Book book);
	/**
	 * 데이터 전체 검색
	 * @return
	 */
	public ArrayList<Book> list();
	/**
	 * Isbn 으로 정보를 검색
	 * @param isbn
	 * @return
	 */
	public ArrayList<Book> searchByNumber(String isbn);
	/**
	 * Title로 정보를 검색하는 기능(파라메터로 주어진 제목을 포함하는 모든 정보)
	 * @param title
	 * @return
	 */
	public ArrayList<Book> searchByTitle(String title);
	/**
	 * Book만 검색
	 * @return
	 */
	public ArrayList<Book> onlyBook();
	/**
	 * Magazine만 검색
	 * @return
	 */
	public ArrayList<Book> onlyMagazine();
	/**
	 * Magazine중 올해 잡지만 검색
	 * @return
	 */
	public ArrayList<Book> ThisYearMagazine();
	/**
	 * 출판사로 검색
	 * @param publisher
	 * @return
	 */
	public ArrayList<Book> searchByPublisher(String publisher);
	/**
	 * 가격으로 검색 (파라메터로 주어진 가격보다 낮은 도서 정보 검색)
	 * @param price
	 * @return
	 */
	public ArrayList<Book> searchByPrice(int price);
	/**
	 * 저장된 모든 도서의 금액 합계
	 * @return
	 */
	public int totalPrice();
	/**
	 * 저장된 모든 도서의 금액 평균
	 * @return
	 */
	public float avgPrice();
}
