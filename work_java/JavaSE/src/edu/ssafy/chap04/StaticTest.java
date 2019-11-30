package edu.ssafy.chap04;

public class StaticTest {
	int i;
	static int si;
	
	static void mSt() {
		
	}
	
	void mMe() {
		
	}
	
	// instance block
	{
		System.out.println("Instance block");
	}
	
	static {
		System.out.println("static block");
	}
	
	public StaticTest() {
		System.out.println("디폴트");
	}
	
	public StaticTest(int a) {
		System.out.println("매개변수1");
	}
	
	public static void main(String[] args) {
//		StaticTest.mSt();
		StaticTest st = new StaticTest();
//		st.i = 100;
//		st.mMe();
//		StaticTest.si = 200;
//		st.si = 300;
//		System.out.println(StaticTest.si);
		StaticTest st2 = new StaticTest(1);
//		System.out.println(st2.si);
	}
	
	class Another{
		
	}
}