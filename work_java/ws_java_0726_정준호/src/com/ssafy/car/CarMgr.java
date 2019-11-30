package com.ssafy.car;

public class CarMgr {
	private Car[] cars = new Car[100];
	private int index;
	private static CarMgr cm = new CarMgr();
	/**
	 * singleton
	 * @return
	 */
	public static CarMgr getInstance() {
		return cm;
	}
	/**
	 * 차량정보 저장
	 * @param c
	 */
	public void add(Car c) {
		cars[index] = c;
		index++;
	}
	/**
	 * 모든차량조회
	 * @return
	 */
	public Car[] search() {
		Car[] tmp = new Car[index];
		for (int i = 0; i < index; i++) {
			tmp[i] = cars[i];
		}
		
		return tmp;
	}
	/**
	 * 차량번호로 검색
	 * @param num
	 * @return
	 */
	public Car search(String num) {
		for (int i = 0; i < index; i++) {
			if(cars[i].getNum().equals(num)){
				return cars[i];
			}
		}
		
		return null;
	}
	/**
	 * 지정된 가격보다 작은 차량 정보 검색
	 * @param price
	 * @return
	 */
	public Car[] search(int price) {
		int cnt = 0;
		Car[] search = new Car[index];
		
		for (int i = 0; i < index; i++) {
			if(cars[i].getPrice() <= price) {
				search[cnt] = cars[i];
				cnt++;
			}
		}
		
		Car[] result = new Car[cnt];
		System.arraycopy(search, 0, result, 0, cnt);
		
		return result;
	}
	/**
	 * 차량 가격 업데이트
	 * @param num
	 * @param price
	 */
	public void update(String num, int price) {
		for (int i = 0; i < index; i++) {
			if(cars[i].getNum().equals(num)) {
				cars[i].setPrice(price);
			}
		}
	}
	/**
	 * 차량 삭제
	 * @param num
	 */
	public void delete(String num) {
		if(index > 0) {
			for (int i = 0; i < index; i++) {
				if(cars[i].getNum().equals(num)) {
					cars[i] = cars[index-1];
					cars[index-1] = null;
					index--;
				}
			}
		}
	}
	/**
	 * 차량 수량
	 * @return
	 */
	public int size() {
		return index;
	}
	/**
	 * 차량 금액 합계
	 * @return
	 */
	public int totalPrice() {
		int total = 0;
		for (int i = 0; i < index; i++) {
			total += cars[i].getPrice();
		}
		return total;
	}
}
