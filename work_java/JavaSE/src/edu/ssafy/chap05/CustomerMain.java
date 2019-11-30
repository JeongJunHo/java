package edu.ssafy.chap05;

public class CustomerMain {
	public static void main(String[] args) {
//		Customer c = new Customer("둘리",8,"쌍문동");
//		System.out.println(c.toString());
//		Customer c2 = new Customer("또치",10,"쌍문동");
//		System.out.println(c2.toString());
//		
		VipCustomer vc = new VipCustomer("고길동", 40, "쌍문동", "둘리혼내기");
//		System.out.println(vc.toString());
		
		Customer cu = new VipCustomer();
		
		VipCustomer cu2 = (VipCustomer) cu;
		
		cu2.setService("ddd");
		
		System.out.println(cu2.getService());
	}
}
