package com.ssafy.hw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IProductMgr {
	/**
	 * 상품정보를 저장(TV, Refrigerator, SmartPhone)
	 * @param product 상품
	 * @throws DuplicateException 코드중복예외
	 */
	public void addProduct(Product product) throws DuplicateException;
	/**
	 * 상품정보 전체를 검색
	 * @return 상품리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> list() throws ProductNotFoundException;
	/**
	 * 상품번호로 상품을 검색
	 * @param code
	 * @return 상품
	 * @throws CodeNotFoundException 코드를 못 찾았을 경우
	 */
	public Product searchByCode(String code) throws CodeNotFoundException;
	/**
	 * 상품명으로 상품을 검색하는 기능(상품명 부분 검색 기능)
	 * @param name 제품번호
	 * @return 상품리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> searchByName(String name) throws ProductNotFoundException;
	/**
	 * 상품명과 금액을 입력받아 그 상품명을 포함하고, 지정금액이하인 상품목록을 리턴
	 * @param name 제품번호
	 * @param price 기준 가격(입력한 가격보다 낮거나 같은 제품 검색)
	 * @return 상품리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> searchByName(String name, int price) throws ProductNotFoundException;
	/**
	 * TV정보만 검색
	 * @return TV리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> tvList() throws ProductNotFoundException;
	/**
	 * Refrigerator정보만 검색
	 * @return 냉장고리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> refrigeratorList() throws ProductNotFoundException;
	/**
	 * 400리터 이상의 Refrigerator 검색
	 * @return 냉장고리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> over400Lrefrigerator() throws ProductNotFoundException;
	/**
	 * 50inch 이상의 TV 검색
	 * @return TV리스트
	 * @throws ProductNotFoundException
	 */
	public ArrayList<Product> over50InchTV() throws ProductNotFoundException;
	/**
	 * 상품번호와 가격을 입력 받아 상품 가격을 변경
	 * @param code 제품번호
	 * @param price 변경 가격
	 * @throws CodeNotFoundException
	 */
	public void updatePrice(String code, int price) throws CodeNotFoundException;
	/**
	 * 상품번호로 상품을 삭제하는 기능
	 * @param code 제품번호
	 * @throws CodeNotFoundException
	 */
	public void delete(String code) throws CodeNotFoundException;
	/**
	 * 전체 재고 상품 금액
	 * @return 전체 재고 상품 총액
	 */
	public int totalPrice();
	/**
	 * 데이터 저장 (product.dat)
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void save() throws FileNotFoundException, IOException;
	/**
	 * 데이터 불러오기 (product.dat)
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void load() throws ClassNotFoundException, IOException;
}
