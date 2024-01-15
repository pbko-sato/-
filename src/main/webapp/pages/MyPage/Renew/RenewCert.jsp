<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会員情報更新 確認</title>
		<link rel="stylesheet" href="/GoogleMap/css/header/header.css">
		<link rel="stylesheet" href="/GoogleMap/css/main.css">
		<link rel="stylesheet" href="/GoogleMap/css/MyPage/Renew.css">
	</head>
	<body>
		<jsp:include page="/pages/headers/loggedHeader.jsp"/>
		<div class="title">
			<h2>会員情報更新 確認</h2>
		</div>
		<hr>
		<div class="table-for-renew-cert">
		<h4 class="renew-cert-message">${ renewCertFailureMessage }</h4>
			<table class="renew-cert-table">
				<tr class="cert-table-tr">
					<td class="cert-table-td">
						<label>
							ユーザ名						
						</label>
					</td>
					<td class="cert-table-td">
						${ usersBean.name }
					</td>
				</tr>
				<tr class="cert-table-tr">
					<td class="cert-table-td">
						<label>
							メールアドレス						
						</label>
					</td>
					<td class="cert-table-td">
						${ usersBean.email }
					</td>
				</tr>
				<tr class="cert-table-tr">
					<td class="cert-table-td">
						<label>
							性別						
						</label>
					</td>
					<td class="cert-table-td">
						${ sexStr }
					</td>
				</tr>
				<tr class="cert-table-tr">
					<td class="cert-table-td">
						<label>
							年齢
						</label>
					</td>
					<td class="cert-table-td">
						${ birthdayStr } &nbsp;(${ ageStr }歳)
					</td>
				</tr>
			</table>
		</div>
		<div>
			<form action="?" method="post">
				<button type="submit" class="return-button" formaction="/GoogleMap/MyPageServlet" name="action" value="ReturnToInput">戻る</button>
				<button type="submit" class="renew-button" formaction="/GoogleMap/MyPageServlet" name="action" value="ExecuteRenew">更新する</button>
			</form>
		</div>
	</body>
</html>