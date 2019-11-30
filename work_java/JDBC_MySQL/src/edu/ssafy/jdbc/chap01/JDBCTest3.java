package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest3 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			// 1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 연결
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
					,"ssafy","ssafy");
			// 3. Query 작성
			System.out.println("임금, 부서번호를 입력하세요.");
			Scanner sc = new Scanner(System.in);
			int sal = sc.nextInt();
			int deptno = sc.nextInt();
			
			//preparstatment 이용
			String sql = "select * from emp where sal > ? and deptno = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, sal);
			st.setInt(2, deptno);
			
//			boolean execute = st.execute(sql);
			// 4. Query 실행 
			rs = st.executeQuery();
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
