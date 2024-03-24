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
import GoogleMap.DAO.UsersDAO;
import GoogleMap.Models.Common;
import GoogleMap.Models.ErrorMessage;
import GoogleMap.Models.PagesAndUrls;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		// 送信するレスポンスパラメータの文字コードを指定
		response.setContentType("text/html;charset=UTF-8");

		// actionによる処理分岐
		try {
			String action = request.getParameter("action");
			
			switch(action) {
			// Login.jsp 「TOPへ」ボタン押下時
			case "returnToTop":
				// 既存のセッション取得
				HttpSession sessionReturnToTop = request.getSession(false);
				// セッション削除
				sessionReturnToTop.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.TOP);
				break;
				
				
			// Login.jsp 「ログインする」ボタン押下時
			case "Login":
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				//ハッシュ化
				try {
					MessageDigest digest = MessageDigest.getInstance("SHA-1");
					byte[] result = digest.digest(password.getBytes());
					password = String.format("%040x", new BigInteger(1, result));
					
				} catch (Exception e){
					e.printStackTrace();
					Common.gotoPage(request, response, PagesAndUrls.ERROR);
					
				}
				
				// koki, passでログイン
				System.out.print(password);
				// 既存のセッション取得
				HttpSession sessionLogin = request.getSession(false);
				UsersDAO usersDao = new UsersDAO();
				LoginInfo loginInfo = usersDao.loginAndGetLoginInfo(username, password);
				
				// ログイン成功時
				if(loginInfo.isLogin()) {
					sessionLogin.removeAttribute("loginFailureMessage");
					// セッションにログイン情報付加
					sessionLogin.setAttribute("loginInfo", loginInfo);
					Common.gotoPage(request, response, PagesAndUrls.TOP);
				
				// ログイン失敗時
				} else {
					sessionLogin.setAttribute("loginFailureMessage", ErrorMessage.loginFailureMessage);
					Common.gotoPage(request, response, PagesAndUrls.LOGIN);
				}
				break;
				
			// Login.jsp 「こちら」リンク押下時
			case "TransitToRegister":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.REGISTER_INPUT);
				break;

			default:
				break;
			}
			
		} catch (Exception e) {
			Common.gotoPage(request, response, PagesAndUrls.ERROR);
		}
		
	}

}
