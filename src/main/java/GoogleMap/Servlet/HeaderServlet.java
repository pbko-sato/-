package GoogleMap.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			
			switch(action) {
			// header.jsp/loggedHeader.jsp 「社内食べログ」リンク押下時
			case "TransitToTop":
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top/Top.jsp");
				break;
			
			// header.jsp 「ログイン」リンク押下時
			case "TransitToLogin":
				// 既存のセッション取得
				HttpSession sessionTransitToLogin = request.getSession(false);
				// セッション削除
				sessionTransitToLogin.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Login/Login.jsp");
				break;
				
			// header.jsp 「新規登録」リンク押下時
			case "TransitToRegister":
				// 既存のセッション取得
				HttpSession sessionTransitToRegister = request.getSession(false);
				// セッション削除
				sessionTransitToRegister.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Register/RegisterInput.jsp");
				break;
				
			// loggerHeader.jsp 「マイページ」リンク押下時
			case "TransitToMyPage":
				// 画面遷移
				Common.gotoPage(request, response, "pages/MyPage/MyPage.jsp"); 
				break;

			// loggedHeader.jsp 「ログアウト」リンク押下時
			case "Logout":
				// 既存のセッション取得
				HttpSession sessionLogout = request.getSession(false);
				// セッション削除
				sessionLogout.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top/Top.jsp");
				break;
				
				
			default:
				break;
			}
			
		} catch(Exception e) {
			Common.gotoPage(request, response, "/pages/Error.jsp");
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
