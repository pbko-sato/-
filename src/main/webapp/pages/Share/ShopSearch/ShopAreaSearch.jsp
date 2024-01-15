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
			<h2>投稿エリア検索</h2>
		</div>
		<hr>
		<div class="shop-area-search-contents">
			<ul class="shop-area-search-ul">
				<li class="shop-area-search-li">投稿したいお店のエリアを選択してください。</li>
				<li class="shop-area-search-li">エリア1～3を順に選択し、「設定する」ボタンを押してください。</li>
				<li class="shop-area-search-li">エリア1のみ、エリア1・エリア2のみの選択でも問題ありません。</li>
			</ul>
			<table class="shop-area-search-table">
				<tr class="shop-area-tr">
					<form action="?" method="post">
						<th>
							<label>
								エリア1 (都道府県など)
							</label>
							<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="setArea1">
								設定する
							</button>
						</th>
						<td>
						
							<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="clearArea1">
								クリア
							</button>
						</td>
					</form>
				</tr>
				<tr class="shop-area-tr">
					<form action="?" method="post">
						<th>
							<label>
								エリア2 (市区町村・地区など)
							</label>
							<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="setArea2">
								設定する
							</button>
						</th>
						<td>
						
							<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="clearArea2">
								クリア
							</button>
						</td>
					</form>
				</tr>
				<tr class="shop-area-tr">
					<form action="?" method="post">
						<th>
							<label>
								エリア3 (駅など)
							</label>
							<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="setArea3">
								設定する
							</button>
						</th>
						<td>
						
							<button type="submit" class="mini-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="clearArea3">
								クリア
							</button>
						</td>
					</form>
				</tr>
			</table>
			<div class="shop-search-buttons">
				<form action="?" method="post">
					<input type="hidden" name="large_area" value="">
					<input type="hidden" name="middle_area" value="">
					<input type="hidden" name="small_area" value="">
					<button type="submit" class="return-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="ReturnToShopSearch">投稿検索へ戻る</button>
				</form>
			</div>
		</div>
	</body>
</html>