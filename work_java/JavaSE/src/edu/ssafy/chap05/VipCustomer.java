package edu.ssafy.chap05;

public class VipCustomer extends Customer {
	String service;
	
	public int money = 9000;
	
	public int showMoney() {
		return money;
	}
	
	public VipCustomer() {
//		System.out.println("VipCustomer Constructor1");
	}

	public VipCustomer(String name, int age, String addr, String service) {
		super(name,age,addr);
//		System.out.println("VipCustomer Constructor2");
		this.service = service;
	}

	@Override
	public String toString() {
		System.out.println(this.name);
		return "VipCustomer [name=" + name + ", age=" + age + ", addr=" + addr + ", service=" + service + "]";
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
