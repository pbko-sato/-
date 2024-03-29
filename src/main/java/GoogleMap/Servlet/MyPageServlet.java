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
import GoogleMap.Models.Common;
import GoogleMap.Models.ErrorMessage;
import GoogleMap.Models.PagesAndUrls;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		// 送信するレスポンスパラメータの文字コードを指定
		response.setContentType("text/html;charset=UTF-8");

		// actionによる処理分岐
		try {
			String action = request.getParameter("action");
			
			switch(action) {
			// MyPage.jsp 「会員情報更新」リンク押下時
			case "TransitToRenewInput":
				// 既存のセッション取得
				HttpSession sessionRenewInput = request.getSession(false);
				// ログイン情報取得
				LoginInfo loginInfoRenewInput = (LoginInfo) sessionRenewInput.getAttribute("loginInfo");
				// 会員情報取得
				UsersDAO  usersDaoRenewInput = new UsersDAO();
				UsersBean usersBeanRenewInput = usersDaoRenewInput.getUsersInfo(loginInfoRenewInput.getUsersid());
				
				//セッションにユーザ情報を格納
				sessionRenewInput.setAttribute("usersBean", usersBeanRenewInput);
				sessionRenewInput.setAttribute("sexStr", Common.displaySex(usersBeanRenewInput.getSex()));
				sessionRenewInput.setAttribute("birthdayStr", Common.displayBirthday(usersBeanRenewInput.getBirthday()));
				sessionRenewInput.setAttribute("ageStr", Common.calculateAge(usersBeanRenewInput.getBirthday()));
				
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.RENEW_INPUT);
				break;
				
			// MyPage.jsp 「退会」リンク押下時
			case "TransitToResignCert":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.RESIGN_CERT);
				break;
				
			// RenewInput.jsp 「マイページへ」ボタン押下時
			// ResignCert.jsp 「マイページへ」ボタン押下時
			case "ReturnToMyPage":
				//既存のセッション取得
				HttpSession sessionReturnToMyPage = request.getSession(false);
				// エラーメッセージ削除				
				sessionReturnToMyPage.removeAttribute("renewInputFailureMessage");
				sessionReturnToMyPage.removeAttribute("usersBean");
				sessionReturnToMyPage.removeAttribute("sexStr");
				sessionReturnToMyPage.removeAttribute("birthdayStr");
				sessionReturnToMyPage.removeAttribute("ageStr");
				sessionReturnToMyPage.removeAttribute("resignFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.MY_PAGE);
				break;
				
			// RenewInput.jsp 「確認する」ボタン押下時
			case "GoToCert":
				// 既存のセッション取得
				HttpSession sessionGoToCert = request.getSession(false);
				
				// パラメータ取得
				String username = request.getParameter("username");
				String pass = request.getParameter("password");
				String passCert = request.getParameter("passwordCert");
				String email = request.getParameter("email");
				
				// UsersBeanに情報格納(バリデーションに引っかかった時用)
				UsersBean tmpUsersBean = new UsersBean(username, pass, email);
				
				// nullチェック
				if(username == null || pass == null || passCert == null || email == null ||
					username.length() == 0 || pass.length() == 0 || passCert.length() == 0 || email.length() == 0) {
					sessionGoToCert.setAttribute("renewInputFailureMessage", ErrorMessage.registerRenewIncompleteInputs);
					sessionGoToCert.setAttribute("usersBean", tmpUsersBean);
					Common.gotoPage(request, response, PagesAndUrls.RENEW_INPUT);
					break;
					
				}
				
				// パスワードチェック
				if(!pass.equals(passCert)) {
					sessionGoToCert.setAttribute("renewInputFailureMessage", ErrorMessage.registerRenewIncorrectPassword);
					sessionGoToCert.setAttribute("userBean", tmpUsersBean);
					Common.gotoPage(request, response, PagesAndUrls.RENEW_INPUT);
					break;
					
				}
				
				// 同一レコードのチェック
				UsersDAO usersDaoInput = new UsersDAO();
				LoginInfo infoInput = (LoginInfo) sessionGoToCert.getAttribute("loginInfo");
				boolean isInitialRecordInput = usersDaoInput.checkRecordsForRenew(infoInput.getUsersid(), username, email);
				if(!isInitialRecordInput) {
					sessionGoToCert.setAttribute("renewInputFailureMessage", ErrorMessage.registerRenewFailureMessage);
					Common.gotoPage(request, response, PagesAndUrls.RENEW_INPUT);
					break;
					
				}
				
				// 正式にUsersBeanをセッションに格納
				sessionGoToCert.setAttribute("usersBean", tmpUsersBean);
				// エラーメッセージ削除
				sessionGoToCert.removeAttribute("renewInputFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.RENEW_CERT);
				break;
				
			// RenewCert.jsp 「戻る」ボタン押下時
			case "ReturnToInput":
				// 既存のセッション取得
				HttpSession sessionReturnToInput = request.getSession(false);
				// エラーメッセージ削除
				sessionReturnToInput.removeAttribute("renewCertFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.RENEW_INPUT);
				break;
				
			// RenewCert.sjsp 「更新する」ボタン押下時
			case "ExecuteRenew":
				// 既存のセッション取得
				HttpSession sessionExecuteRenew = request.getSession(false);
				// セッションから情報取得
				UsersBean execUsersBean = (UsersBean)sessionExecuteRenew.getAttribute("usersBean");
				String sexStr = (String) sessionExecuteRenew.getAttribute("sexStr");
				String birthdayStr = (String) sessionExecuteRenew.getAttribute("birthdayStr");
				
				// nullチェック
				if(execUsersBean.getName() == null || execUsersBean.getPass() == null || execUsersBean.getEmail() == null ||
					execUsersBean.getName().length() == 0 || execUsersBean.getPass().length() == 0 || execUsersBean.getEmail().length() == 0 ||
					sexStr.length() == 0 || birthdayStr.length() == 0) {
					sessionExecuteRenew.setAttribute("renewCertFailureMessage", ErrorMessage.registerRenewIncompleteInputs);
					Common.gotoPage(request, response, PagesAndUrls.RENEW_CERT);
					break;
					
				}
				
				// 同一レコードチェック
				UsersDAO usersDaoCert = new UsersDAO();
				LoginInfo infoCert = (LoginInfo) sessionExecuteRenew.getAttribute("loginInfo");
				boolean isInitialRecordCert = usersDaoCert.checkRecordsForRenew(infoCert.getUsersid(), execUsersBean.getName(), execUsersBean.getEmail());
				if(!isInitialRecordCert) {
					sessionExecuteRenew.setAttribute("renewCertFailureMessage", ErrorMessage.registerRenewFailureMessage);
					Common.gotoPage(request, response, PagesAndUrls.RENEW_CERT);
					break;
					
				}
				
				// パスワードハッシュ化
				String password = execUsersBean.getPass();
				try {
					MessageDigest digest = MessageDigest.getInstance("SHA-1");
					byte[] result = digest.digest(password.getBytes());
					password = String.format("%040x", new BigInteger(1, result));
					
				} catch (Exception e){
					Common.gotoPage(request, response, PagesAndUrls.ERROR);
					
				}
				// パスワードをUsersBeanセット
				execUsersBean.setPass(password);
				
				// 更新実行(パスワードはハッシュ化)
				usersDaoCert.renew(infoCert.getUsersid(), execUsersBean.getName(), execUsersBean.getPass(), execUsersBean.getEmail());
				
				// セッションのAttribute削除
				sessionExecuteRenew.removeAttribute("usersBean");
				sessionExecuteRenew.removeAttribute("sexStr");
				sessionExecuteRenew.removeAttribute("birthdayStr");
				sessionExecuteRenew.removeAttribute("ageStr");
				sessionExecuteRenew.removeAttribute("renewCertFailureMessage");
				
				// LoginInfoの内容更新
				infoCert.setName(execUsersBean.getName());
				
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.MY_PAGE);		
				break;
				
			// ResignCert.jsp 「退会する」ボタン押下時
			case "Resign":
				// 既存のセッション取得
				HttpSession sessionResign = request.getSession(false);
				
				// チェックボックス確認
				String agree = request.getParameter("resign-agreement");
				if (agree == null || agree.length() == 0) {
					sessionResign.setAttribute("resignFailureMessage", ErrorMessage.resignCheckboxUnchecked);
					Common.gotoPage(request, response, PagesAndUrls.RESIGN_CERT);
					break;
					
				}
				// ユーザ情報の取得
				LoginInfo loginInfoResign = (LoginInfo) sessionResign.getAttribute("loginInfo");
				// 会員レコードの削除実行
				UsersDAO daoResign = new UsersDAO();
				daoResign.deleteUser(loginInfoResign.getUsersid());
				// セッション削除
				sessionResign.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.TOP);
				break;
				
			default:
				break;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			Common.gotoPage(request, response, PagesAndUrls.ERROR);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
