<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" charset="UTF-8">
		<title>TOP</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
	</head>
	
	<body>
		<c:choose>
			<c:when test="${loginInfo.isLogin() eq true}">
				<jsp:include page="/pages/headers/loggedHeader.jsp"/><br></c:when>
			<c:otherwise>
				<jsp:include page="/pages/headers/header.jsp"/><br></c:otherwise>
		</c:choose>
		
	</body>
</html>