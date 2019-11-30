package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest1 {
	public static void main(String[] args) throws Exception {
		// 1. Driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. Connection 연결
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
				,"ssafy","ssafy");
		// 3. Query 작성
		Statement st = conn.createStatement();
		String sql = "select * from emp";
//		boolean execute = st.execute(sql);
		// 4. Query 실행 
		ResultSet rs = st.executeQuery(sql);
		// 5. 결과 추출
		while (rs.next()) {
			EMPVO emp = new EMPVO();
			emp.setEname(rs.getString("ename"));
			emp.setSal(rs.getInt("sal"));
			System.out.println(emp.toString());
		}
		
		// 6. 닫기
		rs.close();
		st.close();
		conn.close();
	}
}
