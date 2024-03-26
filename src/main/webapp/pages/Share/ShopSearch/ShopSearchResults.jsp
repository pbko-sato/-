<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>投稿検索結果</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/Share/ShopSearch.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/loggedHeader.jsp"/>
		<div class="title">
			<h2>投稿検索結果</h2>
		</div>
		<hr>
		<div class="shop-search-results-contents">
			<ul class="shop-search-results-ul">
				<c:if test="${ empty gourmetSearchApiBeanList }">
					<li class="shop-search-results-empty">
						<p>条件に一致するお店が見つかりませんでした。</p>
						<p>検索条件を変えて、もう一度検索して下さい。</p>
					</li>
				</c:if>
				
				<c:if test="${ not empty gourmetSearchApiBeanList }">
					<c:forEach items="${ gourmetSearchApiBeanList }" var="bean">
						<li class="shop-search-results-list">
							<div class="list-shop-name">
								<h3>${ bean.name }</h3>
								<p class="shop-results-chatch">${ bean.shopCatch }</p>
							</div>
							<div class="shop-info-box">
								<div class="shop-photo">
									<img src="${ bean.photoPcL }">
								</div>
								<div class="shop-info-table">
									<table>
										<tr class="shop-results-tr">
											<th class="shop-results-th">
												<span>お店のジャンル</span>
											</th>
											<td class="shop-results-td">
												<p class="shop-results-table-p">${ bean.genreName }</p>
												<p class="shop-results-table-p">${ bean.genreCatch }</p>
											</td>
										</tr>
										<tr class="shop-results-tr">
											<th class="shop-results-th">
												<span>住所・アクセス</span>
											</th>
											<td class="shop-results-td">
												<p class="shop-results-table-p">${ bean.address }</p>
												<p class="shop-results-table-p">${ bean.access }</p>
												<a href="https://www.google.com/maps/search/?api=1&query=${ bean.lat }%2C${ bean.lng}" target="_blank">
													地図で見る
												</a>
											</td>
										</tr>
										<td colspan="2" class="shop-results-td">
											<a href="${ bean.urlsPc }" target="_blank">お店を予約する (HotPepperに遷移します)</a>
										</td>
									</table>
								</div>
							</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<div class="shop-search-results-button">
				<form action="?" method="post">
					<button type="submit" class="return-button" formaction="/GoogleMap/ShopSearchServlet" name="action" value="ReturnToShopSearch">
						検索条件を修正する
					</button>
				</form>
			</div>
		</div>
	</body>
</html>