package com.ssafy.hw;

import java.util.ArrayList;

public interface IProductMgr {
	/**
	 * 상품정보를 저장(TV, Refrigerator, SmartPhone)
	 * @param product
	 */
	public void addProduct(Product product);
	/**
	 * 상품정보 전체를 검색
	 * @return
	 */
	public ArrayList<Product> list();
	/**
	 * 상품번호로 상품을 검색
	 * @param code
	 * @return
	 */
	public Product searchByCode(String code);
	/**
	 * 상품명으로 상품을 검색하는 기능(상품명 부분 검색 기능)
	 * @param name
	 * @return
	 */
	public ArrayList<Product> searchByName(String name);
	/**
	 * 상품명과 금액을 입력받아 그 상품명을 포함하고, 지정금액이하인 상품목록을 리턴
	 * @param name 이름
	 * @param price 
	 * @return 제품리스트
	 */
	public ArrayList<Product> searchByName(String name, int price);
	/**
	 * TV정보만 검색
	 * @return
	 */
	public ArrayList<Product> tvList();
	/**
	 * Refrigerator정보만 검색
	 * @return
	 */
	public ArrayList<Product> refrigeratorList();
	/**
	 * 400리터 이상의 Refrigerator 검색
	 * @return
	 */
	public ArrayList<Product> over400Lrefrigerator();
	/**
	 * 50inch 이상의 TV 검색
	 * @return
	 */
	public ArrayList<Product> over50InchTV();
	/**
	 * 상품번호와 가격을 입력 받아 상품 가격을 변경
	 * @param code
	 * @param price
	 */
	public void updatePrice(String code, int price);
	/**
	 * 상품번호로 상품을 삭제하는 기능
	 * @param code
	 */
	public void delete(String code);
	/**
	 * 전체 재고 상품 금액
	 * @return
	 */
	public int totalPrice();
}
