package edu.ssafy.jdbc.chap02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	public DBManager() {}
	
	public void insertStudent(int hakbun, String name,String gender, String birthday){
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into student(hakbun, name, gender,birthday) values(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, hakbun);
			st.setString(2, name);
			st.setString(3, gender);
			st.setString(4, birthday);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void updateStudent(int hakbun, String name,String gender, String birthday){
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update student set  name =?, gender=?,birthday=? "
					+ " where hakbun = ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, gender);
			st.setString(3, birthday);
			st.setInt(4, hakbun);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void deleteStudent(int hakbun){
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from student "
					+ " where hakbun = ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, hakbun);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public ArrayList<Student> queryStudent() {
		ArrayList<Student> list = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select hakbun, name, gender, birthday from student";
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Student s = new Student();
				s.setHakbun(rs.getInt("hakbun"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setBirthday(rs.getString("birthday"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	public Student queryStudent(int hakbun) {
		Student s = new Student();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select hakbun, name, gender, birthday from student where hakbun=? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, hakbun);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				s.setHakbun(rs.getInt("hakbun"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setBirthday(rs.getString("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return s;
	}
	
	public void close() {
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
