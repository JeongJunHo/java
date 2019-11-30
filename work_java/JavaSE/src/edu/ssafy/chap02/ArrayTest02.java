package edu.ssafy.chap02;

public class ArrayTest02 {
	private void main() {
		// TODO Auto-generated method stub
		int[] a = new int[3];
		Member m = new Member();
		Member[] memberList = new Member[2];
		memberList[0] = m;
		
		System.out.println(memberList[0].toString());
	}
}

class Member{
	
}