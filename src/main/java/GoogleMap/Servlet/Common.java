package GoogleMap.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Common extends HttpServlet {
	// 画面遷移
	public static void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
	}
	
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
			ageStr = "年齢が選択されていません";
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