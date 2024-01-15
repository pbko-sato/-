<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規登録 確認</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/Register/Register.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/header.jsp"/>
		<div class="title">
			<h2>新規登録 確認</h2>
		</div>
		<hr>
		<div class="table-for-register-cert">
		<h4 class="register-cert-message">${ registerCertFailureMessage }</h4>
			<table class="register-cert-table">
				<tr class="cert-table-tr">
					<th class="cert-table-td">
						<label>
							ユーザ名
						</label>
					</th>
					<td class="cert-table-td">
						${ usersBean.name }
					</td>
				</tr>
				<tr class="cert-table-tr">
					<th class="cert-table-td">
						<label>
							メールアドレス						
						</label>
					</th>
					<td class="cert-table-td">
						${ usersBean.email }
					</td>
				</tr>
				<tr class="cert-table-tr">
					<th class="cert-table-td">
						<label>
							性別
						</label>
					</th>
					<td class="cert-table-td">
						${ sexStr }
					</td>
				</tr>
				<tr class="cert-table-tr">
					<th class="cert-table-td">
						<label>
							年齢
						</label>
					</th>
					<td class="cert-table-td">
						${ birthdayStr }
					</td>
				</tr>
			</table>
		</div>
		<div>
			<form action="?" method="post">
				<button type="submit" class="return-button" formaction="/GoogleMap/RegisterServlet" name="action" value="ReturnToInput">戻る</button>
				<button type="submit" class="register-button" formaction="/GoogleMap/RegisterServlet" name="action" value="ExecuteRegister">登録する</button>
			</form>
		</div>
	</body>
</html>