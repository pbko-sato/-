package GoogleMap.Bean;

import java.io.Serializable;

public class UsersBean implements Serializable {
	private int id;
	private String name;
	private String pass;
	private String email;
	private int sex;
	private int age;
	
	//constructor
	public UsersBean(int id, String name, String pass, String email, int sex, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.sex = sex;
		this.age = age;
	}
	// 登録時の確認用にid以外を格納
	public UsersBean(String name, String pass, String email, int sex, int age) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.sex = sex;
		this.age = age;
	}

	// getters
	public int getId() {
		return id;
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
	public int getAge() {
		return age;
	}
	
	// setters
	public void setId(int id) {
		this.id = id;
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
	public void setAge(int age) {
		this.age = age;
	}
}