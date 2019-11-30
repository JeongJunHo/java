package com.ssafy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
					,"ssafy","ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection close fail");
		}
	}
	public void close(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement close fail");
		}
	}
	public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ResultSet close fail");
		}
	}
	public void insertBook(Book book) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();
			String sql = "insert into book (isbn, title, publisher, price, description) values(?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1, book.getIsbn());
			st.setString(2, book.getTitle());
			st.setString(3, book.getPublisher());
			st.setInt(4, book.getPrice());
			st.setString(5, book.getDescription());
			
			if(st.executeUpdate() == 1){
				System.out.println("입력 완료");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			close(st);
			close(conn);
		}
	}
	public void updateBook(Book book) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = getConnection();
			
			String sql = "update book set ";
			sql += "title = ?,";
			sql += "publisher = ?,";
			sql += "price = ?,";
			sql += "description = ?";
			sql += "where isbn = ?";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1, book.getTitle());
			st.setString(2, book.getPublisher());
			st.setInt(3, book.getPrice());
			st.setString(4, book.getDescription());
			st.setString(5, book.getIsbn());
			
			if(st.executeUpdate() == 1){
				System.out.println("수정  완료");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
			close(conn);
		}
	}
	public void deleteBook(String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = getConnection();
			String sql = "delete from book where isbn = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, isbn);
			st.executeUpdate();
//			if(st.executeUpdate(sql) == 1){
//				System.out.println("삭제 완료");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(st);
			close(conn);
		}
	}
	public Book findBook(String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Book book = null;
		
		try {
			conn = getConnection();
			String sql = "select a.isbn, a.title, a.publisher, a.price, a.description, b.name "
					+ "from book a left join Author b on a.authorno = b.authorno "
					+ "where a.isbn = ? limit 1";
			st = conn.prepareStatement(sql);
			st.setString(1, isbn);
			rs = st.executeQuery();
			
			book = new Book();
			while(rs.next()) {
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				book.setAuthName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(conn);
		}
		
		return book;
	}
	public List<Book> listBooks(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		
		try {
			conn = getConnection();
			String sql = "select a.isbn, a.title, a.publisher, a.price, a.description, b.name "
					+ "from book a left join Author b on a.authorno = b.authorno ";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				book.setAuthName(rs.getString("name"));
				
				list.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(conn);
		}
		
		return list;
	}
	
	public int count() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			String sql = "";
			sql += "select count(isbn)";
			sql += "from book";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			cnt = rs.getInt(0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(conn);
		}
		
		return cnt;
	}
}
