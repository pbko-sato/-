<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/MyPage/MyPage.css">
	</head>
	<body>
		<c:choose>
			<c:when test="${loginInfo.isLogin() eq true}">
				<jsp:include page="/pages/headers/loggedHeader.jsp"/><br></c:when>
			<c:otherwise>
				<jsp:include page="/pages/headers/header.jsp"/><br></c:otherwise>
		</c:choose>
		<div class="title">
			<h2>${loginInfo.getId()}. ${loginInfo.getName()}さんのマイページ</h2>
		</div>
		<hr>
		<hr>
		<div class="renew-and-resign">
			<ul class="mypage-footer-ul">
				<li class="mypage-footer-li"><a class="mypage-footer-link" href="/GoogleMap/MyPageServlet?action=TransitToRenewInput">会員情報更新</a></li>
				<li class="mypage-footer-li"><a class="mypage-footer-link" href="/GoogleMap/MyPageServlet?action=TransitToResignCert">退会</a></li>
			</ul>
		</div>
	</body>
</html>