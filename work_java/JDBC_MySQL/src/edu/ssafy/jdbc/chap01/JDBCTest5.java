package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest5 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			// 1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 연결
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
					,"ssafy","ssafy");
			
//			String sql = "insert into test(title, body) values(?,?)";
//			String sql = "update test set title=?, body=?";
			String sql = "delete from test where id=?";
			st = conn.prepareStatement(sql);
			//insert
//			st.setString(1, "title1");
//			st.setString(2, "body1");
			
			//update
//			st.setString(1, "change1");
//			st.setString(2, "change1");
			
			//delete
			st.setInt(1, 4);
			
			
			
			
			int row = st.executeUpdate();
			if(row == 1) {
				System.out.println("입력 성공");
			}
			
			String sql2 = "select * from test";
			PreparedStatement st2 = conn.prepareStatement(sql2);
			ResultSet rs2 = st2.executeQuery();
			while(rs2.next()) {
				System.out.println(rs2.getInt("id") + "," + rs2.getString("title") + "," + rs2.getString("body"));
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
