package GoogleMap.Bean;

import java.io.Serializable;

public class UsersBean implements Serializable {
	private int usersid;
	private String name;
	private String pass;
	private String email;
	private int sex;
	private String birthday;
	
	//constructor
	public UsersBean(int id, String name, String pass, String email, int sex, String birthday) {
		super();
		this.usersid = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
	}
	// 登録時の確認用にid以外を格納
	public UsersBean(String name, String pass, String email, int sex, String birthday) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
	}
	// 会員情報更新時、ユーザ名・パスワード・メールアドレスのみのオブジェクト作成
	public UsersBean(String name, String pass, String email) {
		this.name = name;
		this.pass = pass;
		this.email = email;
	}
	public UsersBean() {}

	// getters
	public int getUsersid() {
		return usersid;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getEmail() {
		return email;
	}
	public int getSex() {
		return sex;
	}
	public String getBirthday() {
		return birthday;
	}
	
	// setters
	public void setUsersid(int id) {
		this.usersid = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}