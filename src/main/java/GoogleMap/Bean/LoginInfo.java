package GoogleMap.Bean;

import java.io.Serializable;

public class LoginInfo implements Serializable{
	private boolean isLogin;
	private int usersid;
	private String name;
	
	// constructor
	public LoginInfo(boolean isLogin, int id, String name) {
		this.isLogin = isLogin;
		this.usersid = id;
		this.name = name;
	}
	public LoginInfo() {}
	
	// getters
	public int getUsersid() {
		return usersid;
	}
	public String getName() {
		return name;
	}
	public boolean isLogin() {
		return isLogin;
	}

	// setters
	public void setUsersid(int id) {
		this.usersid = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
