package GoogleMap.Models;

public class PagesAndUrls {
	// ページURL
	// TOP
	public static String TOP = "/pages/Top/Top.jsp";
	// ログイン
	public static String LOGIN = "/pages/Login/Login.jsp";
	// 会員登録入力
	public static String REGISTER_INPUT = "/pages/Register/RegisterInput.jsp";
	// 会員登録確認
	public static String REGISTER_CERT = "/pages/Register/RegisterCert.jsp";
	// マイページ
	public static String MY_PAGE = "/pages/MyPage/MyPage.jsp";
	// 会員情報更新入力
	public static String RENEW_INPUT = "/pages/MyPage/Renew/RenewInput.jsp";
	// 会員情報更新確認
	public static String RENEW_CERT = "/pages/MyPage/Renew/RenewCert.jsp";
	// 退会確認
	public static String RESIGN_CERT = "/pages/MyPage/Resign/ResignCert.jsp";
	// 投稿検索
	public static String SHOP_SEARCH = "/pages/Share/ShopSearch/ShopSearch.jsp";
	// 投稿エリア検索
	public static String SHOP_AREA_SEARCH = "/pages/Share/ShopSearch/ShopAreaSearch.jsp";
	// 投稿検索結果確認
	public static String SHOR_SEARCH_RESULTS = "/pages/Share/ShopSearch/ShopSearchResults.jsp";
	// エラー
	public static String ERROR = "/pages/Error.jsp";
	
	
	// HotPepperAPIのURL
	// グルメサーチAPI
		// key : APIキー
		// format : json/xml
		// count : 最大出力件数
		// order : ソート順 1→店名かな順
		// type : 出力タイプ lite→主要項目のみ出力
	public static String API_FOR_SHOP_SEARCH = "https://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=b8974cdcc1dc81b4&format=json&count=50&order=1&type=lite";
}