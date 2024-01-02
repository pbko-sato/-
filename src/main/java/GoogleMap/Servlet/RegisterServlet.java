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

import GoogleMap.Bean.LoginInfo;
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
				Common.gotoPage(request, response, "/pages/RegisterInput.jsp");
				break;
			
			// RegisterInput.jsp 「TOPへ」ボタン押下時
			case "ReturnToTop":
				// 既存のセッション取得
				HttpSession sessionReturnToTop = request.getSession(false);
				// セッション削除
				sessionReturnToTop.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top.jsp");
				break;
				
			// RegisterInput.jsp 「確認する」ボタン押下時
			case "GoToCert":
				//既存のセッション取得
				HttpSession sessionGoToCert = request.getSession(false);
				// パラメータ取得
				String username = request.getParameter("username");
				String pass = request.getParameter("password");
				String email = request.getParameter("email");
				int sex = Integer.parseInt(request.getParameter("sex"));
				int age = Integer.parseInt(request.getParameter("age"));
				
				// 同一レコードのチェック
				UsersDAO usersDaoInput = new UsersDAO();
				boolean isInitialRecordInput = usersDaoInput.checkRecords(username, email);
				if(!isInitialRecordInput) {
					sessionGoToCert.setAttribute("registerFailureMessage", ErrorMessage.registerFailureMessage);
					Common.gotoPage(request, response, "/pages/RegisterInput.jsp");
					break;
					
				}
				
				// 性別・年齢は表示用にStringを作成
				String sexStr = UsersMethod.displaySex(sex);
				String ageStr = UsersMethod.displayAge(age);
				
				// UsersBeanに情報格納(性別・年齢の文字列は別個格納)
				UsersBean usersBean = new UsersBean(username, pass, email, sex, age);
				sessionGoToCert.setAttribute("usersBean", usersBean);
				sessionGoToCert.setAttribute("sexStr", sexStr);
				sessionGoToCert.setAttribute("ageStr", ageStr);
				// 画面遷移
				Common.gotoPage(request, response, "/pages/RegisterCert.jsp");
				break;
			
			// RegisterCert.jsp 「戻る」ボタン押下時
			case "ReturnToInput":
				// 既存のセッション取得
				HttpSession sessionReturnToInput = request.getSession(false);
				// 同一レコードのメッセージ削除
				sessionReturnToInput.removeAttribute("registerFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, "/pages/RegisterInput.jsp");
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
					sessionExecuteRegister.setAttribute("registerFailureMessage", ErrorMessage.registerFailureMessage);
					Common.gotoPage(request, response, "/pages/RegisterCert.jsp");
					break;
					
				}
				
				String password = execUsersBean.getPass();
				// パスワードハッシュ化
				try {
					MessageDigest digest = MessageDigest.getInstance("SHA-1");
					byte[] result = digest.digest(password.getBytes());
					password = String.format("%040x", new BigInteger(1, result));
					
				} catch (Exception e){
					Common.gotoPage(request, response, "/pages/Error.jsp");
					
				}
				
				// 登録実行(パスワードはハッシュ化)
				usersDao.register(execUsersBean.getName(), password, execUsersBean.getEmail(), execUsersBean.getSex(), execUsersBean.getAge());
				// ログイン情報を取得
				LoginInfo loginInfo = usersDao.getRegisteredLoginInfo();
				
				// セッションのAttribute削除
				sessionExecuteRegister.removeAttribute("usersBean");
				sessionExecuteRegister.removeAttribute("sexStr");
				sessionExecuteRegister.removeAttribute("ageStr");
				sessionExecuteRegister.removeAttribute("registerFailureMessage");
				// ログイン情報のAttribute付加
				sessionExecuteRegister.setAttribute("loginInfo", loginInfo);
				
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top.jsp");
				
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