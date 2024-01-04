package GoogleMap.Servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GoogleMap.Bean.UsersBean;
import GoogleMap.DAO.UsersDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// actionによる処理分岐
		try {
			String action = request.getParameter("action");
			
			switch(action) {
			// header.jsp 「新規登録」リンク押下時
			case "TransitToRegister":
				// 既存のセッション取得
				HttpSession sessionTransitToRegister = request.getSession(false);
				// セッション削除
				sessionTransitToRegister.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Register/RegisterInput.jsp");
				break;
			
			// RegisterInput.jsp 「TOPへ」ボタン押下時
			case "ReturnToTop":
				// 既存のセッション取得
				HttpSession sessionReturnToTop = request.getSession(false);
				// セッション削除
				sessionReturnToTop.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top/Top.jsp");
				break;
				
			// RegisterInput.jsp 「確認する」ボタン押下時
			case "GoToCert":
				//既存のセッション取得
				HttpSession sessionGoToCert = request.getSession(false);
				// パラメータ取得
				String username = request.getParameter("username");
				String pass = request.getParameter("password");
				String passCert = request.getParameter("passwordCert");
				String email = request.getParameter("email");
				String sex = request.getParameter("sex");
				String age = request.getParameter("age");
				
				// UsersBeanに情報格納(バリデーション用)
				UsersBean usersBean = new UsersBean(username, pass, email, Integer.parseInt(sex), Integer.parseInt(age));
				sessionGoToCert.setAttribute("usersBean", usersBean);
				
				// nullチェック
				if(username == null || pass == null || passCert == null || email == null || sex == null || age == null ||
					username.length() == 0 || pass.length() == 0 || passCert.length() == 0 || email.length() == 0 ||
					Integer.parseInt(sex) == 0 || Integer.parseInt(age) == 0) {
					sessionGoToCert.setAttribute("registerInputFailureMessage", ErrorMessage.registerIncompleteInputs);
					sessionGoToCert.setAttribute("usersBean", usersBean);
					Common.gotoPage(request, response, "/pages/Register/RegisterInput.jsp");
					break;
					
				}
				
				// パスワードチェック
				if(!pass.equals(passCert)) {
					sessionGoToCert.setAttribute("registerInputFailureMessage", ErrorMessage.registerIncorrectPassword);
					sessionGoToCert.setAttribute("usersBean", usersBean);
					Common.gotoPage(request, response, "/pages/Register/RegisterInput.jsp");
					break;
				}
				
				// 同一レコードのチェック
				UsersDAO usersDaoInput = new UsersDAO();
				boolean isInitialRecordInput = usersDaoInput.checkRecords(username, email);
				if(!isInitialRecordInput) {
					sessionGoToCert.setAttribute("registerInputFailureMessage", ErrorMessage.registerFailureMessage);
					Common.gotoPage(request, response, "/pages/Register/RegisterInput.jsp");
					break;
					
				}
				
				// 性別・年齢は表示用にStringを作成
				String sexStr = UsersMethod.displaySex(Integer.parseInt(sex));
				String ageStr = UsersMethod.displayAge(Integer.parseInt(age));
				
				// 性別・年齢の文字列をセッションに格納
				sessionGoToCert.setAttribute("sexStr", sexStr);
				sessionGoToCert.setAttribute("ageStr", ageStr);
				// 同一レコードのメッセージ削除
				sessionGoToCert.removeAttribute("registerInputFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Register/RegisterCert.jsp");
				break;
			
			// RegisterCert.jsp 「戻る」ボタン押下時
			case "ReturnToInput":
				// 既存のセッション取得
				HttpSession sessionReturnToInput = request.getSession(false);
				// 同一レコードのメッセージ削除
				sessionReturnToInput.removeAttribute("registerCertFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Register/RegisterInput.jsp");
				break;
				
			// RegisterCert.jsp 「登録する」ボタン押下時
			case "ExecuteRegister":
				// 既存のセッション取得
				HttpSession sessionExecuteRegister = request.getSession(false);
				// セッションからusersBean取得
				UsersBean execUsersBean = (UsersBean)sessionExecuteRegister.getAttribute("usersBean");
				
				// 同一レコードのチェック
				UsersDAO usersDao = new UsersDAO();
				boolean isInitialRecord = usersDao.checkRecords(execUsersBean.getName(), execUsersBean.getEmail());
				if(!isInitialRecord) {
					sessionExecuteRegister.setAttribute("registerCertFailureMessage", ErrorMessage.registerFailureMessage);
					Common.gotoPage(request, response, "/pages/Register/RegisterCert.jsp");
					break;
					
				}
				
				// nullチェック
				UsersBean usersBeanExec = (UsersBean)sessionExecuteRegister.getAttribute("usersBean");
				if(usersBeanExec.getName() == null || usersBeanExec.getPass() == null || usersBeanExec.getEmail() == null ||
					usersBeanExec.getSex() == 0 || usersBeanExec.getAge() == 0) {
					sessionExecuteRegister.setAttribute("registerCertFailureMessage", ErrorMessage.registerIncompleteInputs);
					Common.gotoPage(request, response, "/pages/Register/RegisterCert.jsp");
					break;
					
				}
				
				// パスワードハッシュ化
				String password = execUsersBean.getPass();
				try {
					MessageDigest digest = MessageDigest.getInstance("SHA-1");
					byte[] result = digest.digest(password.getBytes());
					password = String.format("%040x", new BigInteger(1, result));
					
				} catch (Exception e){
					Common.gotoPage(request, response, "/pages/Error.jsp");
					
				}
				
				// 登録実行(パスワードはハッシュ化)
				usersDao.register(execUsersBean.getName(), password, execUsersBean.getEmail(), execUsersBean.getSex(), execUsersBean.getAge());
				
				// セッションのAttribute削除
				sessionExecuteRegister.removeAttribute("usersBean");
				sessionExecuteRegister.removeAttribute("sexStr");
				sessionExecuteRegister.removeAttribute("ageStr");
				sessionExecuteRegister.removeAttribute("registerCertFailureMessage");
				// ログイン情報を取得・ログイン情報のAttribute付加
				sessionExecuteRegister.setAttribute("loginInfo", usersDao.getRegisteredLoginInfo());
				
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top/Top.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class UsersMethod {
	// 性別の表示
	public static String displaySex(int sex) {
		String sexStr = null;
		
		switch(sex) {
		case 1:
			sexStr = "男性";
			break;
		case 2:
			sexStr = "女性";
			break;
		case 3:
			sexStr = "その他";
			break;
		default:
			break;
		}
		return sexStr;
	}
	
	// 年齢の表示
	public static String displayAge(int age) {
		String ageStr = null;
		
		switch(age) {
		case 0:
			ageStr = "年齢が洗濯されていません";
			break;
		case 10:
			ageStr = "10代以下";
			break;
		case 20:
			ageStr = "20代";
			break;
		case 30:
			ageStr = "30代";
			break;
		case 40:
			ageStr = "40代";
			break;
		case 50:
			ageStr = "50代";
			break;
		case 60:
			ageStr = "60代";
			break;
		case 70:
			ageStr = "70代以上";
			break;
		default:
			break;
		}
		return ageStr;
	}
}