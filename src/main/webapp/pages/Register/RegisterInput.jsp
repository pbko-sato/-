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
		<jsp:include page="/pages/headers/header.jsp"/>
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
				<table class="register-input-table">
					<tbody>
						<tr class="input-table-tr">
							<td class="input-table-td register-table-labels">
								<label class="register-pulldown-label">
									性別 :
								</label>
							</td>
							<td class="input-table-td">
								<div class="register-td-age">
									<select name="sex">
										<option value="0"></option>
										<option value="1">男性</option>
										<option value="2">女性</option>
										<option value="3">その他</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="input-table-tr">
							<td class="input-table-td register-table-labels">
								<label class="register-pulldown-label">
									生年月日 :
								</label>
							</td>
							<td class="input-table-td">
								<div class="register-td-birthday">
									<div class="year-pulldown">
										<select name="year">
											<option value="0"></option>
											<c:forEach var="h" begin="1924" end="1990" step="1">
												<option value="${ h }">${ h }</option>
											</c:forEach>
											<option value="0" selected></option>
											<c:forEach var="h" begin="1991" end="2024" step="1">
												<option value="${ h }">${ h }</option>
											</c:forEach>
										</select>
										<label class="birthday-pulldown-label">
											年 
										</label>
									</div>
									<div class="month-pulldown">
										<select name="month">
											<option value="0"></option>
											<c:forEach var="i" begin="1" end="12" step="1">
												<option value="${ i }">${ i }</option>
											</c:forEach>
										</select>
										<label class="birthday-pulldown-label">
											月 
										</label>
									</div>
									<div class="date-pulldown">
										<select name="date">
											<option value="0"></option>
											<c:forEach var="j" begin="1" end="31" step="1">
												<option value="${ j }">${ j }</option>
											</c:forEach>
										</select>
										<label class="birthday-pulldown-label">
											日
										</label>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<p class="notion-text">※性別・生年月日は登録後の変更ができません。</p>	
				<button type="submit" class="return-button" formaction="/GoogleMap/RegisterServlet" name="action" value="ReturnToTop">TOPへ</button>
				<button type="submit" class="register-button" formaction="/GoogleMap/RegisterServlet" name="action" value="GoToCert">確認する</button>
			</form>		
		</div>
	</body>
</html>