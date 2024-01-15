<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>投稿検索</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/Share/ShopSearch.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/loggedHeader.jsp"/>
		<div class="title">
			<h2>投稿検索</h2>
		</div>
		<hr>
		<div class="shop-search-contents">
			<h4 class="shop-search-message">${ shopSearchMessage }</h4>
			<ul class="shop-search-ul">
				<li class="shop-search-li">投稿したいお店の特徴を入力してください。Hot Pepperグルメの情報をもとに検索します。</li>
				<li class="shop-search-li">※一項目以上は入力してください。</li>
			</ul>
			<form action="?" method="post">
				<table class="shop-search-inputs">
					<tr class="input-for-keyword">
						<th>
							<label>
								フリーワード<br>
								(店名、住所、駅名、お店キャッチコピー)
							</label>
						</th>
						<td>
							<input type="text" name="keyword" placeholder="フリーワード">
						</td>
					</tr>
					<tr class="input-for-name_any">
						<th>
							<label>
								お店の名前(部分一致)
							</label>
						</th>
						<td>
							<input type="text" name="name_any" placeholder="お店の名前">				
						</td>
					</tr>
					<tr class="input-for-address">
						<th>
							<label>
								お店の住所
							</label>
						</th>
						<td>
							<input type="text" name="address" placeholder="お店の住所">
						</td>
					</tr>
					<tr class="input-for-tel">
						<th>
							<label>
								お店の電話番号<br>
								(ハイフンなし)
							</label>
						</th>
						<td>
							<input type="tel" name="tel" pattern="^[0-9]+$" placeholder="お店の電話番号">
						</td>
					</tr>
					<tr class="input-for-genre">
						<th>
							<label>
								お店のジャンル
							</label>
						</th>
						<td>
							<select name="genre">
								<option value=""></option>
								<option value="G001">居酒屋</option>
								<option value="G002">ダイニングバー・バル</option>
								<option value="G003">創作料理</option>
								<option value="G004">和食</option>
								<option value="G005">洋食</option>
								<option value="G006">イタリアン・フレンチ</option>
								<option value="G007">中華</option>
								<option value="G008">焼肉・ホルモン</option>
								<option value="G009">アジア・エスニック料理</option>
								<option value="G010">各国料理</option>
								<option value="G011">カラオケ・パーティ</option>
								<option value="G012">バー・カクテル</option>
								<option value="G013">ラーメン</option>
								<option value="G014">カフェ・スイーツ</option>
								<option value="G015">その他グルメ</option>
								<option value="G016">お好み焼き・もんじゃ</option>
								<option value="G017">韓国料理</option>
							</select>
						</td>
					</tr>
					<tr class="input-for-area">
						<th>
							<div class="th-for-area-search">
								<label>
									お店のエリア
								</label>
								<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="TransitToArea">
									エリアを指定する
								</button>
							</div>
						</th>
						<td>
							
							<input type="hidden" name="large-area" value=""> 
							<input type="hidden" name="middle-area" value=""> 
							<input type="hidden" name="small-area" value=""> 
						</td>
					</tr>
				</table>
				<div class="shop-search-buttons">
					<button type="submit" class="return-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="ReturnToTop">TOPへ</button>
					<button type="submit" class="share-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="GoToResult">結果を確認する</button>
				</div>
			</form>
		</div>
	</body>
</html>