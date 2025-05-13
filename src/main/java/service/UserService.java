package service;


import dao.UserDAO;
import model.User;

public class UserService {
	
	public boolean check(String name, String pass) {
		// 名前とパスワードが入力されているか確認する
		if (name == null || name.isBlank()) {
			return false;
		}
		if (pass == null || pass.length() < 4) {
			return false;
		}
		if (!pass.matches("[0-9]+")) {
			return false;
		}
		return true;
	}
	public boolean userCheck(User user) {
		// データベースに接続してユーザー情報が登録されていたらidを取得してreturnする中継メソッド
		return new UserDAO().accountCheck(user);
	}
	public boolean userRegister(String name, String pass) {
		// データベースに接続してユーザー情報を登録する中継メソッド
		boolean isCheck = check(name, pass);
		if (isCheck) {
			boolean result = new UserDAO().accountRegister(name, pass);
			return result;
		} 
		return false;
	}
	public boolean userDelete(User user) {
		// データベースからアカウント情報を削除する
		return new UserDAO().accountDelete(user);
	}
}
