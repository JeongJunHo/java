package edu.ssafy.chap05;

public class PolyMain02 {
	public static void main(String[] args) {
		 Customer c = new Customer();
		 VipCustomer vc = new VipCustomer();
		 Customer cc = new VipCustomer();
		 
		 System.out.println(cc.showMoney());
	}
}
