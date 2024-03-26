package GoogleMap.Models.HotPepperAPIs.GourmetSearch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import org.json.JSONArray;
import org.json.JSONObject;

import GoogleMap.Bean.HotPepperAPIs.GourmetSearch.GourmetSearchApiBean;

public class GourmetSearchApiModel extends HttpServlet {
	// グルメサーチAPIのURL
		// key : APIキー
		// format : json/xml
		// count : 最大出力件数
		// order : ソート順 1→店名かな順
		// type : 出力タイプ lite→主要項目のみ出力
	public static String API_FOR_SHOP_SEARCH = "https://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=b8974cdcc1dc81b4&format=json&count=50&order=1&type=lite";
	
	// グルメサーチAPI呼び出し
	public static ArrayList<GourmetSearchApiBean> fetchGourmetSearch(String query) throws IOException {
		String fetchUrl = GourmetSearchApiModel.API_FOR_SHOP_SEARCH + query;
		ArrayList<GourmetSearchApiBean> array = new ArrayList<GourmetSearchApiBean>();
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(URI.create(fetchUrl)).build();
			client.sendAsync(request, BodyHandlers.ofString())
				.thenAccept(res -> {
					JSONObject resJson = new JSONObject(res.body());
					JSONArray shop = resJson.getJSONObject("results").getJSONArray("shop");
					
					// Beanに情報を格納し、配列に追加していく
					for (int i = 0; i < shop.length(); i ++) {
						JSONObject obj = shop.getJSONObject(i);
						JSONObject genreObj = obj.getJSONObject("genre");
						JSONObject photoObj = obj.getJSONObject("photo").getJSONObject("pc");
						
						array.add(
							new GourmetSearchApiBean(
								obj.getString("id"),
								obj.getString("name"),
								obj.getString("address"),
								obj.getDouble("lat"),
								obj.getDouble("lng"),
								genreObj.getString("name"),
								genreObj.getString("catch"),
								obj.getString("catch"),
								obj.getString("access"),
								obj.getJSONObject("urls").getString("pc"),
								photoObj.getString("l"),
								photoObj.getString("m"),
								photoObj.getString("s")
							)
						);
					}
					System.out.print(array);
				}
			);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	

}
