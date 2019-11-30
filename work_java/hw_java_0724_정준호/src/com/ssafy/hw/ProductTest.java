package com.ssafy.hw;

public class ProductTest {
	public static void main(String[] args) {
		TV samsungSmart = new TV(1,"삼성스마트TV",1500000,100,40f,"OLED");
		System.out.println(samsungSmart.toString());
		samsungSmart.sell(12);
		
		Refrigerator samsungTwinDoor = new Refrigerator(2,"삼성양문형냉장고",2000000,100,550);
		System.out.println(samsungTwinDoor.toString());
		samsungTwinDoor.sell(140);
		samsungTwinDoor.sell(2);
		samsungTwinDoor.sell(2);
		samsungTwinDoor.sell(2);
		System.out.println(samsungTwinDoor.toString());
	}
}
