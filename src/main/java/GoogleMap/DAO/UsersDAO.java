package GoogleMap.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GoogleMap.Bean.LoginInfo;

public class UsersDAO {
	private String url = "jdbc:postgresql:googlemap";
	private String user = "kouki";
	private String pass = "himitu";
	
	// UsersDAOのコンストラクタ
	public UsersDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました");
		}
	}
	
	// Login.jsp
	// ログイン時の処理
	public LoginInfo loginAndGetLoginInfo(String username, String password) throws DAOException {
		// 実行するSQL
		String SQL = "SELECT usersid, name, pass FROM users WHERE name = ? AND pass = ?";
		
		try (
			// DB接続
			Connection con = DriverManager.getConnection(url, user, pass);
			// SQLの準備
			PreparedStatement state = con.prepareStatement(SQL)
		){
			state.setString(1, username);
			state.setString(2, password);
			
			// 結果取得
			ResultSet results = state.executeQuery();
			
			// 結果格納用の変数
			int gotUsersidLogin = 0;
			String gotName = null;
			String gotPass = null;
			
			// 結果格納
			while(results.next()) {
				gotUsersidLogin = results.getInt("usersid");
				gotName = results.getString("name");
				gotPass = results.getString("pass");
			}
			
			// LoginInfo
			LoginInfo info = new LoginInfo();
			
			// ログイン判定
			// ユーザ名・パスワードが取得できていない場合、ログイン不可
			if (gotName == null || gotPass == null) {
				info.setLogin(false);
				
			}
			
			// 入力されたユーザ名・パスワードが、DBの格納値と等しい場合、ログイン可能
			if (username.equals(gotName) && password.equals(gotPass)) {
				info.setLogin(true);
				// loginInfo(Map)に情報格納
				info.setUsersid(gotUsersidLogin);
				info.setName(username);
				
			} else {
				// その他の場合、ログイン不可
				info.setLogin(false);
				
			}

			return info;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// その他の場合、ログイン不可
		return null;
	}
	
	
	// RegisterCert.jsp
	// 新規登録した際の情報取得
	public LoginInfo getRegisteredLoginInfo() throws DAOException {
		// 実行するSQL
		String SQL = "SELECT usersid, name FROM users WHERE usersid = (SELECT COUNT(*) FROM users)";
		
		try(
			//DB接続
			Connection con = DriverManager.getConnection(url, user, pass);
			//SQL準備
			PreparedStatement state = con.prepareStatement(SQL);
		){
			// 結果取得
			ResultSet results = state.executeQuery();
			
			int gotUsersidRegister = 0;
			String gotName = null;
			
			// 結果格納
			while(results.next()) {
				gotUsersidRegister = results.getInt("usersid");
				gotName = results.getString("name");				
			}
			
			// LoginInfoに格納
			LoginInfo info = new LoginInfo();
			
			// loginInfo(Map)に情報格納
			info.setLogin(true);
			info.setUsersid(gotUsersidRegister);
			info.setName(gotName);
			
			return info;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// RegisterCert.jsp
	// 新規登録時の処理
	public void register(String name, String password, String email, int sex, String birthday) throws DAOException{
		// 実行するSQL
		String SQL = "INSERT INTO users(name, pass, email, sex, birthday) VALUES (?, ?, ?, ?, ?)";
		
		try(
			//DB接続
            Connection con = DriverManager.getConnection(url, user, pass);
            //SQL準備
            PreparedStatement state = con.prepareStatement(SQL);
        ){
			// SQLにVALUESをセット
			state.setString(1, name);
			state.setString(2, password);
			state.setString(3, email);
			state.setInt(4, sex);
			state.setString(5, birthday);
			
			// 更新実行
			state.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// RegisterInput.jsp/RegisterCert.jsp
	// 複数回の同一レコード登録防止用
	public boolean checkRecords(String name, String email) throws DAOException {
		// 実行するSQL
		String SQL = "SELECT COUNT(*) FROM users WHERE name = ? OR email = ?";
		
		try(
			//DB接続
            Connection con = DriverManager.getConnection(url, user, pass);
            //SQL準備
            PreparedStatement state = con.prepareStatement(SQL);
        ){
			// SQLにVALUESをセット
			state.setString(1, name);
			state.setString(2, email);
			// 結果取得
			ResultSet result = state.executeQuery();
			int count = 0;
			
			while(result.next()) {
				count = result.getInt("count");
			}
			
			// すでに同一ユーザ名または同一メールアドレスのレコードが存在している場合
			if (count > 0) {
				return false;
				
			} else {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// ResignCert.jsp
	// 退会処理
	public void deleteUser(int id) throws DAOException {
		// 実行するSQL
		String SQL = "DELETE FROM users WHERE usersid = ?";
		
		try(
			//DB接続
            Connection con = DriverManager.getConnection(url, user, pass);
            //SQL準備
            PreparedStatement state = con.prepareStatement(SQL);
        ){
			// SQLに主キーの条件をセット
			state.setInt(1, id);
			// 削除実行
			state.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}





























