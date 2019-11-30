package com.ssafy.car;

public class CarTest {
	public static void main(String[] args) {
		CarMgr cm = CarMgr.getInstance();
		
		//차량추가
		cm.add(new Car("1111","A카",1000000));
		cm.add(new Car("2222","B카",2000000));
		cm.add(new Car("3333","C카",3000000));
		cm.add(new Bus("4444","A버스",4000000,40));
		cm.add(new Bus("5555","B버스",5000000,50));
		cm.add(new Bus("6666","C버스",6000000,60));
		cm.add(new Truck("7777","A트럭",7000000,1));
		cm.add(new Truck("8888","B트럭",8000000,5));
		cm.add(new Truck("9999","C트럭",9000000,10));
		
		//모든차 검색
		System.out.println("모든차량 검색");
		for (Car car : cm.search()) {
			System.out.println(car.toString());
		}
		System.out.println();
		
		//차량번호 검색
		System.out.println("차량번호 검색");
		Car car1 = cm.search("1111");
		if(car1 != null) {
			System.out.println(car1.toString());
		}else {
			System.out.println("차량이 존재하지 않습니다.");
		}
		System.out.println();
		
		//지정된 가격보다 작은 차량 정보 검색
		System.out.println("차량 가격 검색");
		for (Car car : cm.search(4000000)) {
			System.out.println(car.toString());
		}
		System.out.println();
		
		//차량 삭제
		System.out.println("차량 삭제");
		cm.delete("1111");
		cm.delete("0000");
		for (Car car : cm.search()) {
			System.out.println(car.toString());
		}
		System.out.println();
		
		//차량 수량
		System.out.println("차량 수량");
		System.out.println(cm.size());
		System.out.println();
		
		//차량의 금액합계
		System.out.println("차량의 금액합계");
		System.out.println(cm.totalPrice());
	}
}
