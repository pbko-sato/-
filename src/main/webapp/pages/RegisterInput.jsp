<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規登録 入力</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/Register/Register.css">
	</head>
	<body>
		<jsp:include page="./headers/header.jsp"/>
		<div class="title">
			<h2>新規登録 入力</h2>
		</div>
		<hr>
		<div>
			<h4 class="register-input-message">${ registerInputFailureMessage }</h4>
			<form action="?" method="post">
				<div class="input-for-username">
					<input type="text" name="username" placeholder="ユーザ名" pattern="^[a-zA-Z0-9-=^~@;+:*,._]+$" maxlength="15" value="${ usersBean.name }">			
				</div>
				<div class="input-for-password">
					<input type="password" name="password" placeholder="パスワード" maxlength="15">		
					<input type="password" name="passwordCert" placeholder="パスワード(確認用)" maxlength="15">		
					<p class="notion-text">※ユーザ名・パスワードは、半角英数字または「-=^~@;+:*,._」15文字以内で入力してください。</p>		
				</div>
				<div class="input-for-email">
					<input type="email" name="email" placeholder="メールアドレス" value="${ usersBean.email }">			
				</div>
				<div class="sex-pulldown"> 
					<label>
						性別 :
					</label>
					<select name="sex">
						<option value="0"></option>
						<option value="1">男性</option>
						<option value="2">女性</option>
						<option value="3">その他</option>
					</select>
				</div>
				<div class="age-pulldown"> 
					<label>
						年齢 :
					</label>
					<select name="age">
						<option value="0"></option>
						<option value="10">10代以下</option>
						<option value="20">20代</option>
						<option value="30">30代</option>
						<option value="40">40代</option>
						<option value="50">50代</option>
						<option value="60">60代</option>
						<option value="70">70代以上</option>
					</select>
				</div>
				<button type="submit" class="return-button" formaction="/GoogleMap/RegisterServlet" name="action" value="ReturnToTop">TOPへ</button>
				<button type="submit" class="register-button" formaction="/GoogleMap/RegisterServlet" name="action" value="GoToCert">確認する</button>
			</form>		
		</div>
	</body>
</html>