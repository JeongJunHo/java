package com.ssafy.ws;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IBookMgr {
	/**
	 * 데이터 입력
	 * @param book 책정보
	 */
	public void add(Book book);
	/**
	 * 데이터 전체 검색
	 * @return 책 리스트
	 */
	public ArrayList<Book> search();
	/**
	 * 도서가 판매되어 재고 수량을 빼는 기능
	 * @param isbn 책번호
	 * @param quantity 판매수량
	 * @throws QuantityException 수량이 부족할 경우 예외처리
	 * @throws ISBNNotFoundException 책번호를 찾을 수 없을 경우 예외처리
	 */
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	/**
	 * 도서가 구매되어 재고 수량을 더하는 기능
	 * @param isbn 책번호
	 * @param quantity 구매수량
	 * @throws ISBNNotFoundException 책번호를 찾을 수 없을 경우 예외처리
	 */
	public void buy(String isbn, int quantity) throws ISBNNotFoundException;
	/**
	 * 클래스 생성시 호출, 파일("boot.dat")에 저장된 파일을 읽어서 ArrayList에 저장
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public void open() throws FileNotFoundException, IOException, ClassNotFoundException;
	/**
	 * 프로그램 종료시 호출, ArrayList에 있는 도서 정보를 파일("boot.dat")로 저장
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void close() throws FileNotFoundException, IOException;
	
	/**
	 * Isbn 으로 정보를 검색
	 * @param isbn
	 * @return 책 리스트
	 */
	public ArrayList<Book> searchByNumber(String isbn);
	/**
	 * Title로 정보를 검색하는 기능(파라메터로 주어진 제목을 포함하는 모든 정보)
	 * @param title
	 * @return 책 리스트
	 */
	public ArrayList<Book> searchByTitle(String title);
	/**
	 * Book만 검색
	 * @return 책 리스트
	 */
	public ArrayList<Book> onlyBook();
	/**
	 * Magazine만 검색
	 * @return 책 리스트
	 */
	public ArrayList<Book> onlyMagazine();
	/**
	 * 가격으로 검색 (파라메터로 주어진 가격보다 낮은 도서 정보 검색)
	 * @param price
	 * @return 책 리스트
	 */
	public ArrayList<Book> searchByPrice(int price);
	/**
	 * 저장된 모든 도서의 금액 합계
	 * @return 재고 도서들의 수량*금액을 합한 금액
	 */
	public int getTotalAmount();
	/**
	 * 저장된 모든 도서의 금액 평균
	 * @return 모든 도서 금액의 평균 값
	 */
	public float avgPrice();
}
