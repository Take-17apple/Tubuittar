package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.User;

public class TweetDAO {
	
	private final String DB_URL = "jdbc:mysql://localhost:3306/tubuittar";
	private final String DB_USER = "root";
	private final String DB_PASS = "password1234";
	
	public boolean addTweet(User user, String tweet) {
		// tweetをデータベースに保存する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "INSERT INTO tweet(userId, name, tweet) VALUES(?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, tweet);
			
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Account> selectTweet(User user){
		// データベースに登録されているユーザーのtweetリストを取得する
		List<Account> myTweetList = new ArrayList<Account>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "SELECT name, tweet, userId FROM tweet WHERE userId=? ORDER BY tweetId DESC";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, user.getId());
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String tweet = rs.getString("tweet");
				int userId = rs.getInt("userId");
				Account account = new Account(name, tweet, userId);
				myTweetList.add(account);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myTweetList;
	}
	public List<Account> selectTweet() {
		// データベースに登録されている全てのtweetリストを取得してlistを返す
		List<Account> allTweetList = new ArrayList<Account>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "SELECT name, tweet, userId FROM tweet ORDER BY tweetId DESC";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String tweet = rs.getString("tweet");
				int id = rs.getInt("userId");
				Account account = new Account(name, tweet, id);
				allTweetList.add(account);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allTweetList;
	}
	public boolean tweetDelete(User user) {
		// データベースからアカウント情報を削除して実行結果をbooleanで戻す
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライブを読み込めませんでした");
		}
		String sql = "DELETE FROM tweet WHERE userId = ?";
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
