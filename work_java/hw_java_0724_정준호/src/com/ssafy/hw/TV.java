package com.ssafy.hw;

public class TV {
	private int no;
	private String name;
	private int price;
	private int cnt;
	private float inch;
	private String type;
	
	public TV() {}

	public TV(int no, String name, int price, int cnt, float inch, String type) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.inch = inch;
		this.type = type;
	}
	
	public String toString() {
		String result = "";
		result += "제품 번호 : " + no + "\n";
		result += "제품 이름 : " + name + "\n";
		result += "가격 : " + price + "원\n";
		result += "수량 : " + cnt + "개\n";
		result += "인치 : " + inch + "inch\n";
		result += "디스플레이 타입 : " + type + "\n";
		
		return result;
	}
	
	//수량만큼 판매
	public void sell(int cnt) {
		if(cnt > this.cnt) {
			System.out.println("잔여수량이 부족합니다. 잔여수량 : " + this.cnt + "\n");
		}else {
			this.cnt -= cnt;
			System.out.println("잔여수량 : " + this.cnt + "\n");
		}
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public float getInch() {
		return inch;
	}

	public void setInch(float inch) {
		this.inch = inch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
