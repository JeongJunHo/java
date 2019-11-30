package edu.ssafy.chap05;

public class PolyMain01 {
	public static void main(String[] args) {
//		Customer c = new Customer();
//		VipCustomer vc = new VipCustomer();
//		
//		Customer cc = (Customer)new VipCustomer();
		
		Customer[] arr = new Customer[3];
		arr[0] = new Customer();
		arr[1] = new VipCustomer();
		arr[2] = new BlackList();
		
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j].toString()+ "\n");
		}
	}
}
