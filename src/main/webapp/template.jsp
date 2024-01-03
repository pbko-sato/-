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
	</head>
	<body>
		<c:choose>
			<c:when test="${loginInfo.isLogin() eq true}">
				<jsp:include page="./headers/loggedHeader.jsp"/><br></c:when>
			<c:otherwise>
				<jsp:include page="./headers/header.jsp"/><br></c:otherwise>
		</c:choose>
		<div class="title">
			<h2></h2>
		</div>
		<hr>
	</body>
</html>