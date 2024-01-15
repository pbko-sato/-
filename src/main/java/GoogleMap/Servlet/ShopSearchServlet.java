package GoogleMap.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GoogleMap.Models.Common;
import GoogleMap.Models.PagesAndUrls;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShopSearchServlet")
public class ShopSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSearchServlet() {
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
			// ShopSearch.jsp 「TOPへ」ボタン押下時
			case "ReturnToTop":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.TOP);
				break;
				

			// ShopSearch.jsp 「結果を確認する」ボタン押下時
			case "GoToResult":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOR_SEARCH_RESULTS);
				break;


			// ShopSearch.jsp 「エリアを指定する」ボタン押下時
			case "TransitToArea":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;
				

			// ShopAreaSearch.jsp 「投稿検索へ戻る」ボタン押下時
			case "ReturnToShopSearch":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_SEARCH);
				break;

				
			// ShopAreaSearch.jsp エリア1「設定する」ボタン押下時
			case "setArea1":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;
				
			// ShopAreaSearch.jsp エリア2「設定する」ボタン押下時
			case "setArea2":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;
				
			// ShopAreaSearch.jsp エリア3「設定する」ボタン押下時
			case "setArea3":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;
				
			// ShopAreaSearch.jsp エリア1「クリア」ボタン押下時
			case "clearArea1":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;
				
			// ShopAreaSearch.jsp エリア2「クリア」ボタン押下時
			case "clearArea2":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;
				
			// ShopAreaSearch.jsp エリア3「クリア」ボタン押下時
			case "clearArea3":
				// 画面遷移
				Common.gotoPage(request, response, PagesAndUrls.SHOP_AREA_SEARCH);
				break;


			
			default:
				break;
			}
			
		} catch(Exception e) {
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
