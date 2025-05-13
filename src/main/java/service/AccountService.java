package service;

import java.util.ArrayList;
import java.util.List;

import dao.TweetDAO;
import model.Account;
import model.User;

public class AccountService {
	
	public List<Account> userTweet(User user, String tweet) {
		// データベースにtweetを登録する中継メソッド
		TweetDAO dao = new TweetDAO();
		boolean result = dao.addTweet(user, tweet);
		// データベースに登録されているtweetを取得する中継メソッド
		if (result) {
			return dao.selectTweet(user);
		} else {
			return new ArrayList<Account>();
		}
	}
	public List<Account> selectTweet(User user){
		// データベースからユーザーのtweetを取得する中継メソッド
		return new TweetDAO().selectTweet(user);
	}
	public List<Account> selectTweet(){
		// データベースから全てのtweetを取得する中継メソッド
		return new TweetDAO().selectTweet();
	}
	public boolean tweetDelete(User user) {
		// データベースからアカウント情報を削除する
		return new TweetDAO().tweetDelete(user);
	}
}
