package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	
	private final String DB_URL = "jdbc:mysql://localhost:3306/tubuittar";
	private final String DB_USER = "root";
	private final String DB_PASS = "haruprogram";
	
	public boolean accountCheck(User user) {
		// データベースに登録されているアカウントと引数のユーザーをチェックして
		// 一致したらユーザーIDを取得する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "SELECT name, pass, id FROM account WHERE name=? AND pass=?";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPass());
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean accountRegister(String name, String pass) {
		// データベースにアカウントを登録する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "INSERT INTO account(name, pass) VALUES(?, ?)";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean accountDelete(User user) {
		// データベースからアカウント情報を削除する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "DELETE FROM account WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, user.getId());
			
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
