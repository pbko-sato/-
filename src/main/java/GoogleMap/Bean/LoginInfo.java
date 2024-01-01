package GoogleMap.Bean;

import java.io.Serializable;

public class LoginInfo implements Serializable{
	private boolean isLogin;
	private int id;
	private String name;
	
	// constructor
	public LoginInfo(boolean isLogin, int id, String name) {
		this.isLogin = isLogin;
		this.id = id;
		this.name = name;
	}
	public LoginInfo() {}
	
	// getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean isLogin() {
		return isLogin;
	}

	// setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
