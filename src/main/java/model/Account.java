package model;

import java.io.Serializable;

public class Account implements Serializable {
	// ユーザーのツイート情報を格納するクラス
	private String name;
	private String tweet;
	private int id;
	
	public Account() {
		
	}
	public Account(String name, String tweet) {
		this.name = name;
		this.tweet = tweet;
	}
	public Account(String name, String tweet, int id) {
		this(name, tweet);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getTweet() {
		return tweet;
	}
	public int getId() {
		return id;
	}
	
}
