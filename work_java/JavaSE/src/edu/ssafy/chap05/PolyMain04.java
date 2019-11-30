package edu.ssafy.chap05;

public class PolyMain04 {
	public static void main(String[] args) {
		Manager m = new Manager();
		
		m.addEmployee(new Programmer());
		m.addEmployee(new Teacher());
		m.addEmployee(new Programmer());
		m.addEmployee(new Employee());
		
		m.toWork();
	}
}
