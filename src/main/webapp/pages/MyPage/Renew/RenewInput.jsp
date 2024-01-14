<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会員情報更新 入力</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/MyPage/Renew.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/loggedHeader.jsp"/>
		<div class="title">
			<h2>会員情報更新 入力</h2>
		</div>
		<hr>
		<div>
			<h4 class="renew-input-message">${ renewInputFailureMessage }</h4>
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
				<table class="renew-input-table">
					<tbody>
						<tr class="input-table-tr">
							<td class="input-table-td renew-table-labels">
								<label class="renew-label">
									性別 :
								</label>
							</td>
							<td class="input-table-td">
								<div class="renew-td-sex">
									${ sexStr }
								</div>
							</td>
						</tr>
						<tr class="input-table-tr">
							<td class="input-table-td renew-table-labels">
								<label class="renew-label">
									生年月日 :
								</label>
							</td>
							<td class="input-table-td">
								<div class="renew-td-birthday">
									${ birthdayStr } &nbsp;(${ ageStr }歳)
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<p class="notion-text">※性別・生年月日は変更できません。</p>	
				<button type="submit" class="return-button" formaction="/GoogleMap/MyPageServlet" name="action" value="ReturnToMyPage">マイページへ</button>
				<button type="submit" class="renew-button" formaction="/GoogleMap/MyPageServlet" name="action" value="GoToCert">確認する</button>
			</form>		
		</div>
	</body>
</html>