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
		<link rel="stylesheet" href="/GoogleMap/css/Register/Register.css">
	</head>
	<body>
		<jsp:include page="./headers/header.jsp"/>
		<div class="title">
			<h2>新規登録 確認</h2>
		</div>
		<hr>
		<div>
		<h4 class="register-cert-message">${ registerCertFailureMessage }</h4>
			<table class="register-cert-table">
				<tr class="cert-username">
					<td class="label">
						ユーザ名
					</td>
					<td>
						${ usersBean.name }
					</td>
				</tr>
				<tr class="cert-email">
					<td class="label">
						メールアドレス
					</td>
					<td>
						${ usersBean.email }
					</td>
				</tr>
				<tr class="cert-sex">
					<td class="label">
						性別
					</td>
					<td>
						${ sexStr }
					</td>
				</tr>
				<tr class="cert-age">
					<td class="label">
						年齢
					</td>
					<td>
						${ ageStr }
					</td>
				</tr>
			</table>
		</div>
		<div>
			<form action="/GoogleMap/RegisterServlet" method="post">
				<button type="submit" class="return-button" formaction="/GoogleMap/RegisterServlet" name="action" value="ReturnToInput">戻る</button>
				<button type="submit" class="register-button" formaction="/GoogleMap/RegisterServlet" name="action" value="ExecuteRegister">登録する</button>
			</form>
		</div>
	</body>
</html>