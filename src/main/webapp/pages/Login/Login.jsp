<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/Login/Login.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/header.jsp"/>
		<div class="title">
			<h2>ログイン</h2>
		</div>
		<hr>
		<div>
			<h4 class="login-message">${ loginFailureMessage }</h4>
			<form action="?" method="post">
				<div>
					<input type="text" name="username" placeholder="ユーザ名" pattern="^[a-zA-Z0-9]+$">				
				</div>
				<div>
					<input type="password" name="password" placeholder="パスワード">				
				</div>
				<button type="submit" class="return-button" formaction="/GoogleMap/LoginServlet" name="action" value="returnToTop">TOPへ</button>
				<button type="submit" class="login-button" formaction="/GoogleMap/LoginServlet" name="action" value="Login">ログインする</button>
			</form>		
		</div>
		<div>
			<p>会員登録は <a href="/GoogleMap/RegisterServlet?action=TransitToRegister">こちら</a></p>
		</div>
	</body>
</html>