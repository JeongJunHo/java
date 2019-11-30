package edu.ssafy.jdbc.chap02;

import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) {
		DBManager man = new DBManager();
		man.insertStudent(125, "홍길동", "남", "19880101");
		
		ArrayList<Student> list = man.queryStudent();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
