package GoogleMap.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GoogleMap.Bean.LoginInfo;
import GoogleMap.DAO.UsersDAO;

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
		// actionによる処理分岐
		try {
			String action = request.getParameter("action");
			
			switch(action) {
			// MyPage.jsp 「会員情報更新」リンク押下時
			case "TransitToRenewInput":
				break;
				
			// MyPage.jsp 「退会」リンク押下時
			case "TransitToResignCert":
				// 画面遷移
				Common.gotoPage(request, response, "/pages/MyPage/Resign/ResignCert.jsp");
				break;
				
			// ResignCert.jsp 「マイページへ」ボタン押下時
			case "ReturnToMyPageFromResignCert":
				//既存のセッション取得
				HttpSession sessionReturnToMyPageFromResignCert = request.getSession(false);
				// エラーメッセージ削除
				sessionReturnToMyPageFromResignCert.removeAttribute("resignFailureMessage");
				// 画面遷移
				Common.gotoPage(request, response, "/pages/MyPage/MyPage.jsp");
				break;
				
			// ResignCert.jsp 「退会する」ボタン押下時
			case "Resign":
				// 既存のセッション取得
				HttpSession sessionResign = request.getSession(false);
				
				// チェックボックス確認
				String agree = request.getParameter("resign-agreement");
				if (agree == null || agree.length() == 0) {
					sessionResign.setAttribute("resignFailureMessage", ErrorMessage.resignCheckboxUnchecked);
					Common.gotoPage(request, response, "/pages/MyPage/Resign/ResignCert.jsp");
					break;
					
				}
				// ユーザ情報の取得
				LoginInfo loginInfo = (LoginInfo) sessionResign.getAttribute("loginInfo");
				// 会員レコードの削除実行
				UsersDAO daoResign = new UsersDAO();
				daoResign.deleteUser(loginInfo.getUsersid());
				// セッション削除
				sessionResign.invalidate();
				// 画面遷移
				Common.gotoPage(request, response, "/pages/Top/Top.jsp");
				break;
				
			default:
				break;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
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
