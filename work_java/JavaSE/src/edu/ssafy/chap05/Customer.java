package edu.ssafy.chap05;

public class Customer {
	protected String name;
	protected int age;
	String addr;
	
	public int money = 1000;
	
	public int showMoney() {
		return money;
	}
	
	public Customer() {
//		System.out.println("Customer Constructor1");
	}
	public Customer(String name, int age, String addr) {
//		System.out.println("Customer Constructor2");
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
