package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 연결
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
					,"ssafy","ssafy");
			// 3. Query 작성
			st = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			String sal = sc.next();
			int deptno = sc.nextInt();
			String sql = "select * from emp where sal > " + sal + " and deptno = " + deptno;
//		boolean execute = st.execute(sql);
			// 4. Query 실행 
			rs = st.executeQuery(sql);
			// 5. 결과 추출
			while (rs.next()) {
				EMPVO emp = new EMPVO();
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getInt("sal"));
				System.out.println(emp.toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 닫기
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("닫기 실패");
			}
		}
	}
}
