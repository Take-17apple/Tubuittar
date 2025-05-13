package model;

import java.io.Serializable;

public class User implements Serializable {
	// ユーザー情報を格納するクラス
	private String name;
	private String pass;
	private int id;
	
	public User() {
		
	}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public User(String name, String pass, int id) {
		this(name, pass);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
