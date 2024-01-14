<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>退会確認</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/MyPage/Resign.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/loggedHeader.jsp" />
		<div class="title">
			<h2>退会確認</h2>
		</div>
		<hr>
		<h4 class="resign-message">${ resignFailureMessage }</h4>
		<div class="resign-notion-text">
			<h3 class="resign-h3">本当に退会しますか?</h3>
			<ul class="resign-ul">
				<li class="resign-li">※会員情報は削除されます。</li>
				<li class="resign-li">※投稿は自動的には削除されません。退会後に自身の投稿を削除することはできなくなりますので、削除したい投稿は退会前に削除してください。</li>
			</ul>
		</div>
		<form action="?" method="post">
		<div class="resign-cert-checkbox">
			<input type="checkbox" name="resign-agreement" value="agree">
			<p class="resign-side-by-checkbox">上記事項を確認し、退会します。</p>
		</div>
		<button type="submit" class="return-button" formaction="/GoogleMap/MyPageServlet" name="action" value="ReturnToMyPage">マイページへ</button>
		<button type="submit" class="resign-button" formaction="/GoogleMap/MyPageServlet" name="action" value="Resign">退会する</button>
		</form>
	</body>
</html>